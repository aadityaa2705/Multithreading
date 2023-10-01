package multithreading.arraylist;

import java.util.List;

public class MyConsumer implements Runnable{
    public static final String EOF = "EOF";
    final List<String> buffer;
    String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true){
            synchronized (buffer){
                if (buffer.isEmpty()){
                    continue;
                }
                if (buffer.get(0).equals(EOF)){
                    System.out.println(color + "exiting....");
                    break;
                }else {
                    System.out.println(color + "removed..." + buffer.remove(0));
                }
            }
        }
    }
}
