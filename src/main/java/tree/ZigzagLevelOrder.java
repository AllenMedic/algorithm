package tree;

import util.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        boolean leftToRight = true;
        List<List<Integer>> answer = new LinkedList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> levelValList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) {
                    levelValList.add(currentNode.val);
                } else {
                    levelValList.add(0, currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                size--;
            }
            answer.add(levelValList);
            leftToRight = !leftToRight;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }
}
