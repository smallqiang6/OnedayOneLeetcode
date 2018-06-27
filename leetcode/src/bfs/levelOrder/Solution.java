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
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
	    LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

	    //如果为空树就直接返回
	    if(root == null){
	        return result;
	    }

	    queue.offer(root);//根节点先入队
	    //只要队列非空就一直循环;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//获取当前层的节点数.
	        List<Integer> subList = new LinkedList<>();
	        //遍历当前层结点
	        for(int i=0; i<levelNum; i++){
	            //队首出队并将value加入子list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	        }
	        result.addFirst(subList);//添加一层
	    }

	    return result;
	}
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
	    List<List<Integer>> result = new ArrayList<List<Integer>>();

	    //如果为空树就直接返回
	    if(root == null){
	        return result;
	    }

	    queue.offer(root);//根节点先入队
	    //只要队列非空就一直循环;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//获取当前层的节点数.
	        List<Integer> subList = new LinkedList<>();
	        //遍历当前层结点
	        for(int i=0; i<levelNum; i++){
	            //队首出队并将value加入子list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	        }
	        result.add(subList);//添加一层
	    }

	    return result;
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
	    List<List<Integer>> result = new ArrayList<List<Integer>>();

	    //如果为空树就直接返回
	    if(root == null){
	        return result;
	    }
	    int count = 0;
	    queue.offer(root);//根节点先入队
	    //只要队列非空就一直循环;
	    while (!queue.isEmpty()){
	    	count++;
	        int levelNum = queue.size();//获取当前层的节点数.
	        List<Integer> subList = new LinkedList<>();
	        //遍历当前层结点
	        for(int i=0; i<levelNum; i++){
	            //队首出队并将value加入子list
	            TreeNode node = queue.poll();
	            subList.add(node.val);

	            //将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	        }
	        if(count%2 == 0) {
	        	//从右到左
	        	Collections.reverse(subList);
	        }
	        result.add(subList);//添加一层
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
