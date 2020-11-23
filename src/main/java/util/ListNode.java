package util;

import java.util.LinkedList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildList(int[] ints) {
        ListNode root = new ListNode(0);
        ListNode currentNode = root;
        for (int i : ints) {
            currentNode.next = new ListNode(i);
            currentNode = currentNode.next;
        }
        return root.next;
    }

    public List<Integer> toListNodeValList() {
        List<Integer> valList = new LinkedList<>();
        ListNode currentNode = this;
        while (currentNode != null) {
            valList.add(currentNode.val);
            currentNode = currentNode.next;
        }
        return valList;
    }
}
