package bfs.levelOrder;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
	
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import dlx_util.DLX_util;
import dlx_util.TreeNode;

public class Solution {
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
	    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

	    //���Ϊ������ֱ�ӷ���
	    if(root == null){
	        return result;
	    }

	    queue.offer(root);//���ڵ������
	    //ֻҪ���зǿվ�һֱѭ��;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//��ȡ��ǰ��Ľڵ���.
	        List<Integer> subList = new LinkedList<>();
	        //������ǰ����
	        for(int i=0; i<levelNum; i++){
	            //���׳��Ӳ���value������list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
	                queue.offer(node.right);
	            }
	        }
	        result.addFirst(subList);//���һ��
	    }

	    return result;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
	    List<List<Integer>> result = new ArrayList<List<Integer>>();

	    //���Ϊ������ֱ�ӷ���
	    if(root == null){
	        return result;
	    }

	    queue.offer(root);//���ڵ������
	    //ֻҪ���зǿվ�һֱѭ��;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//��ȡ��ǰ��Ľڵ���.
	        List<Integer> subList = new LinkedList<>();
	        //������ǰ����
	        for(int i=0; i<levelNum; i++){
	            //���׳��Ӳ���value������list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
	                queue.offer(node.right);
	            }
	        }
	        result.add(subList);//���һ��
	    }

	    return result;
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
	    List<List<Integer>> result = new ArrayList<List<Integer>>();

	    //���Ϊ������ֱ�ӷ���
	    if(root == null){
	        return result;
	    }
	    int count = 0;
	    queue.offer(root);//���ڵ������
	    //ֻҪ���зǿվ�һֱѭ��;
	    while (!queue.isEmpty()){
	    	count++;
	        int levelNum = queue.size();//��ȡ��ǰ��Ľڵ���.
	        List<Integer> subList = new LinkedList<>();
	        //������ǰ����
	        for(int i=0; i<levelNum; i++){
	            //���׳��Ӳ���value������list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
	                queue.offer(node.right);
	            }
	        }
	        if(count%2 == 0) {
	        	//���ҵ���
	        	Collections.reverse(subList);
	        }
	        result.add(subList);//���һ��
	    }

	    return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String tree1 = "1,2,2,3,4,4,3";
        TreeNode tn = DLX_util.createTree(tree1);
        System.out.println(new Solution().levelOrder(tn));
        
        String tree2 = "3,9,20,#,#,15,7";
        tn = DLX_util.createTree(tree2);
        System.out.println(new Solution().levelOrder(tn));
        
        String tree3 = "3,9,20,#,#,15,7";
        tn = DLX_util.createTree(tree3);
        System.out.println(new Solution().zigzagLevelOrder(tn));
	}

}
