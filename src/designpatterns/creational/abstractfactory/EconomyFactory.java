package designpatterns.creational.abstractfactory;

public class EconomyFactory implements CarFactory {
    @Override
    public Car getCar(int cost) {
        if (cost <= 10) {
            return new EconomyCar1();
        } else {
            return new EconomyCar2();
        }
    }
}
