package day3.MultiThread.homework;

public class Thread1 implements Runnable {
    private int start;
    private int end;
    private Model model;

    public Thread1(int start, int end, Model model) {
        this.start = start;
        this.end = end;
        this.model = model;
    }

    @Override
    public void run() {
        model.calSum(calSum());
    }

    public int calSum() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}

class Model {
    private int sum;

    public synchronized void calSum(int value) {
        this.sum += value;
    }

    public int getSum() {
        return sum;
    }
}
