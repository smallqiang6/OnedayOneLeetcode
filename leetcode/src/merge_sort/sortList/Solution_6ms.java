package merge_sort.sortList;

import dlx_util.ListNode;

class Solution_6ms {
	public ListNode sortList(ListNode head) {
		return sort(head);
	}

	public ListNode sort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			pre = pre.next;
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode left = head;
		ListNode right = slow;
		pre.next = null;
		return mergeTwo(sort(left), sort(right));
	}

	public ListNode mergeTwo(ListNode n1, ListNode n2) {
		if (n1 == null)
			return n2;
		if (n2 == null)
			return n1;
		ListNode head;
		ListNode node;
		if (n1.val <= n2.val) {
			head = n1;
			node = n1;
			n1 = n1.next;
		} else {
			head = n2;
			node = n2;
			n2 = n2.next;
		}   
		while (n1 != null && n2 != null) {
			if (n1.val <= n2.val) {
				node.next = n1;
				n1 = n1.next;
				node = node.next;
			} else {
				node.next = n2;
				n2 = n2.next;
				node = node.next;
			}
		}
		if (n1 == null)
			node.next = n2;
		else
			node.next = n1;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {4,2,1,3};
		ListNode head = null ;//ͷ�巨
		for(int i:data) {
			ListNode a = new ListNode(i);
			a.next = head;
			head = a;
		}
		
		ListNode sort = new Solution_6ms().sortList(head);
		ListNode p =sort;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
}