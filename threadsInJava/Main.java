public class Main {
    public static void main(String[] args) {
        
        // System.out.println(Thread.activeCount());
        // Thread.currentThread().setName("Main Thread");
        // System.out.println(Thread.currentThread().getName());
        // Thread.currentThread().setPriority(10);
        // System.out.println(Thread.currentThread().getPriority());       
        // System.out.println(Thread.currentThread().isAlive());
        
        // for (int i = 3; i>0; i--){
        //     System.out.println(i);
        //     try {
        //         Thread.sleep(1000);
        //     } catch (InterruptedException e) {
        //         System.out.println(e);
        //     }
            
        // }
        // System.out.println("Countdown over!");
        
        MyThread thread2 = new MyThread();
        thread2.start();
        System.out.println(thread2.isAlive());
        thread2.setName("Thread 2");
        
        System.out.println(thread2.isDaemon());
        System.out.println(thread2.getName()); 
        // Inherits the priority of the parent thread in this case main
        System.out.println(thread2.getPriority());

        /* 
         * There are two different types of threads in Java: user threads and 
         * daemon threads. A Daemon thread is a low priority thread that runs in
         * the background and does not prevent the JVM from exiting when all
         * user threads have finished their execution. It performs background tasks
         * such as garbage collection, finalization, etc.

         * A user thread is a thread that is created by the user. The JVM will end 
         * only when all user threads have finished their execution.
         */
    }
}