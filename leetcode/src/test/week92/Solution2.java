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
866. 具有所有最深结点的最小子树
用户通过次数 0
用户尝试次数 0
通过次数 0
提交次数 0
题目难度 Medium
给定一个根为 root 的二叉树，每个结点的深度是它到根的最短距离。

如果结点具有最大深度，则该结点是最深的。

返回具有最大深度的结点，以该结点为根的子树中包含所有最深的结点。

*/

//用BFS做
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
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
	    List<List<TreeNode>> result = new ArrayList<List<TreeNode>>();

	    List<TreeNode> deepest = null ;
	    //如果为空树就直接返回
	    if(root == null){
	        return deepest;
	    }

	    queue.offer(root);//根节点先入队
	    //只要队列非空就一直循环;
	    while (!queue.isEmpty()){
	        int levelNum = queue.size();//获取当前层的节点数.
	        List<TreeNode> subList = new LinkedList<>();
	        //遍历当前层结点
	        for(int i=0; i<levelNum; i++){
	            //队首出队并将value加入子list
	            TreeNode node = queue.poll();
	            subList.add(node);

	            //将非空左右子树加入queue
	            if(node.left != null){//如果队首的左结点不为空就把左结点入队
	                queue.offer(node.left);
	            }
	            if(node.right != null){//如果队首的右结点不为空就把右结点入队
	                queue.offer(node.right);
	            }
	        }
	        result.add(subList);//添加一层
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
