package designpatterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    public static void main(String[] args) {
//        testEagerSingleton();
//        testLazySingleton();
        testBlockedSingleton();
//        testDualCheckSingleton();
    }

    static void testEagerSingleton() {

        EagerSingleton singleton = EagerSingleton.getInstance();
        EagerSingleton singleton2 = EagerSingleton.getInstance();
        System.out.println(singleton.hashCode());
        System.out.println(singleton2.hashCode());
    }

    static void testLazySingleton() {

        Runnable runnable = () -> {
            LazySingleton singleton3 = LazySingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+ ": " + singleton3.hashCode());
        };

        getThreads(runnable);
    }

    static void testBlockedSingleton() {

        Runnable runnable = () -> {
            BlockedSingleton singleton = BlockedSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+ ": " + singleton.hashCode());
        };

        long init = System.currentTimeMillis();
        getThreads(runnable);
        long end = System.currentTimeMillis();
        System.out.println(end - init);
    }

    static void testDualCheckSingleton() {

        Runnable runnable = () -> {
            DualCheckSingleton singleton = DualCheckSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+ ": " + singleton.hashCode());
        };

        long init = System.currentTimeMillis();
        getThreads(runnable);
        long end = System.currentTimeMillis();
        System.out.println(end - init);
    }

    private static void getThreads(Runnable runnable) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable, "thread" + i);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
