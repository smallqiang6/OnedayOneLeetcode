package bfs.isSymmetric;
import dlx_util.DLX_util;
import dlx_util.TreeNode;
//import dlx_util.DLX_util.TreeNode;
public class Solution {
	public boolean isSymmetric(TreeNode root) {
		TreeNode p = root;
		TreeNode q = root;
		return helper(p, q);
	}

	private boolean helper(TreeNode p, TreeNode q) {
		// 判断有没有节点为null的情况，一句话搞定
		if (p == null || q == null)
			return p == q;
		//System.out.println("BFS-check:p="+p.val+";q="+q.val);
		return (p.val == q.val) && helper(p.left, q.right) && helper(p.right, q.left);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tree1 = "1,2,2,3,4,4,3";
        TreeNode tn = DLX_util.createTree(tree1);
        if(true == new Solution().isSymmetric(tn))
        {
        	System.out.println("testcase1 pass");
        }
	}

}
