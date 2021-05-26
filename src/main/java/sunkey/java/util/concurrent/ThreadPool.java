package sunkey.java.util.concurrent;

import java.util.concurrent.*;

/**
 * @author Sunkey
 * @since 2021-05-26 11:43 上午
 **/
public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                64,
                5,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r);
                    }
                },
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        r.run();
                    }
                });
    }

}
