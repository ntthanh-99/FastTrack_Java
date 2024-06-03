package thanhnt.creational.builder;

public class Car {
    private String manufacturer;
    private String type;
    private String color;
    private String year;
    private boolean isNew = true;
    private String price;

    public Car(String manufacturer, String type, String color, String year, boolean isNew, String price) {
        this.manufacturer = manufacturer;
        this.type = type;
        this.color = color;
        this.year = year;
        this.isNew = isNew;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", year='" + year + '\'' +
                ", isNew=" + isNew +
                ", price='" + price + '\'' +
                '}';
    }
}
