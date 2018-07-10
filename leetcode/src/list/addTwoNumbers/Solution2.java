package list.addTwoNumbers;
/*
两数相加第二题
https://leetcode-cn.com/problems/add-two-numbers-ii/description/
*/
/*
给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。



你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:

输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
输出: 7 -> 8 -> 0 -> 7
*/

import java.util.Stack;

import dlx_util.ListNode;
import sort.insert.Solution;



public class Solution2 {

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		
		ListNode p = l1;
		while(p != null) {
			stack1.push(p.val);
			p = p.next;
		}
		p = l2;
		while(p != null) {
			stack2.push(p.val);
			p = p.next;
		}
		//int a = 0,b = 0;
		int carry = 0;
		int sum = 0;
		ListNode head = null;
		
		while(stack1.isEmpty() == false && stack2.isEmpty() == false) {
		//new 一个新节点，用头插法插入。
			ListNode one = new ListNode(0);
			sum = stack1.pop() + stack2.pop() + carry;
			carry = sum / 10; // 本次进位
			
			one.val = sum % 10; // 本位的结果
			one.next = head;
            head = one;	
		}
		if(stack1.isEmpty()) {
			while(stack2.isEmpty() == false) {
				ListNode one = new ListNode(0);
				sum = stack2.pop() + carry;
				carry = sum / 10; // 本次进位
				
				one.val = sum % 10; // 本位的结果
				one.next = head;
	            head = one;	
			}
		}
		if(stack2.isEmpty()) {
			while(stack1.isEmpty() == false) {
				ListNode one = new ListNode(0);			
				sum = stack1.pop() + carry;
				carry = sum / 10;
				
				one.val = sum % 10;
				one.next = head;
				head = one;
			}
		}
		if (carry == 1) {
			ListNode one = new ListNode(1);
			one.next = head;
			head = one;
		}
		
		return head;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data1 = { 7, 2, 4, 3 };
		ListNode pre1 = null;
		ListNode head1 = null;
		for (int i : data1) {
			ListNode a = new ListNode(i);
			if(pre1 != null)
				pre1.next = a;
			else
				head1 = a;
			a.next = null;
			pre1 = a;
		}
		int[] data2 = { 5, 6, 4 };
		ListNode pre2 = null;
		ListNode head2 = null;
		for (int i : data2) {
			ListNode a = new ListNode(i);
			if(pre2 != null)
				pre2.next = a;
			else
				head2 = a;
			a.next = null;
			pre2 = a;
		}
		
		ListNode res = new Solution2().addTwoNumbers(head1,head2);
		ListNode p = res;
		while (p != null) {
			System.out.println("--" + p.val);
			p = p.next;
		}
		
	}

}
