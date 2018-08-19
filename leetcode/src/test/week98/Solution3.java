package test.week98;

import java.util.Arrays;

import dlx_util.DLX_util;
import dlx_util.TreeNode;
import jdk.nashorn.api.tree.ArrayAccessTree;

public class Solution3 {

	// 889. ����ǰ��ͺ���������������
	// �û�ͨ������ 8
	// �û����Դ��� 11
	// ͨ������ 8
	// �ύ���� 18
	// ��Ŀ�Ѷ� Medium
	// �����������ǰ��ͺ������ƥ����κζ�������
	//
	// pre �� post �����е�ֵ�ǲ�ͬ����������
	//
	//
	//
	// ʾ����
	//
	// ���룺pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
	// �����[1,2,3,4,5,6,7]
	//
	//
	// ��ʾ��
	//
	// 1 <= pre.length == post.length <= 30
	// pre[] �� post[] ���� 1, 2, ..., pre.length ������
	// ÿ�����뱣֤������һ���𰸡�����ж���𰸣����Է�������һ����
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		// pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
		// root:1
		// left: 245 452
		// right:367 673
		TreeNode root = new TreeNode(pre[0]);
		if (pre.length == 1) {
			return root;
		}

		int rightChild = post[post.length - 1 - 1];// 3 //�п���û��rightChild
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

		if (rightChild == leftChild) // ˵������������һ��Ϊ��
		{
			// pre:1 3 post:3,1
			// 1
			// /
			// 3
			// ��������¾��ж��ִ�

			if (postIndexRightChild == post.length - 1) {
				root.right = null;
				//��ʱ��loop2ȷ������ڵ㷶Χ�Ǿ�ȷ��
				int[] leftPre = Arrays.copyOfRange(pre, 1, 1+postIndexRightChild);
				int[] leftPost = Arrays.copyOfRange(post, 0, postIndexRightChild);
				root.left = constructFromPrePost(leftPre, leftPost);
			} else {
				root.left = null;
				//��ʱ��loop1ȷ�����ҽڵ㷶Χ�Ǿ�ȷ��
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
