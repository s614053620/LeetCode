package sunkey.leetcode.NC15;

import java.util.*;


public class Solution {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayList<Integer> list2 = new ArrayList();
        list2.add(root.val);
        list.add(list2);
        nextLevel(list, Arrays.asList(root));
        return list;
    }

    public void nextLevel(ArrayList<ArrayList<Integer>> list,
                          List<TreeNode> nodes) {
        List<TreeNode> nextLevel = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }
        if (!nextLevel.isEmpty()) {
            ArrayList<Integer> vals = new ArrayList<>(nextLevel.size());
            for (TreeNode node : nextLevel) {
                vals.add(node.val);
            }
            list.add(vals);
            nextLevel(list, nextLevel);
        }
    }

}