package tree;

import util.TreeNode;

import java.util.*;

/**
 * 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序遍历。
 * <p>
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            integerList.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return integerList;
    }

    public static void main(String[] args) {
        System.out.println(new InorderTraversal().inorderTraversal(TreeNode.buildTree(new Integer[]{1, null, 2, 3})));
    }
}
