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

/*给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

 

示例 1：

输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
输出：[7,4,1]
解释：
所求结点为与目标结点（值为 5）距离为 2 的结点，
值分别为 7，4，以及 1

注意，输入的 "root" 和 "target" 实际上是树上的结点。
上面的输入仅仅是对这些对象进行了序列化描述。
 

提示：

给定的树是非空的，且最多有 K 个结点。
树上的每个结点都具有唯一的值 0 <= node.val <= 100 。
目标结点 target 是树上的结点。
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
