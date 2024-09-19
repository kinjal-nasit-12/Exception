/* Write a Java program to input n integer numbers and display lowest and second
lowest number. Also handle the different exceptions possible to be thrown during
execution. */
import java.util.Scanner;

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
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int t = a[i];
                        a[i] = a[j];
                        a[j] = t;
                    }
                }
            }
            printMessage("Array after sorting: ");
            for (int i = 0; i < a.length; i++) {
                printMessage("Array[" + i + "]= " + a[i]);
            }
            printMessage("Lowest: " + a[0]);
            printMessage("Second Lowest: " + a[1]);
        } catch (NumberFormatException e) {
            printMessage("Please enter only integer number.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printMessage("Array index is out of bounce");
        }
        scanner.close();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int getIntegerValue(Scanner scanner) {
        return scanner.hasNextInt() ? scanner.nextInt() : 0;
    }
}
