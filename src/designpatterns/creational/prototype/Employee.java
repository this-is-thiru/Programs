package designpatterns.creational.prototype;

public class Employee implements Prototype<Employee> {
    private String name;
    private int age;

    public Employee() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Employee cloned() {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setAge(age);
        return employee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
