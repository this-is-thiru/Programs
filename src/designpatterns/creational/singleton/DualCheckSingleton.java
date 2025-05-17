package designpatterns.creational.singleton;

public class DualCheckSingleton {
    private static DualCheckSingleton lazySingleton = null;
    private DualCheckSingleton() {}

    public static DualCheckSingleton getInstance() {
        if (lazySingleton == null) {
            System.out.println(Thread.currentThread().getName());
            synchronized (DualCheckSingleton.class) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (lazySingleton == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    lazySingleton = new DualCheckSingleton();
                }
            }
        }
        return lazySingleton;
    }
}
