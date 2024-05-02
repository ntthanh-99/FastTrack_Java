package day3.MultiThread.synchonize;

import day3.MultiThread.CounterAtomic;

public class ThreadAtomicB implements Runnable{
    private CounterAtomic counter = null;
    public ThreadAtomicB(CounterAtomic counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": before value: " + counter.value());
        counter.decrement();
        System.out.println(threadName + ": after value: " + counter.value());
    }
}
