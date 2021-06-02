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
