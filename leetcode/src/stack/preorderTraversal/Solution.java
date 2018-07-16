package stack.preorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
	
	给定一个二叉树，返回它的 前序 遍历。

	 示例:

	输入: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 

	输出: [1,2,3]	
*/	
public class Solution {
	List<Integer> res = new LinkedList<Integer>();
	
	/*使用一个栈来存储二叉树节点，根据前序遍历的规则，我们可以推算出这样的规律： 
	1. 判断当前非空节点 ，并记录 val 值
	2. 如果右子节点不为空，将右子节点入栈 （先进后出）
	3. 如果左子节点不为空，将左子节点入栈 （后进先出）
	4. 弹出栈顶节点
	4. 重复 1、2、3 、4步骤直至栈空*/
	public List<Integer> preorderTraversal(TreeNode root) {  
		Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) {
        	return list;
        }
        while(true){
            //stack.push(root);
        	list.add(root.val);
            if(root.right != null) {
            	stack.push(root.right);
            }
            if(root.left != null) {
            	stack.push(root.left);
            }
            if(stack.isEmpty()) {
            	return list;
            }else {
                root = stack.pop();
            }    
            
        }

    }

	public List<Integer> preorderTraversal_recursion(TreeNode root) {
        preorder(root);
        return res;
    }

	public void preorder(TreeNode root)
	{
		if(root != null)
		{
			res.add(root.val);
			preorder(root.left);
			preorder(root.right);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String tree1 = "1,2,2,3,4,4,3";
		String tree1 = "1,#,2,3";
        TreeNode tn = DLX_util.createTree(tree1);
        DLX_util.printTree(tn);
        System.out.println(new Solution().preorderTraversal_recursion(tn));
        System.out.println(new Solution().preorderTraversal(tn));
	}

}
