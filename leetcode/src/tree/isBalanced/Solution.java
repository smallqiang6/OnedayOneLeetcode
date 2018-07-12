package tree.isBalanced;

import dlx_util.DLX_util;
import dlx_util.TreeNode;


public class Solution {

	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		
        int left = deep(root.left);
        int right = deep(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        if(left != 0) {
        	if(false == isBalanced(root.left)) {
        		return false;
        	}
        }
        if(right != 0) {
        	if(false == isBalanced(root.right)) {
        		return false;
        	}
        }
        return true;
    }
	public int deep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        return Math.max(left, right) + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree1 = DLX_util.createTree("1,2,2,3,#,#,3,4,#,#,4");
        DLX_util.printTree(tree1);
        System.out.println("---------");
        
        System.out.println(new Solution().isBalanced(tree1));
	}

}
