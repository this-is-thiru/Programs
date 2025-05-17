package designpatterns.creational.abstractfactory;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        CarFactory carFactory = CarProducer.carFactory("Economy");
        Car car1 = carFactory.getCar(10);
        car1.name();
        Car car2 = carFactory.getCar(20);
        car2.name();

        CarFactory carFactory2 = CarProducer.carFactory("Luxury");
        Car car3 = carFactory2.getCar(100);
        car3.name();
        Car car4 = carFactory2.getCar(200);
        car4.name();
    }
}
