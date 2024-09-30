/* Write a program that accepts 5 even numbers from command
line , if any of the numbers is odd then throw custom exception
OddException and count such invalid numbers. */
class OddException extends Exception {

    String error;

    OddException() {
        error = "Number is odd.";
    }
}

class U4P5 {

    public static void main(String args[]) {
        if (args.length != 5) {
            System.out.println("Please enter exactly 5 numbers through command line.");
            return;
        }
        int numbers[] = new int[5];
        int invalidCount = 0;
        OddException object = new OddException();
        for (int i = 0; i < numbers.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
                if (numbers[i] % 2 != 0) {
                    invalidCount++;
                    throw object;
                }
            } catch (OddException e) {
                System.out.println("Odd/Invalid Number: " + numbers[i]);
            }
        }
        System.out.println("Number of invalid (odd) entries: " + invalidCount);
        if (invalidCount == 0) {
            System.out.println("All numbers are valid even numbers.");
        }
    }
}
