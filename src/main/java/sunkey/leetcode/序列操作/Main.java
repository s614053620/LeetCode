package sunkey.leetcode.序列操作;

import java.io.InputStream;

public class Main {

    public static int next(InputStream in) throws Exception {
        StringBuilder sb = new StringBuilder();
        char c;
        while (true) {
            c = (char) in.read();
            if (c != '\n' && c != ' ') {
                sb.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        int m = next(System.in) + 1;
        int n = next(System.in);
        boolean[] flags = new boolean[m];
        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            int c = next(System.in);
            stack[n - i - 1] = c;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = stack[i];
            if (!flags[val]) {
                sb.append(val).append("\n");
                flags[val] = true;
            }
        }
        for (int i = 1; i < m; i++) {
            if (!flags[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}