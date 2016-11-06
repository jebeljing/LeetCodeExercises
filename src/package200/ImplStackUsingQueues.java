package package200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jingshanyin on 11/6/16.
 * 225. Implement Stack using Queues
 * Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.
 Notes:
 You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class ImplStackUsingQueues {
    private Queue<Integer> queue;

    ImplStackUsingQueues() {
        queue = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack
    public void pop() {
        queue.poll();
    }

    // Get the top element
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
































}
