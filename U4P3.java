/* Write a program which takes the age of 5 persons from command line and find the
average age of all persons. The program should handle exception if the argument
is not correctly formatted and custom exception if the age is not between 1 to 100. */

class AgeException extends Exception {

    public AgeException(String message) {
        super(message);
    }
}

public class U4P3 {

    public static void main(String[] args) {
        if (args.length != 5) {
            printMessage("Please provide exactly 5 ages as command line arguments.");
            return;
        }

        int totalAge = 0;

        for (int i = 0; i < args.length; i++) {
            try {
                int age = Integer.parseInt(args[i]);
                validateAge(age);
                totalAge += age;
            } catch (NumberFormatException e) {
                printMessage("Error: Age '" + args[i] + "' is not a valid number.");
            } catch (AgeException e) {
                printMessage("Error: " + e.getMessage());
            }
        }

        double averageAge = totalAge / 5.0;
        printMessage("The average age is: " + averageAge);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    private static void validateAge(int age) throws AgeException {
        if (age < 1 || age > 100) {
            throw new AgeException("Age must be between 1 and 100. Given: " + age);
        }
    }
}
