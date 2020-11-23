package divideandconquer;

import util.ListNode;

/**
 * 合并k个升序列表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] listNodes) {
        if (listNodes == null || listNodes.length == 0) {
            return null;
        }
        return mergeLists(listNodes, 0, listNodes.length - 1);
    }

    private ListNode mergeLists(ListNode[] listNodes, int left, int right) {
        if (left == right) {
            return listNodes[left];
        }
        int middle = (left + right) / 2;
        ListNode n1 = mergeLists(listNodes, left, middle);
        ListNode n2 = mergeLists(listNodes, middle + 1, right);
        return merge(n1, n2);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        ListNode root = new ListNode(0);
        ListNode currentNode = root;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                currentNode.next = n2;
                n2 = n2.next;
            } else {
                currentNode.next = n1;
                n1 = n1.next;
            }
            currentNode = currentNode.next;
        }
        if (n1 != null) {
            currentNode.next = n1;
        } else {
            currentNode.next = n2;
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode n1 = ListNode.buildList(new int[]{1, 3, 5, 7, 9});
        ListNode n2 = ListNode.buildList(new int[]{2, 4, 6, 8, 10, 11});
        ListNode n3 = ListNode.buildList(new int[]{1, 3, 5, 7, 11, 12, 13});
        ListNode[] listNodes = new ListNode[]{n1, n2, n3};
        System.out.println(new MergeKLists().mergeKLists(listNodes).toListNodeValList());
    }
}
