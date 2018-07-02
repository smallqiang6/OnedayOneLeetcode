package test.week91;
/*
https://leetcode-cn.com/contest/weekly-contest-91/problems/all-nodes-distance-k-in-binary-tree/

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*����һ�������������и���� root���� һ��Ŀ���� target ����һ������ֵ K ��

���ص�Ŀ���� target ����Ϊ K �����н���ֵ���б� �𰸿������κ�˳�򷵻ء�

 

ʾ�� 1��

���룺root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
�����[7,4,1]
���ͣ�
������Ϊ��Ŀ���㣨ֵΪ 5������Ϊ 2 �Ľ�㣬
ֵ�ֱ�Ϊ 7��4���Լ� 1

ע�⣬����� "root" �� "target" ʵ���������ϵĽ�㡣
�������������Ƕ���Щ������������л�������
 

��ʾ��

���������Ƿǿյģ�������� K ����㡣
���ϵ�ÿ����㶼����Ψһ��ֵ 0 <= node.val <= 100 ��
Ŀ���� target �����ϵĽ�㡣
0 <= K <= 200.*/
public class Solution2 {

	
	Map<Integer, TreeNode> pars;
	List<Integer> anss;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		pars = new HashMap<>();
		dfs(root, null);

		anss = new ArrayList<>();
		dfs2(target, K, null);
		return anss;
	}

	void dfs(TreeNode root, TreeNode pre) {
		if (root == null)
			return;
		pars.put(root.val, pre);
		dfs(root.left, root);
		dfs(root.right, root);
	}

	void dfs2(TreeNode root, int rem, TreeNode pre) {
		if (root == null)
			return;
		if (rem == 0)
			anss.add(root.val);
		if (rem > 0) {
			if (root.left != pre)
				dfs2(root.left, rem - 1, root);
			if (root.right != pre)
				dfs2(root.right, rem - 1, root);
			if (pars.get(root.val) != pre)
				dfs2(pars.get(root.val), rem - 1, root);
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String tree1 = "1,2,2,3,4,4,3";
        TreeNode tree1 = DLX_util.createTree("3,5,1,6,2,0,8,#,#,7,4");
        DLX_util.printTree(tree1);
        //System.out.println("test getlevel----"+getlevel(tree1,5));
        
        System.out.println(new Solution2().distanceK(tree1, tree1.left.left, 3));
        
	}

}
