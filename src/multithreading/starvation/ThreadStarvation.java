package multithreading.starvation;

import multithreading.threadcolor.ThreadColor;

public class ThreadStarvation {
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Worker(ThreadColor.ANSI_RED),"Priority 10");
        Thread t2 = new Thread(new Worker(ThreadColor.ANSI_BLUE),"Priority 8");
        Thread t3 = new Thread(new Worker(ThreadColor.ANSI_GREEN),"Priority 6");
        Thread t4 = new Thread(new Worker(ThreadColor.ANSI_CYAN),"Priority 4");
        Thread t5 = new Thread(new Worker(ThreadColor.ANSI_PURPLE),"Priority 2");

        //setting priorities
        t1.setPriority(10);
        t2.setPriority(8);
        t3.setPriority(6);
        t4.setPriority(4);
        t5.setPriority(2);

        //invoking threads
        t5.start();
        t3.start();
        t2.start();
        t1.start();
        t4.start();
    }

    //inner class
    private static class Worker implements Runnable{
        private String threadColor;
        private int runCount = 1;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for (int i = 1; i <=100 ; i++) {
                synchronized (lock){
                    System.out.format(threadColor+"%s: runCount = %d\n",Thread.currentThread().getName(),runCount++);
                }
            }
        }
    }
}
