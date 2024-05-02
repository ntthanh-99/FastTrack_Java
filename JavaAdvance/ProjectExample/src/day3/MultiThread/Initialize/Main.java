package day3.MultiThread.Initialize;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        // Initialize
        Thread thread1 = new HelloThread();
        // Call method run
        thread1.start();

        Thread thread2 = new Thread(new HelloRunnable());
        thread2.start();
        //thread2.wait();

    }
}
