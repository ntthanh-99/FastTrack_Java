package thanhnt.structural.facade;

public class Facade {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public Facade() {
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
    }

    // business
    public void drawShape() {
        circle.draw();
        square.draw();
        rectangle.draw();
        System.out.println("DONE!");
    }
}
