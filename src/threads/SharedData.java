package threads;

public class SharedData {

    static int counter = 0; // Not volatile
    static volatile int counter1 = 0; // Now volatile
}
    /*
    Key Difference
    - Without volatile → Reader might see stale values due to caching.
    - With volatile → Reader always gets the latest updated value.

    Key Takeaways
    - volatile ensures visibility of changes to a variable across threads.
    It prevents thread caching issues, ensuring all threads read the latest value.
    It does not guarantee atomicity for operations like counter++ (use synchronized or AtomicInteger for that).
     */

