package thanhnt.creational.builder;

// concrete builder
public class CarBuilder implements Builder{
    // Step 2: Concrete builder implement method
    private String manufacturer;
    private String type;
    private String color;
    private String year;
    private boolean isNew = true;
    private String price;

    @Override
    public CarBuilder buildManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    @Override
    public CarBuilder buildType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public CarBuilder buildColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public CarBuilder buildYear(String year) {
        this.year = year;
        return this;
    }

    @Override
    public CarBuilder buildNew(Boolean isNew) {
        this.isNew = isNew;
        return this;
    }

    @Override
    public CarBuilder buildPrice(String price) {
        this.price = price;
        return this;
    }

    // Step 3, 4: Product constructed by different builder
    @Override
    public Car build() {
        return new Car(manufacturer, type, color, year, isNew, price);
    }
}
