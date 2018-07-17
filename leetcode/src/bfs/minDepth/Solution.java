package bfs.minDepth;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
*/
/*����һ�����������ҳ�����С��ȡ�

��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ��:

���������� [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
����������С���  2.*/

public class Solution {
	public int minDepth(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
	    
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
	    		
	    		//���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
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
