package day3.MultiThread.Initialize;

public class HelloThread extends Thread{
    @Override
    public void run() {
        try {
            // Interrupt all thread
            // 4000ms
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello from a thread!");
    }
}
