package test.week92;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import dlx_util.DLX_util;
import dlx_util.TreeNode;

/*https://leetcode-cn.com/contest/weekly-contest-92/problems/smallest-subtree-with-all-the-deepest-nodes/
*/
/*
866. �����������������С����
�û�ͨ������ 0
�û����Դ��� 0
ͨ������ 0
�ύ���� 0
��Ŀ�Ѷ� Medium
����һ����Ϊ root �Ķ�������ÿ���������������������̾��롣

��������������ȣ���ý��������ġ�

���ؾ��������ȵĽ�㣬�Ըý��Ϊ���������а�����������Ľ�㡣

*/

//��BFS��
//1 xiang
public class Solution2 {
	Map<TreeNode, TreeNode> pars;
	
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			return root;
		pars = new HashMap<>();
		dfs(root, null);
		
		List<TreeNode> deepest = bfs_deepest(root);
		System.out.println("deepest:"+deepest.size());
		if(deepest.size() == 1) {
			return deepest.get(0);
		}
		TreeNode par0 = null ;
		List<TreeNode> deeppars = deepest;
		boolean common = false;
		do {
			common = true;
			List<TreeNode> temp = new LinkedList<>();;
			for(TreeNode i : deeppars) {
				temp.add(pars.get(i));
			}
			deeppars = temp;
			par0 = deeppars.get(0);
			System.out.println(par0);
			for(TreeNode i:deeppars) {
				System.out.println(i);
				if(i != par0) {
					common = false;
				}
			}
	
		}while(common == false);
		return par0;
			
    }
	public static List<TreeNode> bfs_deepest(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//���������Ž��
	    List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();

	    List<TreeNode> deepest = null ;
	    //���Ϊ������ֱ�ӷ���
	    if(root == null){
	        return deepest;
	    }

	    queue.offer(root);//���ڵ������
	    //ֻҪ���зǿվ�һֱѭ��;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//��ȡ��ǰ��Ľڵ���.
	        List<TreeNode> subList = new LinkedList<>();
	        //������ǰ����
	        for(int i=0; i<levelNum; i++){
	            //���׳��Ӳ���value������list
	            TreeNode node = queue.poll();
	            subList.add(node);

	            //���ǿ�������������queue
	            if(node.left != null){//������׵����㲻Ϊ�վͰ��������
	                queue.offer(node.left);
	            }
	            if(node.right != null){//������׵��ҽ�㲻Ϊ�վͰ��ҽ�����
	                queue.offer(node.right);
	            }
	        }
	        result.add(subList);//���һ��
	        deepest = subList;
	    }
	    return deepest;
	}
	void dfs(TreeNode root, TreeNode pre) {
		if (root == null)
			return;
		pars.put(root, pre);
		dfs(root.left, root);
		dfs(root.right, root);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree1 = DLX_util.createTree("0,3,1,4,#,2,#,#,6,#,5");
        DLX_util.printTree(tree1);
        System.out.println("---------");
        
        DLX_util.printTree(new Solution2().subtreeWithAllDeepest(tree1));
        
       System.out.println("-------------------------------");
        TreeNode tree2 = DLX_util.createTree("1,#,2");
        DLX_util.printTree(tree2);
        System.out.println("---------");
        
        DLX_util.printTree(new Solution2().subtreeWithAllDeepest(tree2));
        
	}

}
