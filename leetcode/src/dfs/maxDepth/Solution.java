package dfs.maxDepth;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

public class Solution {

	int maxdepth = 0;
	public int maxDepth(TreeNode root) {
		dfs(root,1);
		return maxdepth;
    }
	
	void dfs(TreeNode root, int curdeep) {
		if (root == null)
			return;
		maxdepth = Math.max(maxdepth, curdeep);
		dfs(root.left,curdeep+1);
		dfs(root.right,curdeep+1);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TreeNode tree1 = DLX_util.createTree("3,9,20,#,#,15,7");
		TreeNode tree1 = DLX_util.createTree("3");
        DLX_util.printTree(tree1);
        System.out.println(new Solution().maxDepth(tree1));
	}

}
