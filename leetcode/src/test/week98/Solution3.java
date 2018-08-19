package test.week98;

import java.util.Arrays;

import dlx_util.DLX_util;
import dlx_util.TreeNode;
import jdk.nashorn.api.tree.ArrayAccessTree;

public class Solution3 {

	// 889. 根据前序和后序遍历构造二叉树
	// 用户通过次数 8
	// 用户尝试次数 11
	// 通过次数 8
	// 提交次数 18
	// 题目难度 Medium
	// 返回与给定的前序和后序遍历匹配的任何二叉树。
	//
	// pre 和 post 遍历中的值是不同的正整数。
	//
	//
	//
	// 示例：
	//
	// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
	// 输出：[1,2,3,4,5,6,7]
	//
	//
	// 提示：
	//
	// 1 <= pre.length == post.length <= 30
	// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列
	// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		// pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
		// root:1
		// left: 245 452
		// right:367 673
		TreeNode root = new TreeNode(pre[0]);
		if (pre.length == 1) {
			return root;
		}

		int rightChild = post[post.length - 1 - 1];// 3 //有可能没有rightChild
		int preIndexRightChild = 0;

		int leftChild = pre[1];// 2
		int postIndexRightChild = 0;

		//loop1
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] == rightChild) {
				preIndexRightChild = i;// pre[4] preIndexRightChild = 4
			}
		}
		//loop2
		for (int i = 0; i < post.length; i++) {
			if (post[i] == leftChild) {
				postIndexRightChild = i + 1;
			}
		}

		if (rightChild == leftChild) // 说明左右子其中一个为空
		{
			// pre:1 3 post:3,1
			// 1
			// /
			// 3
			// 这种情况下就有多种答案

			if (postIndexRightChild == post.length - 1) {
				root.right = null;
				//这时候loop2确定的左节点范围是精确的
				int[] leftPre = Arrays.copyOfRange(pre, 1, 1+postIndexRightChild);
				int[] leftPost = Arrays.copyOfRange(post, 0, postIndexRightChild);
				root.left = constructFromPrePost(leftPre, leftPost);
			} else {
				root.left = null;
				//这时候loop1确定的右节点范围是精确的
				int[] rightPre = Arrays.copyOfRange(pre, preIndexRightChild, pre.length);
				int[] rightPost = Arrays.copyOfRange(post, postIndexRightChild, pre.length - 1);
				root.right = constructFromPrePost(rightPre, rightPost);
			}
			return root;
		}

		int[] rightPre = Arrays.copyOfRange(pre, preIndexRightChild, pre.length);
		int[] rightPost = Arrays.copyOfRange(post, postIndexRightChild, pre.length - 1);
		root.right = constructFromPrePost(rightPre, rightPost);

		int[] leftPre = Arrays.copyOfRange(pre, 1, preIndexRightChild);
		int[] leftPost = Arrays.copyOfRange(post, 0, postIndexRightChild);
		root.left = constructFromPrePost(leftPre, leftPost);

		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 }, post = { 4, 5, 2, 6, 7, 3, 1 };
		//int[] pre = { 2, 1, 3 }, post = { 3, 1, 2 };
		DLX_util.printTree(new Solution3().constructFromPrePost(pre, post));
	}

}
