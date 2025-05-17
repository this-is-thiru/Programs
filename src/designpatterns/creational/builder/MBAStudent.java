package designpatterns.creational.builder;

import java.util.List;

public class MBAStudent implements StudentBuilder {
    private String name;
    private int age;

    MBAStudent() {
    }

    public MBAStudent setName(String name) {
        this.name = name;
        return this;
    }

    public MBAStudent setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public Student build() {
        return new Student(this.name, this.age, List.of("MBA sub-1", "MBA sub-2"));
    }
}
