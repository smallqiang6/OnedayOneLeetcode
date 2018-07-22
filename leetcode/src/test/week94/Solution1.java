package test.week94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/leaf-similar-trees/

	考虑一个二叉树的所有叶子。这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



	举个例子，给定一个如上图所示的树，其叶值序列为 (6, 7, 4, 9, 8) 。

	如果两个二叉树的叶值序列相同，我们就认为它们是 叶相似的。

	如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，返回 true；否则返回 false 。
	*/
public class Solution1 {
	
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        dfs(root1,list1);
        dfs(root2,list2);
        if(list1.size() == list2.size()) {
        	for(int i = 0; i < list1.size(); i++) {
        		if(list1.get(i) != list2.get(i)) {
        			return false;
        		}
        	}
        	return true;
        }else {
        	return false;
        }
  		
    }
	
	void dfs(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		
		if (root.left ==  null && root.right == null) {
			list.add(root.val);
			return;
		}

		dfs(root.left,list);
		dfs(root.right,list);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode aNode = DLX_util.createTree("3,5,1,6,2,9,8,#,#,7,4");  //6 7 4 9 8
		DLX_util.printTree(aNode);
		
		TreeNode bNode = DLX_util.createTree("3,5,1,6,7,4,2,#,#,#,#,#,#,9,8");  //6 7 4 9 8
		DLX_util.printTree(bNode);
		
	}

}
