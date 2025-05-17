package designpatterns.creational.builder;

public class BuilderExample {
    public static void main(String[] args) {
        Student student1 = new EngineeringStudent().setName("name").setAge(20).build();
        System.out.println(student1);

        Student student2 = new MBAStudent().setName("name-1").setAge(21).build();
        System.out.println(student2);
    }
}
