package bfs.largestValues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
*/	
/*
您需要在二叉树的每一行中找到最大的值。

示例：

输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]
		*/
public class Solution {

	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
		List<Integer> list = new LinkedList<Integer>();
	    
	    if(root == null) {
	    	return list;
	    }
	    
	    queue.add(root);
	    int levelCnt = 0;
	    while(!queue.isEmpty()) {
	    	int levelNum = queue.size();
	    	levelCnt++;
	    	List<Integer> subList = new LinkedList<>();
	    	int levelMax = Integer.MIN_VALUE;
	    	for(int i=0; i<levelNum; i++){
	    		TreeNode node = queue.poll();
	    		levelMax = Math.max(levelMax, node.val);
	    		
	    		if(node.left == null && node.right == null) {
	    			//return levelCnt;
	    			continue;
	    		}
	    		
	    		//将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	    	}
	    	list.add(levelMax);
	    }
		return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
