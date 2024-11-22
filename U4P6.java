/* Write an application that starts two thread. First thread displays even numbers in
the range specified from the command line and second thread displays odd
numbers in the same range. Each thread waits for 300 milliseconds before
displaying the next numbers. The application waits for both the thread to finish and
then displays the message “Both threads completed”. */
class EvenOdd extends Thread {

    int lb, ub;
    boolean isEven;

    EvenOdd(int l, int u, boolean isEven) {
        this.lb = l;
        this.ub = u;
        this.isEven = isEven;
    }

    public void run() {
        for (int i = lb; i <= ub; i++) {
            if ((isEven && i % 2 == 0) || (!isEven && i % 2 != 0)) {
                System.out.println("Number " + i + (isEven ? " is even." : " is odd."));
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class U4P6 {

    public static void main(String[] args) {
        int lb = 0;
        int ub = 0;

        try {

            if (args.length != 2) {
                System.out.println("Please provide exactly 2 integer numbers by command line.");
                return;
            }

            lb = Integer.parseInt(args[0]);
            ub = Integer.parseInt(args[1]);

            if (lb > ub) {
                System.out.println("Invalid range>> Lower bound is greater than upper bound.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter integer value. Exception>> " + e.getMessage());
            return;
        }

        EvenOdd even = new EvenOdd(lb, ub, true);
        EvenOdd odd = new EvenOdd(lb, ub, false);
        even.start();
        odd.start();

        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Both threads completed.");
    }
}
