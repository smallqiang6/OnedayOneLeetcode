package test.week100;

import dlx_util.TreeNode;

public class Solution2_AC {

	public TreeNode increasingBST(TreeNode root) {
    	TreeNode dummy = new TreeNode(1);
        dfs(root, dummy);
        return dummy.right;
    }
    
    TreeNode dfs(TreeNode root, TreeNode p)
    {
    	if(root == null)return p;
    	p = dfs(root.left, p);
    	TreeNode c = new TreeNode(root.val);
    	p.right = c;
    	p = c;
    	p = dfs(root.right, p);
    	return p;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
