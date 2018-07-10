package sort.insert;

import dlx_util.ListNode;

/*
 * https://leetcode-cn.com/problems/insertion-sort-list/description/
 * 
 * ��������Ķ�����ʾ���ϡ��ӵ�һ��Ԫ�ؿ�ʼ����������Ա���Ϊ�Ѿ����������ú�ɫ��ʾ����
ÿ�ε���ʱ���������������Ƴ�һ��Ԫ�أ��ú�ɫ��ʾ������ԭ�ؽ�����뵽���ź���������С�

 

���������㷨��

���������ǵ����ģ�ÿ��ֻ�ƶ�һ��Ԫ�أ�ֱ������Ԫ�ؿ����γ�һ�����������б�
ÿ�ε����У���������ֻ�������������Ƴ�һ���������Ԫ�أ��ҵ������������ʵ���λ�ã���������롣
�ظ�ֱ�������������ݲ�����Ϊֹ��*/
public class Solution {
	public ListNode insertionSortList(ListNode head) {
		ListNode preHead = new ListNode(Integer.MIN_VALUE);
		preHead.next = null;
		ListNode p = head;// pָ�������Ҫ����Ľڵ�

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
		ListNode head = null;// ͷ�巨
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
