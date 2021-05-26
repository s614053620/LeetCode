package sunkey.leetcode.NC93;

import java.util.*;


public class Solution {

    public static void main(String[] args) {
        int[][] opts = {
                {1, 1, 1},
                {1, 2, 2},
                {1, 3, 2},
                {2, 1},
                {1, 4, 4},
                {2, 2}};

        int[] res = new Solution().LRU(opts, 3);
        System.out.println(Arrays.toString(res));
    }

    public int[] LRU(int[][] operators, int k) {
        int resultLength = 0;
        for (int[] operator : operators) {
            if (operator[0] == 2) {
                resultLength++;
            }
        }
        int[] results = new int[resultLength];
        int index = 0;

        LRU cache = new LRU(k);
        for (int[] operator : operators) {
            switch (operator[0]) {
                case 1:
                    cache.set(operator[1], operator[2]);
                    break;
                case 2:
                    Integer value = cache.get(operator[1]);
                    results[index++] = value == null ? -1 : value;
            }
        }
        return results;
    }

}

class LRU {

    private final long capacity;
    private long opt;
    private Map<Integer, Node> map = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public void set(int key, int val) {
        Node node = map.get(key);
        if (node == null) {
            node = new Node();
            map.put(key, node);
        }
        node.value = val;
        node.opt = ++this.opt;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            long requireOpt = this.opt - this.capacity;
            if (requireOpt <= node.opt) {
                node.opt = ++this.opt;
                return node.value;
            } else {
                map.remove(key);
                return -1;
            }
        } else {
            return -1;
        }
    }
}

class Node {
    int value;
    long opt;

}

