package test.week95;


import dlx_util.ListNode;

/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/middle-of-the-linked-list/
	
	876. ������м���
	�û�ͨ������ 0
	�û����Դ��� 0
	ͨ������ 0
	�ύ���� 0
	��Ŀ�Ѷ� Easy
	����һ������ͷ��� head �ķǿյ���������������м��㡣

	����������м��㣬�򷵻صڶ����м��㡣

	 

	ʾ�� 1��

	���룺[1,2,3,4,5]
	��������б��еĽ�� 3 (���л���ʽ��[3,4,5])
	���صĽ��ֵΪ 3 �� (����ϵͳ�Ըý�����л������� [3,4,5])��
	ע�⣬���Ƿ�����һ�� ListNode ���͵Ķ��� ans��������
	ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, �Լ� ans.next.next.next = NULL.
	ʾ�� 2��

	���룺[1,2,3,4,5,6]
	��������б��еĽ�� 4 (���л���ʽ��[4,5,6])
	���ڸ��б��������м��㣬ֵ�ֱ�Ϊ 3 �� 4�����Ƿ��صڶ�����㡣
	 

	��ʾ��

	��������Ľ�������� 1 �� 100 ֮�䡣*/
public class Solution {

	public ListNode middleNode(ListNode head) {
		ListNode fast = head;
		ListNode low = head;
		int cntFast = 1;
		int cntLow = 1;
		
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			if(fast == null) {
				cntFast += 1;
			}else {
				cntFast += 2;
			}
			
			low = low.next;
			cntLow += 1;
		}
		
		
		return low;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data1 = { 1,2,3,4,5,6 };
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
		
		System.out.println(new Solution().middleNode(head1).val);
	}

}
