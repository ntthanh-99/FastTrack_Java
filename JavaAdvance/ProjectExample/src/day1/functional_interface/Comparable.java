package day1.functional_interface;

import day1.Student;

import java.util.Comparator;

public class Comparable implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
