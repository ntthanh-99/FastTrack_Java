package day4.annotation;

import jdk.nashorn.internal.objects.NativeArray;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        String str1 = "HELLO WORLD";
        String str2 = null;

        Children children = new Children();
        Annotation[] annotations = children.getClass().getAnnotations();
        for(Annotation annotation: annotations){
            // Print value of annotation
            System.out.println(annotation);
        }

       children.call("hello");
    }
}
