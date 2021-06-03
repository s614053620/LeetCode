package sunkey.java.util.concurrent;

import java.util.concurrent.*;

/**
 * @author Sunkey
 * @since 2021-05-26 11:43 上午
 **/
public class ThreadPool {

    public static void main(String[] args) {


    }

    static void tpProc(){
        // coreSize = 2; maximumSize = 4; queueSize = 6; rejectPolicy = REJECT;
        // task 1 => newCore1
        // task 2 => newCore2
        // task 3 => queue3
        // task 4 => queue4
        // task 5 => queue5
        // task 6 => queue6
        // task 7 => newNonCore3
        // task 8 => newNonCore4
        // task 9 => Reject
    }

    static void tpArgs() {
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
