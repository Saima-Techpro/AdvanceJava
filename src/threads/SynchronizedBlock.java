package threads;

public class SynchronizedBlock {


    public static void main(String[] args) {
        // Task: Print "[ [ [ [ [  ] ] ] ] ]" on 14 lines.
        // accomplish this task with two threads, each printing 7 lines

        Brackets brackets = new Brackets(); // show without creating object first making printBracket() static nad without using synchronized

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 8 ; i++) {
                    brackets.printBrackets();
                }
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 8 ; i++) {
                    brackets.printBrackets();
                }
            }
        });

        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long finishTime = System.currentTimeMillis();

        System.out.println("Time passed: " + (finishTime - startTime));

        // time passed with synchronized method: 35155
        // time passed with synchronized block:  17742




    }
}


class Brackets{
    
//    public void printBrackets(){
//
//        // NOTE: since this method prints a pattern that need to match with our expectation,
//        // we need to synchronize this method => at any given time, only 1 thread should be executing this method
//
//        for (int i = 1; i < 11; i++) {
//
//            if (i < 6){
//                System.out.print("[ ");
//            }else {
//                System.out.print(" ]");
//            }
//        }
//        System.out.println("==> "+ Thread.currentThread().getName());
//    }

//    public synchronized void printBrackets(){
//
//        // NOTE: since this method prints a pattern that need to match with our expectation,
//        // we need to synchronize this method => at any given time, only 1 thread should be executing this method
//        // so we add "synchronized" keyword
//
//        for (int i = 1; i < 11; i++) {
//
//            if (i < 6){
//                System.out.print("[ ");
//            }else {
//                System.out.print(" ]");
//            }
//
//        }
//
//        System.out.println("==> "+ Thread.currentThread().getName());
//         // add another task in this method to simulate some work
            // following loop will also be synchronized
//
//        for (int i = 1; i < 6; i++) {
//
//            try {
//                Thread.sleep(1000);
//                System.out.println(i);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//    }

    /*
    NOTES: this method is synchronizing one task only => printing the brackets on ONE LINE
    1. let say thread1 is executing printBrackets(), prints [ [ [ [ [  ] ] ] ] ] and leaves the method
    2. then thread2 is executing printBrackets(), prints [ [ [ [ [  ] ] ] ] ] and leaves the method
    3. then maybe thread1 is executing printBrackets() again , prints [ [ [ [ [  ] ] ] ] ] and leaves the method

    the idea is printing brackets on ONE LINE is not disturbed by other threads,
    but who can reach and use method first is decided by jvm

    ANALOGY:
    ROOM AND KEY
    Room => printBrackets()
    Key => Thread
    thread1 takes the key, enters the room and prints [ [ [ [ [  ] ] ] ] ],
    while thread1 is inside the room, no other thread can enter that room.

    thread1 leaves the room, and puts the key on the table for whoever comes later to enter the room
    next, maybe thread1 comes back again, as long as i<6 in its loop ( see line15), takes the key and so on
    or maybe thread2 comes, takes the key, enters the room, print the brackets and leaves the room

    The process continues as long as the i < 6 condition in fulfilled in each thread's loop inside the run() method
     */

    public /* synchronized */ void printBrackets(){

        // NOTE: We can use synchronized block to synchronize a
        // block of code / object if other codes / rest of teh methods doesn't need to be synchronized

        synchronized (this){
            for (int i = 1; i < 11; i++) {

                if (i < 6){
                    System.out.print("[ ");
                }else {
                    System.out.print(" ]");
                }
            }
        }


        System.out.println("==> "+ Thread.currentThread().getName());

        // add another task in this method to simulate some work
        // the following loop is still asynchronous
        for (int i = 1; i < 6; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(i + " - "+ Thread.currentThread().getName());
        }
    }

}
