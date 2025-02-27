package threads;

public class WaitInterrupt01 {
    /*
     In multi thread applications, if a thread needs another thread to do some work,
     to continue its work, then this communication between two threads can be established with wait/notify
     or wait/interrupt.

    Wait and interrupt() methods also allow communication between threads - NOT Recommended!!

     */

     /*
    TASK: Develop an application for a student's bank deposits and withdrawals
        - If there's not enough balance in the account, student will wait.
        - When some money is deposited, student will be notified and then he can withdraw
     */

    public static volatile int balance = 0;

    public synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to deposit " + amount + "$");
        this.balance += amount; // recursive addition
        System.out.println("Deposit successful! Update balance is: " + this.balance+ "$");
//        notify(); // Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be awakened.

    }

    public synchronized void withdraw(int amount) {
        System.out.println(Thread.currentThread().getName() + " wants to withdraw " + amount + "$");

        if (balance < amount || balance == 0) {
            System.out.println("Insufficient funds. Your balance is: " + this.balance + "$");
            System.out.println("Waiting for deposit.");

            try {
                wait();  // temporarily frees the monitored (locked) object. waiting for deposit
            } catch (InterruptedException e) {
                System.out.println("Balance updated! Continue withdrawal");
            }
        }

        if (balance >= amount) {
            this.balance -= amount; // recursive subtraction
            System.out.println("Withdrawal successful! Remaining balance is: " + this.balance+ "$");
        }else {
            System.out.println("Insufficient funds. Your balance is: " + this.balance + "$");
        }

        /*
        NOTES:
        - We are going to create one WaitNotify01 object and two different (son and father) threads are going to use the same object.
        - We make our non-static methods synchronized so that only one thread can access them at a time.
          This will lock the object. ( in technical terms => the object will be monitored)

        - If sonThread tries to withdraw and fatherThread tries to deposit at the same time, sonThread will wait until fatherThread completes its task.

        - When son triggers withdraw(), it locks the WaitNotify01 object so fatherThread can't use it and deposit money, using deposit() metho.
        - So we use wait() method => temporarily frees the monitored (locked) object.
         - Now fatherThread can access the object, and use deposit() method


         */
    }


    public static void main(String[] args) {

        WaitInterrupt01 obj = new WaitInterrupt01(); // need to create object because deposit and withdraw are object/instance methods (non-static methods)

        Thread sonThread = new Thread(() -> {
            // body of run method

            obj.withdraw(200); // test with 2000 as well => withdraw more than deposited
        });
        sonThread.setName("Jack");
        sonThread.start();

        Thread fatherThread = new Thread(() -> {
            // body of run method


            // We'll make this thread to sleep to simulate a delay using Thread.sleep()
            // as if the father leaves home, goes to work, then goes to bank, deposits money, goes to grocery,
            // buys groceries and then comes home, comes back

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            obj.deposit(1500);
            sonThread.interrupt(); // Forcefully interrupts waiting process of sonThread. This is more forceful and bosses the sonThread to stop waiting
        });
        fatherThread.setName("Carl");
        fatherThread.start();


    }
}
