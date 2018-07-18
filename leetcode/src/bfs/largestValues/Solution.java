package bfs.largestValues;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
*/	
/*
����Ҫ�ڶ�������ÿһ�����ҵ�����ֵ��

ʾ����

����: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

���: [1, 3, 9]
		*/
public class Solution {

	public List<Integer> largestValues(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
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
	    		
	    		//���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
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
