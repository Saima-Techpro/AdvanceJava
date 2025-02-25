package threads;

public class SharedDataVolatile {

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                SharedData.counter1 = i;
                System.out.println("Writer updated counter to: " + i);
                try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            }
        });

        Thread readerThread = new Thread(() -> {
            int lastRead = SharedData.counter1;
            while (lastRead < 5) {
                if (lastRead != SharedData.counter1) { // Reader always sees latest value
                    System.out.println("Reader sees counter: " + SharedData.counter1);
                    lastRead = SharedData.counter1;
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
