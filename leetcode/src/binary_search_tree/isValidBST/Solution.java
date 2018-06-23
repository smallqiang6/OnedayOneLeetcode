package binary_search_tree.isValidBST;
/*
 * ���ײο���https://www.cnblogs.com/grandyang/p/4298435.html
 */

/*
 * 
 */

/*
 * ����ʵ���ϼ����Ѷȣ���Ϊһ��Ķ�������������<=��<�ң���������趨Ϊ��<��<�ң���ô�Ϳ����������������
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
