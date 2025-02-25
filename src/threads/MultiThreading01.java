package threads;

public class MultiThreading01 {
    public static void main(String[] args) {

        // Task: Let's count from 1-15 twice
        // First don't use threads and see how long it takes to complete the task
        // Then use threads and compare the execution time


        Counter counter1 = new Counter("Bob");
        Counter counter2 = new Counter("Mike");

        long startTime = System.currentTimeMillis();

        counter1.count();
        counter2.count();

        long finishTime = System.currentTimeMillis();

        System.out.println("Time passed without threads: " + (finishTime - startTime)); // 6129 milliseconds

        // we are working in main thread so far , so Java takes the codes from top to bottom left to right
        // JVM runs counter1.count(); first and then counter2.count();

        System.out.println("================== MultiThreading ===================");

        Thread thread1 = new CounterThread("John");
        Thread thread2 = new CounterThread("Nick");
        Thread thread3 = new CounterThread("Dani");

        long startTimeThreads = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // This zone is the task of main thread. We are currently in the main thread
            thread1.join(); // join() will wait for the thread to finish
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // NOTE: If we run the threads without using join(), then the main thread will not wait for the threads to finish
        // and we might see the time output before the threads are finished
        long finishTimeThreads = System.currentTimeMillis();
        System.out.println("Time passed with threads: " + (finishTimeThreads - startTimeThreads)); // 3051


        // John and Nick work together and finish the task in half the time as compared to Bob and Mike


    }
}

class Counter {
    public String name;

    public Counter(String name) {
        this.name = name;
    }


    public void count() {
        for (int i = 1; i < 16; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "Counter name: " + this.name);
        }
    }
}

class CounterThread extends Thread{
    public String name;

    public CounterThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        count();
    }


    // create the count() method and call it inside the run() method
    public void count() {
        for (int i = 1; i < 16; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i + "Counter name: " + this.name);
        }
    }



}
