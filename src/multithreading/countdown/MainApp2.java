package multithreading.countdown;

public class MainApp2 {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread thread1 = new CountdownThread(countdown);
        thread1.setName("Thread 1");

        CountdownThread thread2 = new CountdownThread(countdown);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();
    }
}
