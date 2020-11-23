package list;

import util.ListNode;

public class InvertList {
    public ListNode invertList(ListNode root) {
        ListNode pre = null;
        ListNode currentNode = root;
        while (currentNode != null) {
            ListNode temp = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.println(new InvertList().invertList(ListNode.buildList(new int[]{1, 3, 4, 5, 6, 7})).toListNodeValList());
    }
}
