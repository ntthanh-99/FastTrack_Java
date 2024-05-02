package day3.MultiThread;

public class Counter {
    private int c = 0;

    // synchronized method: when method is called by a thread, other thread is waiting
    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}

