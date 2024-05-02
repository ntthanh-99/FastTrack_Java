package day3.MultiThread.synchonize;

import day3.MultiThread.CounterAtomic;

public class ThreadAtomicA implements Runnable{
    private CounterAtomic counter;
    public ThreadAtomicA(CounterAtomic counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": before value: " + counter.value());
        counter.increment();
        System.out.println(threadName + ": after value: " + counter.value());
    }
}
