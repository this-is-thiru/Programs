package threads.runnable;

public class DeadLockExample {
    public static void main(String[] args) {
        Object d1 = new Object();
        Object d2 = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (d1) {
                System.out.println("Thread 1: Executing d1");
                try {
                    System.out.println("Thread 1 sleeping");
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (d2) {
                    System.out.println("Thread 1: Executing d2");
                }
            }


        });
        Thread t2 = new Thread(() -> {
            synchronized (d2) {
                System.out.println("Thread 2: Executing d2");
                try {
                    System.out.println("Thread 2 sleeping");
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (d1) {
                    System.out.println("Thread 2: Executing d1");
                }
            }

        });
        t1.start();
        t2.start();
    }
}
