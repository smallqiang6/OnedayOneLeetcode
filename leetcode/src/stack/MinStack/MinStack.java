package stack.MinStack;

import java.util.Stack;

/*
https://leetcode-cn.com/problems/min-stack/description/
	���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��

	push(x) -- ��Ԫ�� x ����ջ�С�
	pop() -- ɾ��ջ����Ԫ�ء�
	top() -- ��ȡջ��Ԫ�ء�
	getMin() -- ����ջ�е���СԪ�ء�
	ʾ��:

	MinStack minStack = new MinStack();
	minStack.push(-2);
	minStack.push(0);
	minStack.push(-3);
	minStack.getMin();   --> ���� -3.
	minStack.pop();
	minStack.top();      --> ���� 0.
	minStack.getMin();   --> ���� -2.	
	*/
/*
������2��ջ���⣬
ջ1��¼����������
ջ2��¼Ŀǰ����Сֵ��
��������push������ʱ��
���ջ2Ϊ�ջ��������С��ջ2���ϵ�ֵ��
�Ͱ����������ջ2��
��pop�������õ�����Сֵʱ��
˵����ǰջ�ڵ���Сֵ�仯�ˣ�
Ҫ���������Сֵ��
��¼����һ����Сֵ����ջ����
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
