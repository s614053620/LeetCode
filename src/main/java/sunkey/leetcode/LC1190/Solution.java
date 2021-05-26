package sunkey.leetcode.LC1190;

import java.util.Arrays;
import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("abcd"));
        System.out.println(new Solution().reverseParentheses("(abcd)"));
        System.out.println(new Solution().reverseParentheses("(u(love)i)"));
        System.out.println(new Solution().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }


    public String reverseParentheses(String s) {
        Terms terms = new Terms(s);
        Container root = new Container();
        root.asc = true;
        root.eat(terms);
        StringBuilder sb = new StringBuilder();
        root.render(sb);
        return sb.toString();
    }


    public interface Node {
        void eat(Terms terms);

        void render(StringBuilder sb);
    }

    public static class Container implements Node {
        boolean asc;
        LinkedList<Node> subNodes = new LinkedList<>();

        @Override
        public void eat(Terms terms) {
            LOOP:
            while (terms.hasNext()) {
                switch (terms.next()) {
                    case '(': // add sub container
                        Container sub = new Container();
                        sub.asc = !asc;
                        sub.eat(terms);
                        subNodes.add(sub);
                        break;
                    case ')':
                        break LOOP;
                    default:
                        terms.prev();
                        StringNode node = new StringNode();
                        node.asc = asc;
                        node.eat(terms);
                        subNodes.add(node);
                        break;
                }
            }
        }

        @Override
        public void render(StringBuilder sb) {
            (asc ? subNodes.iterator() : subNodes.descendingIterator()).forEachRemaining(node ->
                    node.render(sb)
            );
        }

    }

    public static class StringNode implements Node {
        boolean asc;
        SubTerm sub = new SubTerm();

        @Override
        public void eat(Terms terms) {
            sub.terms = terms;
            sub.start = terms.currentIndex;
            LOOP:
            while (terms.hasNext()) {
                switch (terms.next()) {
                    case '(':
                    case ')':
                        terms.prev();
                        break LOOP;
                    default:
                        //System.out.println("[CHAR]");
                        //terms.print();
                }
            }
            sub.end = terms.currentIndex;
        }

        @Override
        public void render(StringBuilder sb) {
            if (asc) {
                for (int i = sub.start + 1; i <= sub.end; i++) {
                    sb.append(sub.terms.data[i]);
                }
            } else {
                for (int i = sub.end; i > sub.start; i--) {
                    sb.append(sub.terms.data[i]);
                }
            }
        }

    }

    public static class SubTerm {
        int start;
        int end;
        Terms terms;

        @Override
        public String toString() {
            return new String(terms.data, start, end);
        }

    }

    public static class Terms {
        final char[] data;
        int currentIndex = -1;

        public Terms(String string) {
            this.data = string.toCharArray();
        }

        boolean hasNext() {
            return currentIndex < data.length - 1;
        }

        char next() {
            return data[++currentIndex];
        }

        char touchNext() {
            return data[currentIndex + 1];
        }

        char current() {
            return data[currentIndex];
        }

        void prev() {
            if (currentIndex > -1) {
                currentIndex--;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(' ');
            sb.append(data);
            sb.append(System.lineSeparator());
            if (currentIndex + 1 > 0) {
                char[] arr = new char[currentIndex + 1];
                Arrays.fill(arr, ' ');
                sb.append(arr);
            }
            sb.append('^');
            return sb.toString();
        }

        void print() {
            System.out.println(this);
        }

    }

}