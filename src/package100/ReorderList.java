package package100;

import base.ListNode;

/**
 * Created by Jebeljing on 12/18/2016.
 * 143. Reorder List
 *  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;

        //Find the middle of the list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode preMiddle = slow;
        ListNode curr = slow.next;

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        while(curr.next != null) {
            ListNode node = curr.next;
            curr.next = node.next;
            node.next = preMiddle.next;
            preMiddle.next = node;
        }

        slow = head;
        fast = preMiddle.next;
        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        while(slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;

            slow = fast.next;
            fast = preMiddle.next;
        }
    }
}
