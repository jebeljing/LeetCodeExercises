package package400;

import base.ListNode;

import java.util.Stack;

/**
 * Created by jingshanyin on 1/7/17.
 * 445. Add Two Numbers II
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Follow up:
 What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

 Example:

 Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode newHead = null;
        ListNode result = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int dig1 = 0;
            int dig2 = 0;
            if (!stack1.isEmpty()) {
                dig1 = stack1.pop();
            }
            if (!stack2.isEmpty()) {
                dig2 = stack2.pop();
            }
            int sum = dig1 + dig2 + carry;
            if (sum >= 10) {
                carry = 1;
                sum = sum%10;
                newHead = new ListNode(sum);
                newHead.next = result;
                result = newHead;
            } else {
                carry = 0;
                newHead = new ListNode(sum);
                newHead.next = result;
                result = newHead;
            }
        }
        if (carry > 0) {
            newHead = new ListNode(1);
            newHead.next = result;
            result = newHead;
        }
        return result;
    }
}
