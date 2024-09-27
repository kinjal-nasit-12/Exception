import java.util.Scanner;
class RangeException extends Exception {
    public RangeException(String message) {
        super(message);
    }
}

public class U4P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalMarks=0;
        try {
            System.out.printf("How many subjects do you want to enter marks for? ", totalMarks);
            int numberOfSubjects = getIntegerValue(scanner);

            if (numberOfSubjects <= 0) {
                throw new RangeException("Number of subjects must be greater than 0.");
            }

            int[] marks = new int[numberOfSubjects];
            boolean allPass = true;

            for (int i = 0; i < numberOfSubjects; i++) {
                try {
                    System.out.printf("Enter marks for Subject " + (i + 1) + ": ", totalMarks);
                    marks[i] = getIntegerValue(scanner);
                    totalMarks += marks[i];

                    if (marks[i] < 40) {
                        allPass = false;
                    }
                } catch (RangeException e) {
                    System.out.printf("\nError: " + e.getMessage(), totalMarks);
                }
            }
            float percentage = (float) totalMarks / numberOfSubjects;

            if (allPass) {
                System.out.printf("\nPASS", totalMarks);
                System.out.printf("\nTotal Marks: %d", totalMarks);
                System.out.printf("\nPercentage: %.2f%%", percentage);
            } else {
                System.out.printf("\nFAIL", totalMarks);
            }

        } catch (RangeException e) {
            System.out.printf("\nError: " + e.getMessage(), totalMarks);
        } catch (Exception e) {
            System.out.printf("\nAn unexpected error occurred: " + e.getMessage(), totalMarks);
        } finally {
            scanner.close();
        }
    }

    public static int getIntegerValue(Scanner scanner) throws RangeException {
        int marks = scanner.nextInt();
        if (marks < 0 || marks > 100) {
            throw new RangeException("Marks must be between 0 and 100.");
        }
        return marks;
    }
}
