package day1.stream_api;

import day1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("student1", 18);
        Student student2 = new Student("student2", 17);
        Student student3 = new Student("student3", 19);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

        // Collect
        // name of student
        List<String> nameOfStudents = students.stream().map(student -> student.getName()).collect(Collectors.toList());
        System.out.println(nameOfStudents);
        // Filter
        // age >= 18
        List<Student> studentWithAges = students.stream().filter(student -> student.getAge() >= 18).collect(Collectors.toList());
        System.out.println(studentWithAges);

        // Sort
        // By age
        List<Student> studentByAges = students.stream().sorted((o1, o2) -> o1.getAge() - o2.getAge()).collect(Collectors.toList());
        System.out.println(studentByAges);
    }

}
