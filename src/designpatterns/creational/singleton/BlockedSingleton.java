package designpatterns.creational.singleton;

public class BlockedSingleton {
    private static BlockedSingleton lazySingleton = null;
    private BlockedSingleton() {}

    public synchronized static BlockedSingleton getInstance() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (lazySingleton == null) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lazySingleton = new BlockedSingleton();
        }
        return lazySingleton;
    }
}
