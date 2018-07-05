package dfs.buildTree;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/

*/
public class Solution2 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder == null || inorder == null || postorder.length==0){
            return null;
        }
        //return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
		return dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
	
	
	//在中序遍历序列中找到根结点的位置
    private int findPosition(int[] array, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    //重建二叉树，通过递归调用来一步步的重建
    private TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        //根据后序遍历序列的最后一个数字建立根结点root
        TreeNode root = new TreeNode(postorder[postEnd]);
        //获取根结点的位置position
        int position = findPosition(inorder, inStart, inEnd, postorder[postEnd]);
        //创建左子树
        root.left = dfs(inorder, inStart, position - 1, postorder, postStart, postStart + (position - inStart- 1));
        //创建右子树
        root.right = dfs(inorder, position + 1, inEnd, postorder, postStart + (position - inStart), postEnd - 1);
        return root;    //返回根结点
    }
    public TreeNode buildTree_demo(int[] inorder, int[] postorder) {
        // write your code here
        if (inorder.length != postorder.length) {
            return null;
        }
        return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int inorder[] = {9,3,15,20,7};
		int postorder[] = {9,15,7,20,3};
		*/
		int inorder[] = {3,2,1};
		int postorder[] = {3,2,1};
		DLX_util.printTree(new Solution2().buildTree_demo(inorder, postorder));
		DLX_util.printTree(new Solution2().buildTree(inorder, postorder));

	}

}
