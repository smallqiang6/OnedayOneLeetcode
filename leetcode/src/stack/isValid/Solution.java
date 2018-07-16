package stack.isValid;
/*
https://leetcode-cn.com/problems/valid-parentheses/description/
*/
import java.util.Stack;

public class Solution {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		int slen = s.length();
		char elm;
		for (int i = 0; i < slen; i++) {
			elm = s.charAt(i);
			if (elm == '[' || elm == '(' || elm == '{')
				stack.push(elm);
			else if (elm == ']') {
				if (stack.empty())
					return false;
				char top = stack.peek();
				if (top == '[')
					stack.pop();
				else
					return false;
			} else if (elm == ')') {
				if (stack.empty())
					return false;
				char top = stack.peek();
				if (top == '(')
					stack.pop();
				else
					return false;
			} else if (elm == '}') {
				if (stack.empty())
					return false;
				char top = stack.peek();
				if (top == '{')
					stack.pop();
				else
					return false;
			}
		}

		if (stack.empty() == true)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
