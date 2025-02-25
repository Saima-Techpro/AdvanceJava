package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {

        // All Java programmes have a thread started by default => known as main thread
        // Don't confuse main method with main thread; they're two different things

        System.out.println("Current thread: "+Thread.currentThread().getName());

        // There are two ways to create a thread

        // 1st way: using "extends"
        Thread thread1 = new MyThread();
        //thread1.run(); // doesn't create a new thread .. just calls the run() method
        thread1.start(); // creates a new thread and runs the run() method in a new thread .. default name is thread 0
        thread1.setName("Bob");


        // 2nd way: First approach: using Runnable interface (it's a functional interface)

        // Runnable interface can be implemented through normal Java class
        // run() method is the task in the Runnable interface to be implemented by the class

        Runnable runnable = new MyRunnable(); // Create a runnable object that implements Runnable interface
        Thread thread2 = new Thread(runnable); // Pass the object in Thread creation
        thread2. start(); // start() method starts the thread
        thread2.setName("Saima");

        // Until this line, we have three active threads in this class => main, bob, Thread-1


        // 2nd way: Second approach: Using Anonymous class
        // More practical (without creating a runnable class and creating its object separately like MyRunnable class)
        Thread thread3 = new Thread(new Runnable() { // creating runnable object as a parameter .... can be replaced with lambda
            @Override
            public void run() {
                System.out.println("Working thread: "+ Thread.currentThread().getName());
                System.out.println("Thread created via Anonymous class started!" );
                System.out.println("Anonymous thread is going to sleep!");
                try {
                    Thread.sleep(200); // will make thread3 to sleep / wait
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Anonymous thread is up again!");
            }
        });

        thread3.setName("learning");
        thread3.start();

        // 2nd way: THIRD approach: THE MOST PRACTICAL
        Thread thread4 = new Thread(() -> { //replaced with lambda
            // Body of run() method

            System.out.println("Working thread: "+ Thread.currentThread().getName());
            System.out.println("Thread created via Functional (lambda expression) Interface started!" );
        });
        thread4.setName("Emily");
        thread4.start();

        System.out.println("Main thread is tired, it will go to sleep.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main thread is awake again!!");
        // Message
        System.out.println("End of main thread is done here!!"); // will keep changing position on console coz JVM decides which thread will be run first and when (without using Thread.sleep() later)

        // NOTE: Each thread works on their own codes without waiting for other thread to finish first
        // Whichever thread reaches the resource (CPU) first, JVM will tell that thread to run first
        // Once a thread is run, finished its job - that thread dies

        // How can we keep main thread waiting? or force it to end when all other threads are done?
        // Use Thread.sleep() method

    }
}

// 1st way: Extending from Thread class
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread is working. Brilliant!");
        System.out.println("Working thread: " + Thread.currentThread().getName());
    }
}

// 2nd way: Creating a thread by implementing Runnable Interface.
            // Interface can be implemented through normal Java class (MyRunnable)
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Working thread: "+ Thread.currentThread().getName());
        System.out.println("Thread created via Runnable Interface started!" );
    }
}