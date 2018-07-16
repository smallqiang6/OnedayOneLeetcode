package stack.preorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
	
	����һ������������������ ǰ�� ������

	 ʾ��:

	����: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 

	���: [1,2,3]	
*/	
public class Solution {
	List<Integer> res = new LinkedList<Integer>();
	
	/*ʹ��һ��ջ���洢�������ڵ㣬����ǰ������Ĺ������ǿ�������������Ĺ��ɣ� 
	1. �жϵ�ǰ�ǿսڵ� ������¼ val ֵ
	2. ������ӽڵ㲻Ϊ�գ������ӽڵ���ջ ���Ƚ������
	3. ������ӽڵ㲻Ϊ�գ������ӽڵ���ջ ������ȳ���
	4. ����ջ���ڵ�
	4. �ظ� 1��2��3 ��4����ֱ��ջ��*/
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
