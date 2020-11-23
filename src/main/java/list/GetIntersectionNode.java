package list;

import util.ListNode;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode n1 = headA, n2 = headB;
        while (n1 != n2) {
            n1 = n1 == null ? headB : n1.next;
            n2 = n2 == null ? headA : n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode n1 = ListNode.buildList(new int[]{1, 2, 3});
        ListNode n2 = ListNode.buildList(new int[]{2, 3, 4});
        ListNode intersect = ListNode.buildList(new int[]{5, 6, 7});
        n1.next = intersect;
        n2.next = intersect;
        System.out.println(new GetIntersectionNode().getIntersectionNode(n1, n2).val);
    }
}
