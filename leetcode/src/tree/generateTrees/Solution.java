package tree.generateTrees;

import java.util.LinkedList;
import java.util.List;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*
https://leetcode-cn.com/problems/unique-binary-search-trees-ii/description/
*/
/*
给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

示例:

输入: 3
输出:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释:
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/   
public class Solution {
	public List<TreeNode> generateTrees(int n) {
        // write your code here
        if(n==0){
            //List<TreeNode> R = new LinkedList<TreeNode>();
            //R.add(null);
            return null;
        }
        return generateTrees(1,n);
    }
    private TreeNode copy(TreeNode Old){
        if(Old==null)
            return null;
        TreeNode T = new TreeNode(Old.val);
        T.right = copy(Old.right);
        T.left = copy(Old.left);
        return T;
    }
    List<TreeNode> generateTrees(int start, int last){
        if(start>last)
            return null;
        List<TreeNode> result = new LinkedList<TreeNode>();
        for(int i=start;i<=last;++i){
            TreeNode root = new TreeNode(i);
            List<TreeNode> left = generateTrees(start,i-1);
            List<TreeNode> right = generateTrees(i+1,last);
            if(left==null&&right==null)
                result.add(root);
            else if(left==null){
                for(TreeNode R:right){
                    root.right = R;
                    result.add(copy(root));
                }
            }
            else if(right==null){
                for(TreeNode L:left){
                    root.left = L;
                    result.add(copy(root));
                }
            }
            else{
                for(TreeNode L:left)
                    for(TreeNode R:right){
                        root.left = L;
                        root.right = R;
                        result.add(copy(root));
                    }
            }
        }
        return result;
    }
	public static void main(String[] args) {
		for(TreeNode t:new Solution().generateTrees(4)) {
			System.out.println("#############################################");
			DLX_util.printTree(t);
			System.out.println("#############################################");
		}
	}

}
