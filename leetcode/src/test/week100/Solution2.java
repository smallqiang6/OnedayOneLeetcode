package test.week100;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/contest/weekly-contest-100/problems/increasing-order-search-tree/
	897. ����˳�������
	�û�ͨ������ 3
	�û����Դ��� 7
	ͨ������ 3
	�ύ���� 7
	��Ŀ�Ѷ� Easy
	����һ����������������������ʹ���е���Сֵ���������ĸ���㣬����ÿ�����û�����ӽ�㣬ֻ��һ�����ӽ�㡣

	 

	ʾ�� ��

	���룺[5,3,6,2,4,null,8,1,null,null,null,7,9]

	       5
	      / \
	    3    6
	   / \    \
	  2   4    8
	 /        / \ 
	1        7   9

	�����[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	          \
	           6
	            \
	             7
	              \
	               8
	                \
	                 9  
	 

	��ʾ��

	�������еĽ�������� 1 �� 100 ֮�䡣
	ÿ����㶼��һ���� 0 �� 1000 ��Χ�ڵ�Ψһ����ֵ��
*/
public class Solution2 {
	PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>(new Comparator<TreeNode>() {

		@Override
		public int compare(TreeNode t1, TreeNode t2) {
			// TODO Auto-generated method stub
			return t1.val - t2.val;
		}
	});
	public TreeNode increasingBST(TreeNode root) {
		//DLX_util.printTree(root);
		TreeNode res,pre;
		dfs(root);

		//System.out.println(queue.size());
		res = queue.peek();
		pre = queue.poll();
		
		while(!queue.isEmpty()) {
			pre.left = null;
			pre.right = queue.poll();
			pre = pre.right;
		}
		
		return res;
    }
	void dfs(TreeNode t) {
		if(t == null) {
			return;
		}
		queue.add(t);
		dfs(t.left);
		dfs(t.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String in = "5,3,6,2,4,#,8,1,#,#,#,7,9";
		DLX_util.printTree(new Solution2().increasingBST(DLX_util.createTree(in)));
	}

}
