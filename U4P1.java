/* Write a Java program to input n integer numbers and display lowest and second
lowest number. Also handle the different exceptions possible to be thrown during
execution. */
import java.util.*;

class U4P1 {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        printMessage("Enter number of elements that you want to add: ");
        int n = getIntegerValue(scanner);
        printMessage("Enter " + n + " elements: ");
        int a[] = new int[n];

        try {
            for (int i = 0; i < n; i++) {
                a[i] = getIntegerValue(scanner);
            }
            Arrays.sort(a);
            printMessage("Array after sorting: " + Arrays.toString(a));
            printMessage("Lowest: " + a[0]);
            printMessage("Second Lowest: " + a[1]);
        } catch (Exception e) {
            printMessage("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int getIntegerValue(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                printMessage("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }
}
