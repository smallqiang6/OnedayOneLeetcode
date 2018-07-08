package test.week92;

import dlx_util.DLX_util;
import dlx_util.TreeNode;
/*https://leetcode-cn.com/contest/weekly-contest-92/problems/smallest-subtree-with-all-the-deepest-nodes/
*/
/*
866. �����������������С����
�û�ͨ������ 0
�û����Դ��� 0
ͨ������ 0
�ύ���� 0
��Ŀ�Ѷ� Medium
����һ����Ϊ root �Ķ�������ÿ���������������������̾��롣

��������������ȣ���ý��������ġ�

���ؾ��������ȵĽ�㣬�Ըý��Ϊ���������а�����������Ľ�㡣

*/
public class Solution2_2 {
	TreeNode rst;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return root;
        }
        int left = deep(root.left);
        int right = deep(root.right);
        if (left == right) {
            return root;
        }
        if (left > right) {
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
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
		// TODO Auto-generated method stub
		TreeNode tree1 = DLX_util.createTree("0,3,1,4,#,2,#,#,6,#,5");
        DLX_util.printTree(tree1);
        System.out.println("---------");
        
        DLX_util.printTree(new Solution2_2().subtreeWithAllDeepest(tree1));
        
       System.out.println("-------------------------------");
        TreeNode tree2 = DLX_util.createTree("1,#,2");
        DLX_util.printTree(tree2);
        System.out.println("---------");
        
        DLX_util.printTree(new Solution2_2().subtreeWithAllDeepest(tree2));
        
	}

}
