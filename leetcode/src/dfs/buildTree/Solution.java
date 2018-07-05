package dfs.buildTree;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
	
	前序遍历序列的第一个元素一定是该树的根节点，
	因而从此入手，在中序遍历序列中找到该元素，其左所有元素都是以该元素为根节点的左子树的节点，其右所有元素都是以该元素为根节点的右子树的节点，
	可在此将两边分为左子树和右子树的中序遍历子序列两个新的数组。
	同时，前序遍历序列中根节点之后的节点都是先把左子树节点遍历完毕才遍历右子树节点的，
	因此可以根据中序遍历序列中左子树节点的数量，找到所有属于左子树和右子树的元素，并分为两个新的前序遍历子序列数组。
	然后利用递归分别对左右子树的前序和中序序列进行处理，如果序列为空则返回null，如果序列只有一个值则可判断为叶子节点，返回当前节点。
	最终可得到一个完整的二叉树。	
	
*/
import dlx_util.TreeNode;

public class Solution {

	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length==0){
            return null;
        }
        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
	public TreeNode dfs(int[] preorder/* 前序遍历 */,int preSt,int preEnd,int[] inorder/* 中序遍历 */,int inSt,int inEnd){
		//前序遍历第一个节点是根节点
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);//最终返回的就是一个root
        
        //前序序列只有根节点
        if(preSt == preEnd){
            return root;
        }
        //遍历中序序列，找到根节点的位置
        int rootInorder = inSt;
        while(inorder[rootInorder]!=rootValue&&rootInorder<=inEnd){
            rootInorder++;
        }
        
        //左子树的长度
        int leftLength = rootInorder - inSt;
        //前序序列中左子树的最后一个节点
        int leftPreEnd = preSt + leftLength;
        
        //左子树非空
        if(leftLength>0){
            //重建左子树
            root.left = dfs(preorder,preSt+1,leftPreEnd,inorder,inSt,inEnd);
        }
        //右子树非空
        if(leftLength < preEnd - preSt){
            //重建右子树
            root.right = dfs(preorder,leftPreEnd +1,preEnd,inorder,rootInorder+1,inEnd);
        }
        
        return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
