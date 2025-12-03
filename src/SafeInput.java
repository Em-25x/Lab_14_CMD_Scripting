import java.util.Scanner;

public class SafeInput
{
    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    /**
     *
     *@param pipe Scanner object that you created in main in the usual way
     *@param prompt the message to display as the prompt for the input.
     *@return any integer
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        String trash = "";
        int newInt = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                newInt = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid integer, not: " + trash);
            }
        }while(!done);
        return newInt;
    }
    /**
     * @param pipe Scanner object that you created in main in the usual way
     * @param prompt the message to display as the prompt for the input.
     * @return any double
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        String trash = "";
        double newDouble = 0.0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                newDouble = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid double, not: " + trash);
            }
        }while(!done);
        return newDouble;
    }
    /**
     * @param pipe Scanner object that you created in main in the usual way
     * @param prompt is the message to display as the prompt for the input
     *    not including the [lo – hi] display
     * @param low the low value for the input range
     * @param high the high value for the input range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        String trash = "";
        int newInt = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt())
            {
                newInt = pipe.nextInt();
                pipe.nextLine();
                if(newInt < low || newInt > high)
                {
                    System.out.println("Please enter an integer in range [" + low + "-" + high + "], not: " + newInt);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid integer, not: " + trash);
            }
        }while(!done);
        return newInt;
    }
    /**
     * @param pipe Scanner object that you created in main in the usual way
     * @param prompt is the message to display as the prompt for the input
     *    not including the [lo – hi] display
     * @param low the low value for the input range
     * @param high the high value for the input range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        String trash = "";
        double newDouble = 0;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble())
            {
                newDouble = pipe.nextDouble();
                pipe.nextLine();
                if (newDouble < low || newDouble > high)
                {
                    System.out.println("Please enter a number in range [" + low + "-" + high + "], not: " + newDouble);
                }
                else
                {
                    done = true;
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("Please enter a valid number, not: " + trash);
            }
        } while (!done);
        return newDouble;
    }
    /**
     * @param pipe Scanner object that you created in main
     * @param prompt message to display as the prompt for the input
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String trash = "";
        boolean done = false;
        boolean YN = false;
        String confirm = "";
        do
        {
            System.out.print("\n" + prompt + "[Y/N]: ");
            confirm = pipe.nextLine();
            if(confirm.equalsIgnoreCase("Y"))
            {
                YN = true;
                done = true;
            }
            else if (confirm.equalsIgnoreCase("N"))
            {
                YN = false;
                done = true;
            }
            else
            {
                System.out.println("Please enter a valid input [Y/N], not: " + confirm);
            }
        }while(!done);
        return YN;
    }
    /**
     * @param pipe Scanner object that you created in main in the usual way
     * @param prompt is the message to display as the prompt for the input.
     * @param regEx is the regEx pattern in java String format to use for matching
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String value = "";
        boolean done = false;
        do
        {
            System.out.print(prompt + ": ");
            value = pipe.nextLine();
            if (value.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("\nInvalid input: " + value);
            }
        } while (!done);
        return value;
    }
    /**
     * @param msg message to be displayed
     */
    public static void PrettyHeader(String msg)
    {
        for (int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
        System.out.println("\n");
        if (msg.length() % 2 == 1)
        {
            msg += " ";
        }

        int pad = (60 - msg.length())/2;

        System.out.printf("%-" + pad +"s" + msg + "%" + pad +"s \n","***","***");
        for(int i = 0; i < 60; i++)
        {
            System.out.print("*");
        }
    }
}