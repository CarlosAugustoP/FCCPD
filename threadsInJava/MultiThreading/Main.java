package MultiThreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        MyThread thread1 = new MyThread();
        
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);

        thread1.start();

        thread1.join(3000); // calling join() on thread1 will make the main thread wait for thread1 to finish execution

        thread2.start();


    }
}
