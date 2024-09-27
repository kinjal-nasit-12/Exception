/* Write an application that accepts marks of three different subjects from user.
Marks should be between 0 to 100, if marks of any of the subject do not belong to
this range, generate custom exception out of RangeException. If marks of each
subjects are greater than or equal to 40 then display message “PASS” along with
percentage, otherwise display message “FAIL”. Also write exception handling code
to catch all the possible runtime exceptions likely to be generated in the program.*/ 

import java.util.Scanner;
class RangeException extends Exception {

    public RangeException(String message) {
        super(message);
    }
}

public class U4P2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMarks = 0;
        try {
            printMessage("How many subjects do you want to enter marks for? ");
            int numberOfSubjects = getIntegerValue(scanner);

            if (numberOfSubjects <= 0) {
                throw new RangeException("Number of subjects must be greater than 0.");
            }

            int[] marks = new int[numberOfSubjects];
            boolean allPass = true;

            for (int i = 0; i < numberOfSubjects; i++) {
                try {
                    printMessage("Enter marks for Subject " + (i + 1) + ": ");
                    marks[i] = getIntegerValue(scanner);
                    totalMarks += marks[i];

                    if (marks[i] < 40) {
                        allPass = false;
                    }
                } catch (RangeException e) {
                    printMessage("\nError: " + e.getMessage());
                }
            }
            float percentage = (float) totalMarks / numberOfSubjects;

            if (allPass) {
                printMessage("\nPASS");
                printMessage("Total Marks: " + totalMarks);
                printMessage("Percentage: " + percentage);
            } else {
                printMessage("\nFAIL");
            }

        } catch (RangeException e) {
            printMessage("\nError: " + e.getMessage());
        } catch (Exception e) {
            printMessage("\nAn unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int getIntegerValue(Scanner scanner) throws RangeException {
        int marks = scanner.nextInt();
        if (marks < 0 || marks > 100) {
            throw new RangeException("Marks must be between 0 and 100.");
        }
        return marks;
    }
}
