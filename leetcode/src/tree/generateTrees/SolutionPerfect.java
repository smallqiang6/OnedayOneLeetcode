package tree.generateTrees;

import java.util.ArrayList;
import java.util.List;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

public class SolutionPerfect {
	public List<TreeNode> creatTree (int first, int last) {
        List<TreeNode> result = new ArrayList<TreeNode> ();
        if (first > last) {
            result.add(null);
            return result;
        }
        if (first == last) {
            result.add (new TreeNode(first));
            return result;
        }
        for (int i = first; i <= last; i ++) {
            List<TreeNode> leftTree = creatTree(first, i -1);
            List<TreeNode> rightTree = creatTree(i + 1, last);
            for (TreeNode left : leftTree){
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode (i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) return new ArrayList<TreeNode>();
        else return creatTree(1, n);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(TreeNode t:new SolutionPerfect().generateTrees(4)) {
			System.out.println("#############################################");
			DLX_util.printTree(t);
			System.out.println("#############################################");
		}
	}

}
