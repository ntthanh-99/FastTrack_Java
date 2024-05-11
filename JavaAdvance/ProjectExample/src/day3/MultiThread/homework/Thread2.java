package day3.MultiThread.homework;

public class Thread2 implements Runnable {
    private Counter counter;

    public Thread2(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.calSum();
        }
    }
}
