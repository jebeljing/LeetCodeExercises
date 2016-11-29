package package200;

import base.ListNode;

/**
 * Created by jingshanyin on 10/30/16.
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * Do it in O(n) time and O(1) space.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        // Check whether we have work to do
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head, reverseHead = null;
        while (fast != null && fast.next != null) {
            // Move fast pointer two nodes at a time
            fast = fast.next.next;
            // Move slow pointer one node at a time, reversing the first half
            // of the list along the way
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
        }
        ListNode mid = slow;
        // Move slow pointer one node forward if the length of the list is odd
        while(fast != null) slow = slow.next;
        // Navigate to the ends of the list, comparing values for equality
        // and restoring the reversed half of the list
        while(slow != null) {
            if (slow.val != reverseHead.val) return false;
            slow = slow.next;
            ListNode temp = reverseHead.next;
            reverseHead.next = mid;
            mid = reverseHead;
            reverseHead = temp;
        }
        return true;
    }
}
