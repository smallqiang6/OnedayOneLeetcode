package bfs.isSymmetric;

import java.util.Stack;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

public class Solution2_iteration {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		Stack<TreeNode> pStack = new Stack<TreeNode>();
		Stack<TreeNode> qStack = new Stack<TreeNode>();
		TreeNode p = root;
		TreeNode q = root;
		while (p != null && q != null) {
			// 当前节点不相等，返回false
			if (!isEqual(p, q))
				return false;
			if (p.right != null)
				pStack.push(p.right);
			if (q.left != null)
				qStack.push(q.left);
			p = p.left;
			q = q.right;
			if (p == null && q == null && !pStack.isEmpty() && !qStack.isEmpty()) {
				p = pStack.pop();
				q = qStack.pop();
			}
		}
		return p == q;
	}

	private boolean isEqual(TreeNode p, TreeNode q) {
		boolean children = true;
		if (p == null || q == null)
			return p == q;
		if (p.left == null || q.right == null)
			children = children && (p.left == q.right);
		if (p.right == null || q.left == null)
			children = children && (p.right == q.left);
		return (p.val == q.val) && children;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tree1 = "1,2,2,3,4,4,3";
		TreeNode tn = DLX_util.createTree(tree1);
		if (true == new Solution2_iteration().isSymmetric(tn)) {
			System.out.println("testcase1 pass");
		}
	}

}
