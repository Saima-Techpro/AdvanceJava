package threads;

public class Volatile01 {

//    public static int x = 0; // assume that this variable is being catched in cache memory .. this will cause stack overflow

    public static volatile int x = 0;


    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> { // assume that thread1 runs in core1
            while (x==0){
                System.out.println("This is a risk.");
            }
        });

        Thread thread2 = new Thread(() -> { // assume that thread2 runs in core2

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            x = 1;
        });

        thread1.start();
        thread2.start();



    }
}
