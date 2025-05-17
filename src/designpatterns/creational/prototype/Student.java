package designpatterns.creational.prototype;

public class Student implements Prototype<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Student cloned() {
        Student student = new Student();
        student.setName(name);
        student.setAge(age);
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
