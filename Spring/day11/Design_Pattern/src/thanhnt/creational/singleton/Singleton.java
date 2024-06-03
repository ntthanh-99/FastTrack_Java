package thanhnt.creational.singleton;

public class Singleton {
    // static object
    private static Singleton instance = new Singleton();

    // private constructor
    private Singleton() {
    }

    // static method getInstance
    public static Singleton getInstance(){
        return instance;
    }

    // some other method
    public void showMessage(){
        System.out.println("HELLO WORLD!");
    }
}
