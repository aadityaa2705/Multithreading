package multithreading.arraylist;

import java.util.concurrent.ArrayBlockingQueue;

public class MyConsumer implements Runnable {
    public static final String EOF = "EOF";
    private final ArrayBlockingQueue<String> buffer;
    private final String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (buffer){
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "exiting....");
                        break;
                    } else {
                        System.out.println(color + "removed..." + buffer.take());
                    }
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
