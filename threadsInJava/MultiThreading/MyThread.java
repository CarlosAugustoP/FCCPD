package MultiThreading;

public class MyThread extends Thread {
    
    @Override
    public void run() {
        for (int i = 10; i>0 ; i--){
            System.out.println("Thread #1: "+ i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Thread #1: Countdown over!");
    }
    
}
