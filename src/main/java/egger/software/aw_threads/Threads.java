package egger.software.aw_threads;

public class Threads {
    public static void main(String[] args) throws InterruptedException {
        Runnable concurrentTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ": "+ i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(concurrentTask, "t1");
        Thread thread2 = new Thread(concurrentTask, "t2");

        thread1.start();
        thread2.start();

        System.out.println("Waiting for threads to finish");
        thread1.join();
        thread2.join();
        System.out.println("Done");

    }
}

