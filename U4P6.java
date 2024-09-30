/* Write an application that starts two thread. First thread displays even numbers in
the range specified from the command line and second thread displays odd
numbers in the same range. Each thread waits for 300 milliseconds before
displaying the next numbers. The application waits for both the thread to finish and
then displays the message “Both threads completed”. */
class Even extends Thread {

    int ub, lb;

    Even(int l, int u) {
        lb = l;
        ub = u;
    }

    public void run() {
        for (int i = lb; i <= ub; i++) {
            if (i % 2 == 0) {
                System.out.println("Number " + i + " is even.");
            }
        }
    }
}

class Odd extends Thread {

    int ub, lb;

    Odd(int l, int u) {
        lb = l;
        ub = u;
    }

    public void run() {
        for (int i = lb; i <= ub; i++) {
            if (i % 2 != 0) {
                System.out.println("Number " + i + " is odd.");
            }
        }
    }
}

class U4P6 {

    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Please provide exactly 2 number by command line.");
            return;
        }
        int l = Integer.parseInt(args[0]);
        int u = Integer.parseInt(args[1]);
        Even even = new Even(l, u);
        Odd odd = new Odd(l, u);
        even.start();
        odd.start();
        try {
            even.join();
            odd.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Both threads have completed task.");
    }
}
