package tree.kthSmallest;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

public class Solution {
	int cnt = 0;
	int res = Integer.MIN_VALUE;

	public int kthSmallest(TreeNode root, int k) {
		dfs(root, k);
		return res;
	}

	public void dfs(TreeNode root, int K) {

		if (root.left != null && cnt < K) {
			dfs(root.left, K);
		}
		cnt++;
		if (cnt == K) {
			res = root.val;
			return;
		}

		if (root.right != null && cnt < K) {
			dfs(root.right, K);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = DLX_util.createTree("3,1,4,#,2");
		System.out.println(new Solution().kthSmallest(root, 1));
	}

}
