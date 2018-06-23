package binary_search_tree.isValidBST;
/*
 * 靠谱参考：https://www.cnblogs.com/grandyang/p/4298435.html
 */

/*
 * 
 */

/*
 * 这题实际上简化了难度，因为一般的二叉搜索树是左<=根<右，而这道题设定为左<根<右，那么就可以用中序遍历来做
 */
public class Solution {
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	public boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
