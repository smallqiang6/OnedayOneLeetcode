package merge_sort.sortList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dlx_util.ListNode;

public class Solution {
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode end = head;
        while(end.next != null) {
        	//System.out.print(end.val+" ");
        	end = end.next;
        }
        mergeSort(head,end);
        
        return head;
    }
	void mergeSort(ListNode head,ListNode end) {
		if(head == end) {
			return;
		}
		//快慢指针法 获取链表的中间节点
		ListNode fast = head;
		ListNode slow = head;
		
		while( fast != end) {
			if(fast.next != end) {
				fast = fast.next.next;
			}else {
				break;
			}
			
			slow = slow.next;
		}
		
		ListNode mid = slow;
		if(head != mid) {
			mergeSort(head,mid);
		}
		if(end != mid) {
			mergeSort(mid.next,end);
		}
		
		merge(head,mid,end);
	}
	
	private void merge(ListNode head, ListNode mid, ListNode end) {
		// TODO Auto-generated method stub
		if(head == mid  && mid == end)
			return;
		ListNode p = head;
		ListNode p1 = mid.next;
		
		List<Integer> valList = new ArrayList<>();

		
		while(p != mid.next && p1 != end.next) {
			if(p.val <= p1.val) {
				valList.add(p.val);
				p = p.next;
			}else {
				valList.add(p1.val);
				p1 = p1.next;
			}
		}
		
		while(p != mid.next) {
			valList.add(p.val);
			p = p.next;
		}
		
		while(p1 != end.next) {
			valList.add(p1.val);
			p1 = p1.next;
		}

		ListNode p2 = head;
		for(int i = 0; i < valList.size();i++) {
			p2.val = valList.get(i);
			p2 = p2.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {4,2,1,3};
		ListNode head = null ;//头插法
		for(int i:data) {
			ListNode a = new ListNode(i);
			a.next = head;
			head = a;
		}
		
		ListNode sort = new Solution().sortList(head);
		ListNode p =sort;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}

}
