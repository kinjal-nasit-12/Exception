/* Write a program that create and starts five threads. Each thread is instantiated
from the same class. It executes a loop with ten iterations. Each iteration displays
the character 'x' and sleep for 500 milliseconds. The application waits for all
threads to complete and then display a message ‘hello’ */
class Mythread extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.print("\nx");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class U4P7 {

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Mythread());
            threads[i].start();
        }
        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("\nHello");
    }
}