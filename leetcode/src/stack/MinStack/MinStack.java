package stack.MinStack;

import java.util.Stack;

/*
https://leetcode-cn.com/problems/min-stack/description/
	设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

	push(x) -- 将元素 x 推入栈中。
	pop() -- 删除栈顶的元素。
	top() -- 获取栈顶元素。
	getMin() -- 检索栈中的最小元素。
	示例:

	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> 返回 -3.
	minStack.pop();
	minStack.top();      --> 返回 0.
	minStack.getMin();   --> 返回 -2.	
	*/
/*
可以用2个栈来解，
栈1记录进来的数，
栈2记录目前的最小值。
当有新数push进来的时候，
如果栈2为空或者这个数小于栈2顶上的值，
就把这个数推入栈2。
当pop的数正好等于最小值时，
说明当前栈内的最小值变化了，
要弹出这个最小值，
记录的下一个最小值来到栈顶。
*/
public class MinStack {
	/** initialize your data structure here. */
	private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack() {
    	stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
    	stack.push(x);
        if (minStack.empty() || minStack.peek() >= x)
            minStack.push(x);
    }
    
    public void pop() {
    	if (stack.peek().equals(minStack.peek()) )
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
    	return minStack.peek();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
