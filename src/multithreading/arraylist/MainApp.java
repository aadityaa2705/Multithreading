package multithreading.arraylist;

import multithreading.threadcolor.ThreadColor;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }

}
