package egger.software.aw_threads;

import java.util.concurrent.*;

public class ExecutorServiceUsage {
    public static class LongLastingTask implements Callable<Double> {
        @Override
        public Double call() throws Exception {
            Thread.sleep(1000);
            return Math.random();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ExecutorCompletionService<Double> executorService = new ExecutorCompletionService<>(threadPool);
        Future<Double> future1 = executorService.submit(new LongLastingTask());
        System.out.println(future1.get());
        System.out.println(future1.isDone());
        System.out.println(future1.isCancelled());

        Future<Double> future2 = executorService.submit(new LongLastingTask());
        future2.cancel(true);
        System.out.println(future2.isCancelled());
        //System.out.println(future2.get());
        threadPool.shutdownNow();
    }
}
