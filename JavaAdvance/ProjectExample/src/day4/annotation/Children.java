package day4.annotation;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@TestAnnotation(name = "KienNT", reviewer = {"ThanhNT"})
@TestAnnotation(name = "TruongND", reviewer = {"ThanhNT"})
public class Children extends Parent {
    @Override
    public void call() {
        System.out.println("Call from children");
    }

    //Overloading
    @Deprecated
    public void call(String name) {
        System.out.println("Call from " + name);
    }
}
