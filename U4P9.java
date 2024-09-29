/* Create two thread. One thread print ‘fybca’ 4 times and another thread print
‘sybca’ 6 times. Set priority for both thread and when thread finished print ‘tybca’
from main. */
class ThreadOne extends Thread {
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println("FYBCA");
        }
    }
}

class ThreadTwo extends Thread {
    public void run() {
        for (int i = 1; i <= 4; i++) {
            System.out.println("SYBCA");
        }
    }
}

class U4P9 {
    public static void main(String args[]) {
        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();

        threadOne.start();
        threadTwo.start();

        threadOne.setPriority(6);
        threadTwo.setPriority(3);
        System.out.println("TYBCA");
    }
}
