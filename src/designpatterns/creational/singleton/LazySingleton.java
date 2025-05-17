package designpatterns.creational.singleton;

public class LazySingleton {
    private static LazySingleton lazySingleton = null;
    private LazySingleton() {}

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
