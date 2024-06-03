package thanhnt.structural.bridge;

public class Main {
    public static void main(String[] args) {
        Shape redCircle = new Circle();
        redCircle.setColor(new Red());

        System.out.println("Color: " + redCircle.getColor());
    }

}
