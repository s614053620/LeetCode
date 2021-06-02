package sunkey.java.util.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sunkey
 * @since 2021-05-26 11:43 上午
 **/
public class Locks {

    public static void main(String[] args) {


    }

    static class BlockQueue {
        ReentrantLock lock = new ReentrantLock();
        Condition empty = lock.newCondition();
        Condition full = lock.newCondition();

        int len = 0;
        Object[] data = new Object[100];

        void push(Object value) throws InterruptedException {
            try {
                lock.lock();
                while (len == data.length) {
                    full.await();
                }
                data[len++] = value;
                empty.signal();
            } finally {
                lock.unlock();
            }
        }

        Object take() throws InterruptedException {
            try {
                lock.lock();
                while (len == 0) {
                    empty.await();
                }
                Object datum = data[len--];
                full.signal();
                return datum;
            } finally {
                lock.unlock();
            }
        }

    }

    static void rwlock() {
        ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
        Object value = null;
        try {
            rwlock.readLock().lock();
            if (value == null) {
                rwlock.readLock().unlock();
                rwlock.writeLock().lock();
                value = null;// init
                rwlock.readLock().lock();
                rwlock.writeLock().unlock();
            }
            // value.use
        } catch (Throwable ex) {
            rwlock.readLock().unlock();
        }
    }

    static void reentrant() {
        ReentrantLock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        try {
            lock.lock();
            cond.await();
            // sth..
        } catch (Throwable ex) {
            lock.unlock();
        }
    }

    static void reentrants() {
        // Fair/UnFair : 公平锁：按照等待顺序，影响性能
        // tryLock() 忽略公平锁影响
        // 可重入互斥锁
        ReentrantLock rl = null;
        // Condition等同于Object.wait/notify
        // rl.lock()/unlock() = sync(object){}
        Condition cond = rl.newCondition();
        // object.wait/notify = cond.await() / cond.signal()/cond.signalAll()

        // 锁支持降级从W到R
        // 注：从R升级到W永远不会成功，必须先释放
        ReentrantReadWriteLock rwl;
    }

}
