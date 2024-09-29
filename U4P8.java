/* Write a java program to create 2 threads each thread calculates the sum and
average of 1 to 10 and 11 to 20 respectively. After all thread finish, main thread
should print message “ Task Completed”. Write this program with use of runnable
interface. */
class SumTask implements Runnable {

    public void run() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("Sum of numbers from 1 to 10: " + sum);
    }
}

class AverageTask implements Runnable {

    public void run() {
        int sum = 0;
        for (int i = 11; i <= 20; i++) {
            sum += i;
        }
        double average = sum / 10.0;
        System.out.println("Average of numbers from 11 to 20: " + average);
    }
}

public class U4P8 {

    public static void main(String[] args) {
        Thread sumThread = new Thread(new SumTask());
        Thread averageThread = new Thread(new AverageTask());
        sumThread.start();
        averageThread.start();
        try {
            sumThread.join();
            averageThread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Task Completed");
    }
}
