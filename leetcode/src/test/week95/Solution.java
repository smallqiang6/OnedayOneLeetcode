package test.week95;


import dlx_util.ListNode;

/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/middle-of-the-linked-list/
	
	876. 链表的中间结点
	用户通过次数 0
	用户尝试次数 0
	通过次数 0
	提交次数 0
	题目难度 Easy
	给定一个带有头结点 head 的非空单链表，返回链表的中间结点。

	如果有两个中间结点，则返回第二个中间结点。

	 

	示例 1：

	输入：[1,2,3,4,5]
	输出：此列表中的结点 3 (序列化形式：[3,4,5])
	返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
	注意，我们返回了一个 ListNode 类型的对象 ans，这样：
	ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
	示例 2：

	输入：[1,2,3,4,5,6]
	输出：此列表中的结点 4 (序列化形式：[4,5,6])
	由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
	 

	提示：

	给定链表的结点数介于 1 和 100 之间。*/
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
