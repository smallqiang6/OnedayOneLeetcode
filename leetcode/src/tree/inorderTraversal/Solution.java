package tree.inorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
//�ο���https://blog.csdn.net/baidu_32045201/article/details/79768083
/*
����һ���������������������� ������

ʾ��:

����: [1,null,2,3]
   1
    \
     2
    /
   3

���: [1,3,2]
//����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨�����ʹ���˶�ջ
*/

public class Solution {

	List<Integer> res = new LinkedList<Integer>();
	public List<Integer> inorderTraversal_recursion(TreeNode root) {
		
        inorder(root);
        return res;
    }

	public void inorder(TreeNode root)
	{
		if(root != null)
		{
			inorder(root.left);
			res.add(root.val);
			inorder(root.right);
		}
	}
	
	/*ʹ��һ��ջ���洢�������ڵ㣬������������Ĺ������ǿ�������������Ĺ��ɣ� 
	1. ����ǰ�ǿսڵ���ջ 
	2. ������ӽڵ㲻Ϊ�գ�����������ӽڵ���ջ 
	3. ������ӽڵ�Ϊ�գ����׳�ջ���ڵ㲢��¼ val ֵ��Ȼ�������ӽڵ���ջ 
	4. �ظ� 1��2��3 ����ֱ��ջ��*/
	public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(true){
            if (root != null){
                stack.push(root);
                root = root.left;
            } else {
                if (stack.empty()) {
                    return list;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String tree1 = "1,2,2,3,4,4,3";
        TreeNode tn = DLX_util.createTree(tree1);
        System.out.println(new Solution().inorderTraversal(tn));
        
        String tree2 = "3,9,20,#,#,15,7";
        tn = DLX_util.createTree(tree2);
        System.out.println(new Solution().inorderTraversal(tn));
        
        String tree3 = "1,#,2,3";
        tn = DLX_util.createTree(tree3);
        System.out.println(new Solution().inorderTraversal(tn));
	}

}
