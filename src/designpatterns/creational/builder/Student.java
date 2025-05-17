package designpatterns.creational.builder;

import java.util.List;

public class Student {
    private final String name;
    private final int age;
    private final List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                '}';
    }
}
