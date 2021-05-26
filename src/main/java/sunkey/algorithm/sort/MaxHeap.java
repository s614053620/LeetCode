package sunkey.algorithm.sort;

import java.util.Arrays;

/**
 * 最大堆排序
 *
 * @author Sunkey
 * @since 2021-05-26 5:15 下午
 **/
public class MaxHeap {

    public static void main(String[] args) {
        int[] tree = {1234, 1, 15, 11, 123, 13, 14, 1254, 12, 135, 125};
        heapSort(tree, tree.length);
        System.out.println(Arrays.toString(tree));
    }

    public static void heapSort(int[] tree, int n) {
        buildHeap(tree, n);
        for (int i = n - 1; i >= 0; i--) {
            swap(tree, 0, i);
            heapify(tree, i, 0);
        }
    }

    public static void buildHeap(int[] tree, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(tree, n, i);
        }
    }

    public static void heapify(int[] tree, int n, int i) {
        if (i > n) {
            return;
        }
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n, max);
        }
    }

    public static void swap(int[] tree, int i, int j) {
        int tmp = tree[i];
        tree[i] = tree[j];
        tree[j] = tmp;
    }

}
