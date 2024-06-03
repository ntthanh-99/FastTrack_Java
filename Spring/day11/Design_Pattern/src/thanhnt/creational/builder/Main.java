package thanhnt.creational.builder;

public class Main {
    public static void main(String[] args) {
        // Normal
        Car car = new Car("toyota", "sedan", "white", "2022", true, "1000");
        // step 5: Client call with builder
        Car carBuilder = new CarBuilder()
                .buildManufacturer("toyota")
                .buildType("sedan")
                .buildColor("white")
                .buildNew(true)
                .buildPrice("1000")
                .buildYear("2022")
                .build();

        System.out.println(carBuilder);
    }
}
