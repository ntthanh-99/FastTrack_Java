package thanhnt.creational.builder;

public interface Builder {
    // Step 1: builder interface declare car construction step
    CarBuilder buildManufacturer(String manufacturer);

    CarBuilder buildType(String type);

    CarBuilder buildColor(String color);

    CarBuilder buildYear(String year);

    CarBuilder buildNew(Boolean isNew);

    CarBuilder buildPrice(String price);

    Car build();
}
