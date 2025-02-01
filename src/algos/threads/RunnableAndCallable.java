package algos.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Hii implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "Hello Hii";
    }
}
public class RunnableAndCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Hello");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        );

        t1.start();

        FutureTask<String> futureTask = new FutureTask<>(new Hii()); // Callable>
        Thread t2 = new Thread(futureTask);
        t1.join();
        t2.start();
        System.out.println(futureTask.get());
    }
}
