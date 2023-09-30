package multithreading.countdown;

import multithreading.threadcolor.ThreadColor;

public class Countdown {
    int i;
    public void doCountdown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1" ->
                    color = ThreadColor.ANSI_RED;
            case "Thread 2" ->
                    color = ThreadColor.ANSI_GREEN;
            default ->
                    color = ThreadColor.ANSI_PURPLE;
        }

        
        synchronized (this){
            for (i = 10; i > 0 ; i--) {
                System.out.println(color + Thread.currentThread().getName()+" : i = "+i);
            }
        }
    }
}
