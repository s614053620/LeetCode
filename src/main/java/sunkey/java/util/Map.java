package sunkey.java.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @author Sunkey
 * @since 2021-05-26 11:43 上午
 **/
public class Map {

    public static void main(String[] args) throws InterruptedException {


    }

    static void lists() {
        ArrayList l;
        LinkedList ll;
        CopyOnWriteArrayList cwl;
    }

    static void maps() {
        HashMap<String, String> hm = new HashMap<>(/*loadFactor, initialCapacity, collection*/);
        // LRU = true
        LinkedHashMap<String, String> lhm = new LinkedHashMap<>(/*+!accessOrder*/);
        // concurrencyLvl: 预估并发数，cap=cap<cLvl?cLvl:cap
        ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<>(/*cap,fctr,concurrencyLvl*/);
    }

    static void queues() throws Exception {
        LinkedBlockingQueue q = new LinkedBlockingQueue<>(10);

        q.add(""); //throw
        q.remove("");//bool

        q.offer(""); // bool
        q.poll();// null

        q.put(""); // block
        q.take();// block

        LinkedTransferQueue ltq = new LinkedTransferQueue<>();
        ArrayBlockingQueue abq = new ArrayBlockingQueue<>(10);
        PriorityBlockingQueue pbq = new PriorityBlockingQueue();
    }

}
