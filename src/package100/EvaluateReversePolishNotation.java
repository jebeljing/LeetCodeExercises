package package100;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * Created by jingshanyin on 12/20/16.
 * 150. Evaluate Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

 Valid operators are +, -, *, /. Each operand may be an integer or another expression.

 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;

        Stack<Integer> stack = new Stack<Integer>();
        for (String str: tokens) {
            if (str.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (str.equals( "-")) {
                stack.add(-stack.pop() + stack.pop());
            } else if (str.equals("*")) {
                stack.add(stack.pop()* stack.pop());
            } else if (str.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.add(a/b);
            } else {
                stack.add(Integer.parseInt(str));
            }
        }
        return stack.pop();
        /*int a,b;
		Stack<Integer> S = new Stack<Integer>();
		for (String s : tokens) {
			if(s.equals("+")) {
				S.add(S.pop()+S.pop());
			}
			else if(s.equals("/")) {
				b = S.pop();
				a = S.pop();
				S.add(a / b);
			}
			else if(s.equals("*")) {
				S.add(S.pop() * S.pop());
			}
			else if(s.equals("-")) {
				b = S.pop();
				a = S.pop();
				S.add(a - b);
			}
			else {
				S.add(Integer.parseInt(s));
			}
		}
		return S.pop();*/

    }
}
