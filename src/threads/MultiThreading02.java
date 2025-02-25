package threads;

public class MultiThreading02 {

    public static int counter = 0;



    public static void main(String[] args) {

        Thread bobThread = new Thread(() -> {
            // Body of run() method
            TicketCounter.count();  // count() will be synchronized but any other task that we give threads to do, they'll be asynchronous

            // example
            for (int i = 1; i < 11; i++) {
                System.out.println("Bob sold Ice cream");
            }


        });


        bobThread.setName("Bob");

        Thread mikeThread = new Thread(() -> {
            // Body of run() method
            TicketCounter.count();

            // example
            for (int i = 1; i < 11; i++) {
                System.out.println("Mike sold Lemonade");
            }
        });
        mikeThread.setName("Mike");

        bobThread.start();
        mikeThread.start();

    }
}


class TicketCounter{

    public String name;

    public TicketCounter(String name) {
        this.name = name;
    }

    public static synchronized void count(){
        for (int i = 1; i <= 1000 ; i++) {

            MultiThreading02.counter++;

        }
        System.out.println( "Ticket Counter: " + MultiThreading02.counter);
        // If you want to print the name on the counter
        // System.out.println( Thread.currentThread().getName() + "Ticket Counter: " + MultiThreading02.counter);
    }

}
