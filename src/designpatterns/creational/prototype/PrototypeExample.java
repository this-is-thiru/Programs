package designpatterns.creational.prototype;

public class PrototypeExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(20);
        student.setName("Student");
        System.out.println(student.cloned());

        Employee employee = new Employee();
        employee.setName("Employee");
        employee.setAge(20);
        System.out.println(employee.cloned());
    }
}
