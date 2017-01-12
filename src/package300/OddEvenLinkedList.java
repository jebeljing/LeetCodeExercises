package package300;

import base.ListNode;

/**
 * Created by yinj on 1/12/2017.
 * 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

 You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 Example:
 Given 1->2->3->4->5->NULL,
 return 1->3->5->2->4->NULL.

 Note:
 The relative order inside both the even and odd groups should remain as it was in the input.
 The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;


        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        if (head.next == null || head.next.next == null) return head;

        ListNode oddHead = new ListNode(0); ListNode oddIter = oddHead;
        ListNode evenHead = new ListNode(0); ListNode evenIter = evenHead;
        ListNode temp = head;
        ListNode curr = head;

        while (temp != null) {
            curr = temp;
            oddIter.next = curr;
            temp = temp.next;
            curr.next = null;
            oddIter = oddIter.next;
            if (temp != null) {
                curr = temp;
                evenIter.next = curr;
                temp = temp.next;
                curr.next = null;
                evenIter = evenIter.next;
            }

        }

        oddIter.next = evenHead.next;
        return oddHead.next;
    }
    }
}
