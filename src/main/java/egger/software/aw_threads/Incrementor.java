package egger.software.aw_threads;

import java.util.concurrent.locks.ReentrantLock;

public class Incrementor {

    private int counter;
    private ReentrantLock lock = new ReentrantLock();

    //public synchronized void inc() {
    public void inc() {
        lock.lock();
        try {

            int tmp = counter;
            Thread.sleep(100);
            counter = tmp + 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
        printCounter();
    }

    private void printCounter() {
        System.out.println(Thread.currentThread().getName() + ": " + counter);
    }
}
