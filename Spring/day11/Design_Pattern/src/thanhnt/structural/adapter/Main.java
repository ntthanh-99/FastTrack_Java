package thanhnt.structural.adapter;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new RectangleAdapter(new LegacyRectangle());
        rectangle.draw(1, 1, 4, 4);
    }
}
