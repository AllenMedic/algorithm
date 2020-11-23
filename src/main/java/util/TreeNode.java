package util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode buildTree(Integer[] integers) {
        if (integers == null || integers.length == 0) {
            return null;
        }
        int index = 0, length = integers.length;
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(integers[0]);
        queue.offer(root);
        while (!queue.isEmpty() && index < length) {
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (++index >= length) {
                    break;
                }
                if (integers[index] != null) {
                    currentNode.left = new TreeNode(integers[index]);
                    queue.offer(currentNode.left);
                }
                if (++index >= length) {
                    break;
                }
                if (integers[index] != null) {
                    currentNode.right = new TreeNode(integers[index]);
                    queue.offer(currentNode.right);
                }
                size--;
            }
        }
        return root;
    }

    public List<Integer> toTreeNodeValList() {
        List<Integer> valList = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                valList.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                size--;
            }
        }
        return valList;
    }
}
