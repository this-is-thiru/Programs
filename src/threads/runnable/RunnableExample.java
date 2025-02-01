package threads.runnable;

public class RunnableExample implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Hello Runnable");
        } catch (InterruptedException ignore) {

        }
    }

    public static void main(String[] args) {
        RunnableExample runnableExample = new RunnableExample();
        Thread t1 = new Thread(runnableExample);
        t1.setName("Thread-1");
        t1.start();
    }
}
