package bfs.maxDepth;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dlx_util.Node;
import dlx_util.TreeNode;

public class Solution {
	//二叉树的maxDepth
	public int maxDepth(TreeNode root) {
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
	    }
		return levelCnt;
    }
	public int maxDepth(Node root) {
		if(root == null) {
	    	return 0;
	    }
		Queue<Node> queue = new LinkedList<Node>();
		
		int levelCnt = 0;
		queue.add(root);
		while(!queue.isEmpty()) {
			int levelNum = queue.size();
			levelCnt++;
			for(int i=0;i<levelNum;i++) {
				Node node = queue.poll();
				
				if(node.children.size() == 0) {
					continue;
				}
				
				for(Node child:node.children) {
					queue.add(child);
				}
			}
	
		}
		
		return levelCnt;
        
    }
	public int maxDepth_recursion(Node root) {
        
        if(root==null){
            return 0;
        }
        
        int depth = 0;
        
        
        if(root.children!=null && root.children.size()>0){
            for(Node tem : root.children){
                depth = Math.max(depth, maxDepth(tem));
            }
        }
        
        return 1+depth;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
