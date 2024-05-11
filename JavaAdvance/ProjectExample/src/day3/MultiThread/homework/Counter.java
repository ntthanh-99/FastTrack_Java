package day3.MultiThread.homework;

public class Counter {
    private int count;
    private int sum;

    public synchronized void calSum() {
        sum += ++count;
    }
    public int getSum() {
        return sum;
    }
}
