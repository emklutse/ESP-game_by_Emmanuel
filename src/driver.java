
import java.util.Scanner;
import java.util.Random;

public class driver
{
    public static void main(String[] args)
    {
        final int INT_NUM_ITERATIONS = 10;

        int intPlayerChoice = -1;
        int intComputerChoice = -1;
        int intNumCorrect = 0;

        while (intPlayerChoice != 6)
        {
            for (int i = 0 ; i < INT_NUM_ITERATIONS ; i++)
            {
                intPlayerChoice = showMenu();

                if (intPlayerChoice == 6)
                {
                    break;
                }

                intComputerChoice = generateComputerSelection();

                if(compareSelections(intComputerChoice, intPlayerChoice) == true)
                {
                    System.out.println("That was a match!");
                    intNumCorrect++;
                }
                else if(compareSelections(intComputerChoice, intPlayerChoice) == false)
                {
                    System.out.println("That was not a match.");
                }
                else
                {
                    System.out.println("ERROR COMPARING VALUES");
                }
            }
            displayResults(INT_NUM_ITERATIONS, intNumCorrect);
        }
    }

    public static int showMenu()
    {
        int intMenuChoice = -1;

        Scanner scrKeyboard = new Scanner(System.in);

        while(intMenuChoice < 1 || intMenuChoice > 6)
        {
            System.out.println("Please select from the following menu options:");

            System.out.println("\t1. Red");
            System.out.println("\t2. Green");
            System.out.println("\t3. Blue");
            System.out.println("\t4. Orange");
            System.out.println("\t5. Yellow");
            System.out.println("\t6. Quit");

            intMenuChoice = scrKeyboard.nextInt();
        }

        return intMenuChoice;
    }

    public static int generateComputerSelection()
    {
        int intSelection;

        Random randomGenerator = new Random();

        intSelection = randomGenerator.nextInt(5) + 1;

        return intSelection;
    }

    public static boolean compareSelections(int intComputerChoice, int intPlayerChoice)
    {
        boolean booIsMatch = false;

        if (intComputerChoice == intPlayerChoice)
        {
            booIsMatch = true;
        }
        else if (intComputerChoice != intPlayerChoice)
        {
            booIsMatch = false;
        }
        else
        {
            System.out.println("ERROR COMPARING VALUES");
            booIsMatch = false;
        }

        return booIsMatch;
    }

    public static void displayResults(int intTotalNum, int intCorrectGuesses)
    {
        System.out.println("Out of a total of " + intTotalNum + " guesses, " +
                "you got " + intCorrectGuesses + " correct!");
    }
}
