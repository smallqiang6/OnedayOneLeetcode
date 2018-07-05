package dfs.sortedArrayToBST;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
https://www.cnblogs.com/WalkerSteve/p/6614125.html
	*/
/*�����������Binary Search Tree�������֣���������������������������������һ�ÿ����������Ǿ����������ʵĶ������� ���������������գ��������������н���ֵ��С�����ĸ�����ֵ�� ���������������գ��������������н���ֵ���������ĸ�����ֵ�� ������������Ҳ�ֱ�Ϊ����������(���԰ٶȰٿ�)��

ƽ���������Balanced Binary Tree��������һ �ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1����������������������һ��ƽ���������

Ҫ��֤�Ƕ�����������ֻ��Ҫ�ڲ������ʱ��Ӹ���㿪ʼһһ�Ƚϣ���С�ڵ�ǰ��㣬���������������������ڵ��ڣ���������������������ѭ����

����ƽ���������һ���ʣ���Ϊƽ���������������������Ϊһ�ǵݼ����С��ʿ�����̽�Ե�������������ÿ���Դ����м��Ԫ����Ϊ����������㣬ԭ��Ϊ���ַ����ݹ�ʵ�֣�

*/


/*
��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

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
