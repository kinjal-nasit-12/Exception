/* Write an application that starts two threads. Set priorities of both threads as 8 and
4 respectively. Each thread executes a loop with 5 iterations displaying its thread
name. Demonstrate the execution of a high priority thread and how it delays the
execution of low priority thread. */

class SimpleThread extends Thread {

    String threadType;

    public SimpleThread(String threadType) {
        this.threadType = threadType;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadType + " Thread: " + Thread.currentThread().getName() + " - Iteration " + i);
        }
    }
}

public class U4P10 {

    public static void main(String[] args) {
        SimpleThread highPriorityThread = new SimpleThread("High Priority");
        SimpleThread lowPriorityThread = new SimpleThread("Low Priority");

        highPriorityThread.setPriority(8);
        lowPriorityThread.setPriority(1);

        highPriorityThread.start();
        lowPriorityThread.start();
        System.out.println("Main thread execution completed.");
    }
}
