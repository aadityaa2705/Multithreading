package multithreading.arraylist;

import multithreading.threadcolor.ThreadColor;

import java.util.concurrent.*;

public class MainApp {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5 );

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_RED);

        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColor.ANSI_RESET+"Printing from the callable class");
                return "This is a callable class result";
            }
        });

        try {
            System.out.println(future.get());
        }catch (ExecutionException executionException){
            System.out.println("Execution exception inside the future class");
        }catch (InterruptedException e ){
            System.out.println("Interrupted Exception inside the thread class.");
        }

        executorService.shutdown();
    }
}
