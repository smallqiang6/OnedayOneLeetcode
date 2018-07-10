package sort.insert;

import dlx_util.ListNode;

/*
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 * 
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。*/
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode preHead = new ListNode(Integer.MIN_VALUE);
		preHead.next = null;
		ListNode p = head;// p指向接下来要加入的节点

		while (p != null) {
			ListNode temp = p;
			p = p.next;
			insertNode(preHead, temp);
		}
		return preHead.next;
	}

	private void insertNode(ListNode head, ListNode n) {
		// TODO Auto-generated method stub
		ListNode p = head;
		ListNode pre = null;

		while (p.val <= n.val) {
			pre = p;
			p = p.next;
			if (p == null)
				break;
		}
		// pre n p
		// pre null
		pre.next = n;
		n.next = p;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 4, 2, 1, 3 };
		ListNode head = null;// 头插法
		for (int i : data) {
			ListNode a = new ListNode(i);
			a.next = head;
			head = a;
		}

		ListNode sort = new Solution().insertionSortList(head);
		ListNode p = sort;
		while (p != null) {
			System.out.println("--" + p.val);
			p = p.next;
		}
	}

}
