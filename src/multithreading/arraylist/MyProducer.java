package multithreading.arraylist;
import java.util.List;
import java.util.Random;

public class MyProducer implements Runnable {
    private final List<String> buffer;
    private final String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        Random random = new Random();
        String [] nums = {"1", "2", "3", "4", "5"};
        for (String num : nums){
            System.out.println(color + "adding..." + num);
            synchronized(buffer){
                buffer.add(num);
            }
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("interrupted.....");
            }
        }
        System.out.println(color + "adding EOF and exiting....");
        synchronized (buffer){
            buffer.add("EOF");
        }
    }
}
