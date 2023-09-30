package multithreading.customthread1;

import static multithreading.threadcolor.ThreadColor.ANSI_BLUE;
import static multithreading.threadcolor.ThreadColor.ANSI_PURPLE;

public class AnotherThread extends Thread{
    @Override
    public void run() {
        System.out.println(ANSI_PURPLE+"Hello from "+currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE+"Another thread woke me up.");
            return;
        }
        System.out.println(ANSI_BLUE+"Five seconds passed, and I'm awake");
    }
}
