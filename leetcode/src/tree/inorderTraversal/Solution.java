package tree.inorderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
//参考：https://blog.csdn.net/baidu_32045201/article/details/79768083
/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
//进阶: 递归算法很简单，你可以通过迭代算法完成吗？使用了堆栈
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
	
	/*使用一个栈来存储二叉树节点，根据中序遍历的规则，我们可以推算出这样的规律： 
	1. 将当前非空节点入栈 
	2. 如果左子节点不为空，则继续将左子节点入栈 
	3. 如果左子节点为空，则抛出栈顶节点并记录 val 值，然后将其右子节点入栈 
	4. 重复 1、2、3 步骤直至栈空*/
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
