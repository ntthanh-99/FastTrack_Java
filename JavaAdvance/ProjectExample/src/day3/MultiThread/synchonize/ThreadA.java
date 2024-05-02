package day3.MultiThread.synchonize;

import day3.MultiThread.Counter;

import java.sql.SQLOutput;

public class ThreadA implements Runnable{
    private Counter counter = null;
    public ThreadA(Counter counter) {
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
