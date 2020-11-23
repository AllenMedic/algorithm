package tree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * <p>
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
                TreeNode right = currentNode.right;
                currentNode.right = currentNode.left;
                currentNode.left = right;
                size--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new InvertTree().invertTree(TreeNode.buildTree(new Integer[]{4, 2, 7, 1, 3, 6, 9})).toTreeNodeValList());
    }
}
