package day3.MultiThread.synchonize;

import day3.MultiThread.Counter;
import day3.MultiThread.CounterAtomic;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new Thread(new ThreadA(counter));
        threadA.start();

        Thread threadB = new Thread(new ThreadB(counter));
        threadB.start();

        CounterAtomic counterAtomic = new CounterAtomic();
        Thread threadAtomicA = new Thread(new ThreadAtomicA(counterAtomic));
        //threadAtomicA.start();

        Thread threadAtomicB = new Thread(new ThreadAtomicB(counterAtomic));
        //threadAtomicB.start();

    }
}
