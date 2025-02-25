package threads;

public class SharedDataNonVolatile {

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                SharedData.counter = i;
                System.out.println("Writer updated counter to: " + i);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        });

        Thread readerThread = new Thread(() -> {
            int lastRead = SharedData.counter;
            while (lastRead < 5) {
                if (lastRead != SharedData.counter) { // Reader may not see updates
                    System.out.println("Reader sees counter: " + SharedData.counter);
                    lastRead = SharedData.counter;
                }
            }
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
