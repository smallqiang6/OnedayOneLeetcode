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
	
	
	//����������������ҵ�������λ��
    private int findPosition(int[] array, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    //�ؽ���������ͨ���ݹ������һ�������ؽ�
    private TreeNode dfs(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        //���ݺ���������е����һ�����ֽ��������root
        TreeNode root = new TreeNode(postorder[postEnd]);
        //��ȡ������λ��position
        int position = findPosition(inorder, inStart, inEnd, postorder[postEnd]);
        //����������
        root.left = dfs(inorder, inStart, position - 1, postorder, postStart, postStart + (position - inStart- 1));
        //����������
        root.right = dfs(inorder, position + 1, inEnd, postorder, postStart + (position - inStart), postEnd - 1);
        return root;    //���ظ����
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
