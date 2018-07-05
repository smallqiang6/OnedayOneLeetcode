package dfs.sortedArrayToBST;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
https://www.cnblogs.com/WalkerSteve/p/6614125.html
	*/
/*二叉查找树（Binary Search Tree）：（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树： 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树(来自百度百科)；

平衡二叉树（Balanced Binary Tree）：它是一 棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树；

要保证是二叉搜索树，只需要在插入结点的时候从根结点开始一一比较，若小于当前结点，则搜索其左子树；若大于等于，则搜索其右子树，依次循环；

根据平衡二叉树的一性质：若为平衡二叉树，则中序遍历结果为一非递减序列。故可以试探性地在有序数组中每次以处于中间的元素作为二叉树根结点，原理为二分法，递归实现；

*/


/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 
 
*/
public class Solution {
	TreeNode root = null;
	public TreeNode sortedArrayToBST(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		dfs(nums, left, right);
		
		return root;
        
    }
	
	public void dfs(int[] nums,int left,int right) {
		if(left <= right) {
			int mid = (left+right) / 2;
			insert(nums[mid]);
			dfs(nums, left, mid - 1);
			dfs(nums, mid +1,right);
			
		}
	}
	
	public void insert(int val) {
		TreeNode node = new TreeNode(val);
		if(root == null) {
			root = node;
		}else {
			TreeNode current = root;
			TreeNode parent;
			while(true) {
				parent = current;
				if(val < parent.val) {
					current = parent.left;
					if(current == null) {
						parent.left = node;
						return;
					}
						
					
				}else {
					current = parent.right;
					if(current == null) {
						parent.right = node;
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {-10,-3,0,5,9};
		TreeNode tree = new Solution().sortedArrayToBST(data);
		DLX_util.printTree(tree);
		
	}

}
