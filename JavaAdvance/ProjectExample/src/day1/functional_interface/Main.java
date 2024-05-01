package day1.functional_interface;

import day1.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("A", 18);
        Student student2 = new Student("B", 10);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        // Sort by age
        // Not using lambda function
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        // using class are defined
        students.sort(new Comparable());

        // using lambda function
        students.sort((o1, o2) -> o1.getAge() - o2.getAge());
    }
}
