package multithreading.arraylist;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String [] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums){
            System.out.println(color + "adding..." + num);
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("interrupted.....");
            }
        }
        System.out.println(color + "adding EOF and exiting....");
            bufferLock.lock();
            buffer.add("EOF");
            bufferLock.unlock();

    }
}
