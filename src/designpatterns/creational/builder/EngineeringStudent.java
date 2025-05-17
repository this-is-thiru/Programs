package designpatterns.creational.builder;

import javax.security.auth.Subject;
import java.util.List;

public class EngineeringStudent implements StudentBuilder {
    private String name;
    private int age;

    EngineeringStudent() {}

    public EngineeringStudent setName(String name) {
        this.name = name;
        return this;
    }

    public EngineeringStudent setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public Student build() {
        return new Student(this.name, this.age, List.of("Eng sub-1", "Eng sub-2"));
    }
}
