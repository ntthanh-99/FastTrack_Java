package day1.java_reflection;

import day1.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Hello", 18);

        // Get name of field
        Field[] fields = student.getClass().getDeclaredFields();
        List<String> nameOfFields = Arrays.stream(fields).map(field -> field.getName()).collect(Collectors.toList());
        System.out.println(nameOfFields);

        // Get name of method
        Method[] methods = student.getClass().getMethods();
        List<String> nameOfMethods = Arrays.stream(methods).map(method -> method.getName()).collect(Collectors.toList());
        System.out.println(nameOfMethods);

        // Get param Type of second method
        Method method = methods[1];
        Class[] classes = method.getParameterTypes();
        List<String> paramTypeOfMethod = Arrays.stream(classes).map(aClass -> aClass.getName()).collect(Collectors.toList());
        System.out.println(paramTypeOfMethod);
    }

}
