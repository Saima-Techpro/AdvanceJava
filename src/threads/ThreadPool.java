package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static long launchTime = System.currentTimeMillis();

    public static void main(String[] args) {

        System.out.println("launchTime = " + launchTime);

        ExecutorService service = Executors.newFixedThreadPool(3);

        Thread courier1 = new ThreadCreator("A", 3000);
        Thread courier2 = new ThreadCreator("B", 6000);
        Thread courier3 = new ThreadCreator("C", 2000);
        Thread courier4 = new ThreadCreator("D", 7000);
        Thread courier5 = new ThreadCreator("E", 9000);
        Thread courier6 = new ThreadCreator("F", 5000);
        Thread courier7 = new ThreadCreator("G", 4000);
        Thread courier8 = new ThreadCreator("H", 12000);
        Thread courier9 = new ThreadCreator("I", 11000);

        /*
          *********** Without Thread Pool ***********

        courier1.start();
        courier2.start();
        courier3.start();
        courier4.start();
        courier5.start();
        courier6.start();
        courier7.start();
        courier8.start();
        courier9.start();

         */

        //  With Thread Pool
        service.execute(courier1);
        service.execute(courier2);
        service.execute(courier3);
        service.execute(courier4);
        service.execute(courier5);
        service.execute(courier6);
        service.execute(courier7);
        service.execute(courier8);
        service.execute(courier9);

        service.shutdown(); // without this threads will stay alive in the pool



    }
}

class ThreadCreator extends Thread {
    public String task;
    public int duration;

    public ThreadCreator(String task, int duration) {
        this.task = task;
        this.duration = duration;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis() -ThreadPool.launchTime;

        System.out.println(startTime + ": " + Thread.currentThread().getName() + " started working. The task "+ this.task);
        System.out.println();

        try {
            Thread.sleep(duration); // I want the delivery boys to deliver with different durations/speed to simulate real life time-difference
            long finishTime = System.currentTimeMillis() - ThreadPool.launchTime;
            System.out.println(finishTime +": " + Thread.currentThread().getName() + " is done with their work.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
/*
Imagine a cargo company that needs to deliver 9 courier boxes to different locations.
The company hires delivery boys to handle these deliveries.

Let's compare how the company operates without a thread pool and with a thread pool.

Without Thread Pool (One Delivery Boy for Each Delivery)

Imagine this company is new, Manager has no prior experience.
Since there are 9 courier boxes, the company hires 9 different delivery boys—one for each.
He hires 9 delivery boys
The delivery boys pick up one box each, deliver it to 9 locations.
Delivery boys happy, customers happy. Business NOT HAPPY AT ALL =>
🚨 Problems:
COST INCREASED, INEFFICIENT USE OF EXISTING RESOURCES, INSUFFICIENT RESOURCES IF MORE THAN 9 DELIVERIES TO BE MADE


With Thread Pool (A Fixed Team of Delivery Boys)

Now, imagine the company has gained experience and the manager has learned from mistakes.
Instead of hiring a new delivery boy for every single courier, he optimizes the system.

The company hires only 3 delivery boys, forming a fixed team.

The first 3 courier boxes arrive → 3 delivery boys pick them up and start delivering.
While they are out for delivery, the next 6 courier boxes wait in the queue.
As soon as a delivery boy returns, he picks up the next waiting box.
The cycle continues until all deliveries are completed.
🚀 Now, Business is Happy!
✅ COST REDUCED – No need to hire/fire new delivery boys for every courier.
✅ EFFICIENT RESOURCE USE – Delivery boys stay busy but are reused for multiple tasks.
✅ SCALABLE – Even if 20 couriers arrive, deliveries happen steadily without chaos.

💡 Conclusion: Instead of creating a new worker for every task, the company efficiently reuses a fixed team, just like a ThreadPool efficiently reuses threads instead of creating new ones each time!
 */