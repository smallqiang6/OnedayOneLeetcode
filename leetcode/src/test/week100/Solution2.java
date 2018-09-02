package test.week100;

import java.util.Comparator;
import java.util.PriorityQueue;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/contest/weekly-contest-100/problems/increasing-order-search-tree/
	897. 递增顺序查找树
	用户通过次数 3
	用户尝试次数 7
	通过次数 3
	提交次数 7
	题目难度 Easy
	给定一个二叉树，重新排列树，使树中的最小值现在是树的根结点，并且每个结点没有左子结点，只有一个右子结点。

	 

	示例 ：

	输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

	       5
	      / \
	    3    6
	   / \    \
	  2   4    8
	 /        / \ 
	1        7   9

	输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

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
	 

	提示：

	给定树中的结点数介于 1 和 100 之间。
	每个结点都有一个从 0 到 1000 范围内的唯一整数值。
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
