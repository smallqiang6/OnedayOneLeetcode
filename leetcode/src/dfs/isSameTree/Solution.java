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
		if (p.val != q.val) {//�ж�ÿ���ڵ��ֵ�Ƿ���ȣ����ȥ�����жϣ����ж������������Ƿ�ṹ���
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
