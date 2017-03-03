package egger.software.aw_threads;

public class RaceCondition {
    private static Incrementor incrementor = new Incrementor();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(RaceCondition::inc, "t1");
        Thread thread2 = new Thread(RaceCondition::inc, "t2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    private static void inc() {
        for (int i = 0; i < 10; i++) {
            incrementor.inc();
        }
    }

}
