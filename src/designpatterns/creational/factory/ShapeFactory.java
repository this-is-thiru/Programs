package designpatterns.creational.factory;

public class ShapeFactory {
    public static Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("square")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        throw new IllegalArgumentException("Shape type " + shapeType + " not supported");
    }
}
