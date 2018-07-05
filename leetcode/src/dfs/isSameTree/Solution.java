package dfs.isSameTree;

import dlx_util.TreeNode;

public class Solution {

	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if ((p == null && q != null) || (p != null && q == null)) {
			return false;
		}
		if (p.val != q.val) {//判断每个节点的值是否相等，如果去除此判断，则判断两个二叉树是否结构相等
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
