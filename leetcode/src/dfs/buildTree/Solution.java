package dfs.buildTree;
/*
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
	
	ǰ��������еĵ�һ��Ԫ��һ���Ǹ����ĸ��ڵ㣬
	����Ӵ����֣�����������������ҵ���Ԫ�أ���������Ԫ�ض����Ը�Ԫ��Ϊ���ڵ���������Ľڵ㣬��������Ԫ�ض����Ը�Ԫ��Ϊ���ڵ���������Ľڵ㣬
	���ڴ˽����߷�Ϊ����������������������������������µ����顣
	ͬʱ��ǰ����������и��ڵ�֮��Ľڵ㶼���Ȱ��������ڵ������ϲű����������ڵ�ģ�
	��˿��Ը�����������������������ڵ���������ҵ�������������������������Ԫ�أ�����Ϊ�����µ�ǰ��������������顣
	Ȼ�����õݹ�ֱ������������ǰ����������н��д����������Ϊ���򷵻�null���������ֻ��һ��ֵ����ж�ΪҶ�ӽڵ㣬���ص�ǰ�ڵ㡣
	���տɵõ�һ�������Ķ�������	
	
*/
import dlx_util.TreeNode;

public class Solution {

	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || inorder == null || preorder.length==0){
            return null;
        }
        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        
    }
	public TreeNode dfs(int[] preorder/* ǰ����� */,int preSt,int preEnd,int[] inorder/* ������� */,int inSt,int inEnd){
		//ǰ�������һ���ڵ��Ǹ��ڵ�
        int rootValue = preorder[preSt];
        TreeNode root = new TreeNode(rootValue);//���շ��صľ���һ��root
        
        //ǰ������ֻ�и��ڵ�
        if(preSt == preEnd){
            return root;
        }
        //�����������У��ҵ����ڵ��λ��
        int rootInorder = inSt;
        while(inorder[rootInorder]!=rootValue&&rootInorder<=inEnd){
            rootInorder++;
        }
        
        //�������ĳ���
        int leftLength = rootInorder - inSt;
        //ǰ�������������������һ���ڵ�
        int leftPreEnd = preSt + leftLength;
        
        //�������ǿ�
        if(leftLength>0){
            //�ؽ�������
            root.left = dfs(preorder,preSt+1,leftPreEnd,inorder,inSt,inEnd);
        }
        //�������ǿ�
        if(leftLength < preEnd - preSt){
            //�ؽ�������
            root.right = dfs(preorder,leftPreEnd +1,preEnd,inorder,rootInorder+1,inEnd);
        }
        
        return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
