package threads;


import java.util.concurrent.Semaphore;

public class Semaphore01 {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        Car car1 = new Car("Mercedes", 7000,semaphore);
        Car car2 = new Car("BMW", 5000,semaphore);
        Car car3 = new Car("Audi", 10000,semaphore);
        Car car4 = new Car("Ferrari", 6000,semaphore);
        Car car5 = new Car("Lamborghini", 4000,semaphore);
        Car car6 = new Car("BYD", 9000,semaphore);

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();

    }
}

class Car extends Thread{
    public  String carName;
    public int duration;
    public Semaphore semaphore;

    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(this.carName + " wants to park");

        try {
            semaphore.acquire(); // works like getting a parking permit
            System.out.println("-------> " + this.carName + " parked.");

            Thread.sleep(duration); // waiting => simulating the time duration for which car is parked
            System.out.println("<------- "+ this.carName + " left the parking bay.");
            semaphore.release(); // works like returning a parking permit
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
       Semaphore vs. Synchronized: Understanding the Difference
Both Semaphore and synchronized are used to control access to shared resources in a multi-threaded environment,
but they work in different ways.

🔑 What is a Semaphore?
A Semaphore is a concurrency control mechanism that allows multiple threads to access a shared resource but only
up to a specified limit. It can be used to restrict access to a fixed number of threads.

📌 Analogy:
Imagine a parking lot with 3 parking spots 🚗🚙🛻:

Only 3 cars can park at a time.
If a 4th car arrives, it must wait for one spot to be freed.
As soon as a car leaves, another car can take its place.


🆚 Difference Between Semaphore and synchronized
Feature	                Semaphore	                                          synchronized
Threads                Allowed Multiple threads (up to a limit)	              Only one thread at a time
Resource Control	   Can allow a fixed number of threads	                   Allows only one thread at a time
Flexibility	           Can release a permit from another thread	                Lock is always released by the thread that acquired it
Fairness	           Can be fair (new Semaphore(permits, true)) or unfair.   	Unfair by default, but can be set to fair
Use Case	           When a resource has multiple slots	                   When a resource must be accessed one at a time


Summary
synchronized → Only one thread at a time.
Semaphore → Multiple threads, but with a fixed limit.


Semaphore vs. ThreadPool – What’s the Difference?
Both Semaphore and ThreadPool (ExecutorService) help control concurrent access to resources, but they solve
different problems.

🔑 Semaphore: Controlling Access to Limited Resources
A Semaphore is used when you have a fixed number of shared resources and need to ensure that no more than N threads
can use them at the same time.

📌 Analogy: Parking Lot with 3 Spaces

Only 3 cars can park at the same time.
If a 4th car arrives, it must wait for a spot.
As soon as a car leaves, another car can take its place.
🔹 Use Case:

Limit the number of concurrent database connections.
Restrict access to a shared printer (e.g., only 2 print jobs at a time).
✅ Threads are created normally, but access to the resource is restricted using Semaphore.

🔑 ThreadPool (ExecutorService): Managing Thread Creation Efficiently
A ThreadPool is used when you have a large number of tasks to process, and you want to reuse a fixed number of
threads instead of creating a new thread for every task.

📌 Analogy: Delivery Boys in a Cargo Company

A cargo company hires 3 delivery boys 🏍️🏍️🏍️.
9 packages need to be delivered 📦.
The 3 delivery boys work simultaneously, delivering packages.
As soon as one delivery boy finishes, he takes the next package.
This avoids hiring 9 separate delivery boys and saves costs.
🔹 Use Case:

Handling a web server with multiple client requests.
Processing large numbers of tasks (e.g., sending 1000 emails).
✅ ThreadPool limits thread creation and reuses threads instead of creating new ones.




 */