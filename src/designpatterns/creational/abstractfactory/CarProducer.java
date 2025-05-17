package designpatterns.creational.abstractfactory;

public class CarProducer {
    public static CarFactory carFactory(String factory) {
        if (factory.equalsIgnoreCase("Economy")) {
            return new EconomyFactory();
        } else if (factory.equalsIgnoreCase("Luxury")) {
            return new LuxuryFactory();
        }
        throw new IllegalArgumentException("Invalid factory");
    }
}
