import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.File;

public class FileScan
{
    public static void main(String[] args)
    {
        Path filePath = null;

        //======== 1. CHECK FOR COMMAND LINE ARGUMENT ==========
        if (args.length == 1)
        {
            String fileName = args[0];
            File f = new File(fileName);

            if (!f.exists())
            {
                System.out.println("ERROR: File not found: " + fileName);
                return;
            }

            filePath = f.toPath();
            System.out.println("Opening file from command line: " + fileName);
        }
        else
        {
            //======== 2. NO ARG → USE JFILECHOOSER ==========
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Select a Text File to Inspect");
            chooser.setCurrentDirectory(new java.io.File(".")); // current directory

            int result = chooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION)
            {
                filePath = chooser.getSelectedFile().toPath();
            }
            else
            {
                System.out.println("File selection canceled.");
                return;
            }
        }

        //======== 3. SCAN THE FILE ==========
        System.out.println("Reading file: " + filePath.getFileName());
        System.out.println("--------------------------------------------");

        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try
        {
            for (String line : Files.readAllLines(filePath))
            {
                System.out.println(line); // echo the line
                lineCount++;

                // Count words
                if (!line.trim().isEmpty())
                {
                    String[] words = line.trim().split("\\s+");
                    wordCount += words.length;
                }

                // Count characters
                charCount += line.length();
            }

            //======== 4. SUMMARY REPORT ==========
            System.out.println("\n========= SUMMARY REPORT =========");
            System.out.println("File Name: " + filePath.getFileName());
            System.out.println("Total Lines: " + lineCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Total Characters: " + charCount);
            System.out.println("=================================");

        }
        catch (IOException e)
        {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
}