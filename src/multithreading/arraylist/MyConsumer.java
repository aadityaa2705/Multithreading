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
        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()){
                        continue;
                    }
                    System.out.println(color+ "The counter : "+counter);
                    counter = 0;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "exiting....");
                        break;
                    } else {
                        System.out.println(color + "removed..." + buffer.remove(0));
                    }
                }finally {
                    bufferLock.unlock();
                }
            } else {
             counter++;
            }
        }
    }
}
