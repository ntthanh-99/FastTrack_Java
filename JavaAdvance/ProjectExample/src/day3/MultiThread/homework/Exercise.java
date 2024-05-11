package day3.MultiThread.homework;


public class Exercise {
    public static void main(String[] args) throws InterruptedException {
        // Calculate sum from 0 to 5000 with 5 thread
        // Solution 1: Divide to 5 part
        Model model = new Model();

        Thread[] threads1 = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads1[i] = new Thread(new Thread1((1000 * i) + 1, (i + 1) * 1000, model));
            threads1[i].start();
            threads1[i].join();
        }
        System.out.println("Sum: " + model.getSum());

        // Solution 2
        Counter counter = new Counter();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Thread2(counter));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Sum: " + counter.getSum());
        int sum = 0;
        for (int i = 0; i <= 5000; i++) {
            sum+=i;
        }

        System.out.println("Sum: " + sum);
    }
}
