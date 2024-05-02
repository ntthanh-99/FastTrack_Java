package day3.MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic {
    // Atomic helpful for multiThread
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.getAndIncrement();
    }

    public void decrement() {
        c.getAndDecrement();
    }

    public int value() {
        return c.get();
    }
}
