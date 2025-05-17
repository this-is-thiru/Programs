package designpatterns.creational.abstractfactory;

public class LuxuryFactory implements CarFactory {
    @Override
    public Car getCar(int cost) {
        if (cost <= 100) {
            return new LuxuryCar1();
        } else {
            return new LuxuryCar2();
        }
    }
}
