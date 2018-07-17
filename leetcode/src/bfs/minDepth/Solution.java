package bfs.minDepth;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
*/
/*给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.*/

public class Solution {
	public int minDepth(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
	    
	    if(root == null) {
	    	return 0;
	    }
	    
	    queue.add(root);
	    int levelCnt = 0;
	    while(!queue.isEmpty()) {
	    	int levelNum = queue.size();
	    	levelCnt++;
	    	List<Integer> subList = new LinkedList<>();
	    	for(int i=0; i<levelNum; i++){
	    		TreeNode node = queue.poll();
	    		
	    		if(node.left == null && node.right == null) {
	    			return levelCnt;
	    		}
	    		
	    		//将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	    	}
	    }
		return 0;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = DLX_util.createTree("3,9,20,#,#,15,7");
		DLX_util.printTree(root);
		
		System.out.println(new Solution().minDepth(root));
		System.out.println(new Solution().minDepth(null));
		root = DLX_util.createTree("1,2");
		System.out.println(new Solution().minDepth(root));
	}

}
