package thanhnt.creational.factory;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.createShape(ShapeFactory.SHAPE_TYPE.CIRCLE);
        circle.draw();

        Shape square = factory.createShape(ShapeFactory.SHAPE_TYPE.SQUARE);
        square.draw();

        Shape rectangle = factory.createShape(ShapeFactory.SHAPE_TYPE.RECTANGLE);
        rectangle.draw();
    }
}
