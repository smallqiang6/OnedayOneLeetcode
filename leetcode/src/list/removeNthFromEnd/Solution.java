package list.removeNthFromEnd;
/*
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 */
/*
解题思路：双指针
定义两个指针，刚开始分别指向头结点，然后先让一个指针先走n-1步，接着两个指针同时遍历链表，当第一个指针到达链表尾部的时候，第二个指针指向的就是要删除的倒数第n个结点。 
编程需要注意的是：

输入的链表为空，或输入的n不合法；----保证合法
输入的n大于链表的长度；----保证合法
需要保存需要删除的那个结点的上一个结点。----棒
删除的那个结点是头结点。----棒

*/

//靠谱参考：https://blog.csdn.net/zwhlxl/article/details/47104535

public class Solution {
	ListNode removeNthFromEnd(ListNode head, int n) {
		// write your code here

		ListNode p = head;
		ListNode q = head;
		for (int i = 0; i < n; i++) {
			p = p.next;
		}
		if (p == null) {
			head = head.next;
			return head;
		}
		while (p.next != null) {
			p = p.next;
			q = q.next;
		}
		q.next = q.next.next;//删除这个节点
		return head;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
