package multithreading;

import multithreading.customthread1.AnotherThread;
import multithreading.customthread2.MyRunnable;

import static multithreading.threadcolor.ThreadColor.*;

public class MainApp1 {
    public static void main(String[] args) {

        System.out.println(ANSI_CYAN+"Hello from the main thread.");

        // Create instance of thread class -> use upcasting.
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");

        //invoke the start method to run the thread
        anotherThread.start();
        /*
        we cannot invoke start method more than once using same instance
        java.lang.IllegalThreadStateException
        anotherThread.start();
        */

        // Anonymous thread using lambda expression
        new Thread(() -> System.out.println(ANSI_GREEN+"Hello from the anonymous thread class."))
                .start();

        //create thread using runnable interface
        Thread myRunnableThread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from the anonymous class's implementation of run().");
                // joining two threads
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_RED+"AnotherThread terminated, or timed out, so I'm running again.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_RED+"I couldn't wait after all. I was interrupted.");
                }
            }
        });
        myRunnableThread.start();
        System.out.println("Hello again from the main thread.");
    }
}
