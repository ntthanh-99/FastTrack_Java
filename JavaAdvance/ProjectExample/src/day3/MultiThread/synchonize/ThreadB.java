package day3.MultiThread.synchonize;

import day3.MultiThread.Counter;

public class ThreadB implements Runnable{
    private Counter counter = null;
    public ThreadB(Counter counter) {
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
