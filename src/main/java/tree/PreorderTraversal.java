package tree;

import util.TreeNode;

import java.util.*;

/**
 * 二叉树的前序遍历
 * 给定一个二叉树，返回它的前序遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,2,3]
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> valList = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            valList.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return valList;
    }

    public static void main(String[] args) {
        System.out.println(new PreorderTraversal().preorderTraversal(TreeNode.buildTree(new Integer[]{1, null, 2, 3})));
    }
}
