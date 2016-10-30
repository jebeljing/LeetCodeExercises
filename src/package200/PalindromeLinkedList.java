package package200;

/**
 * Created by jingshanyin on 10/30/16.
 * 234. Palindrome Linked List
 * Given a singly linked list, determine if it is a palindrome.
 * Do it in O(n) time and O(1) space.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head, reverseHead = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = reverseHead;
            reverseHead = slow;
            slow = temp;
        }
        ListNode mid = slow;
        while(fast != null) slow = slow.next;
        while(slow != null) {
            if (slow.val != reverseHead.val) return false;
            ListNode temp = reverseHead.next;
            reverseHead.next = mid;
            mid = reverseHead;
            reverseHead = temp;
        }
        return true;
    }

    /**
     * Definition for singly-linked list
     */
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
