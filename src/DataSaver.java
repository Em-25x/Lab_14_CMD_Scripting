import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver
{

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        System.out.println("=== DataSaver: Create CSV Records ===");
        boolean cont = false;

        do
        {
            String first = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String last = SafeInput.getNonZeroLenString(in, "Enter Last Name");

            // Get ID and zero-pad it to 6 digits
            int idNum = SafeInput.getInt(in, "Enter ID Number (integer)");
            String idFormatted = String.format("%06d", idNum);

            String email = SafeInput.getNonZeroLenString(in, "Enter Email");

            int year = SafeInput.getInt(in, "Enter Year of Birth (4 digits)");

            // Build CSV record
            String record = first + ", " + last + ", " + idFormatted + ", " + email + ", " + year;
            records.add(record);

            cont = SafeInput.getYNConfirm(in, "Add another record?");

        } while (cont);

        // Ask for output file name
        String fileName = SafeInput.getNonZeroLenString(in, "Enter file name (without extension)");
        fileName += ".csv";

        Path filePath = Path.of("src", fileName);

        try
        {
            Files.write(filePath, records);
            System.out.println("\nData successfully saved to: " + filePath.toAbsolutePath());
        }
        catch (IOException e)
        {
            System.out.println("Error writing file!");
            e.printStackTrace();
        }
    }
}