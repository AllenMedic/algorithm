package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否对称
 * 给定一棵二叉树，判断琪是否是自身的镜像（即：是否对称）
 * 例如：下面这棵二叉树是对称的
 * 1
 * /  \
 * 2    2
 * / \    / \
 * 3 4  4  3
 * 下面这棵二叉树不对称。
 * 1
 * / \
 * 2   2
 * \    \
 * 3    3
 * 备注：
 * 希望你可以用递归和迭代两种方法解决这个问题
 */
public class IsSymmetric {
    public boolean isSymmetricI(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) {
                continue;
            }
            if ((n1 == null || n2 == null) || (!n1.val.equals(n2.val))) {
                return false;
            }
            queue.offer(n1.left);
            queue.offer(n2.right);
            queue.offer(n1.right);
            queue.offer(n2.left);
        }
        return true;
    }

    public boolean isSymmetricR(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetricR(root.left, root.right);
    }

    private boolean isSymmetricR(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if ((n1 == null || n2 == null) || (!n1.val.equals(n2.val))) {
            return false;
        }
        return isSymmetricR(n1.left, n2.right) && isSymmetricR(n1.right, n2.left);
    }

    public static void main(String[] args) {
        TreeNode n1 = TreeNode.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        TreeNode n2 = TreeNode.buildTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        System.out.println(new IsSymmetric().isSymmetricI(n1));
        System.out.println(new IsSymmetric().isSymmetricI(n2));
        System.out.println(new IsSymmetric().isSymmetricR(n1));
        System.out.println(new IsSymmetric().isSymmetricR(n2));
    }
}
