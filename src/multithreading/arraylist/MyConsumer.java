package multithreading.arraylist;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable {
    public static final String EOF = "EOF";
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;


    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            if (buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "exiting....");
                bufferLock.unlock();
                break;
            } else {
                System.out.println(color + "removed..." + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }
}
