package graph.cloneGraph;

import java.util.HashMap;
import java.util.Map;

import dlx_util.UndirectedGraphNode;

/*
https://leetcode-cn.com/problems/clone-graph/description/
*/
/*
���⣺

��¡һ������ͼ������ͼ��ÿһ���ڵ����һ����ǩ��һ���ھӽڵ㼯��

OJ������ͼ���л�Ϊ��

ÿ���ڵ㶼��Ψһ�ı�ǩ��

ʹ��#����Ϊÿһ���ڵ�ķָ�����ʹ�ã�����Ϊ��ǩ��ÿһ���ھӽڵ�ķָ�����

���磬���л�������ͼΪ{0, 1,2#1,2#2, 2}��

���ͼ�ܹ��������ڵ㣬���Ұ�����#�ŷָ��������������֡�

1����һ���ڵ㱻���Ϊ0�����ӽڵ�0���ڵ�1�ͽڵ�2��

2���ڶ����ڵ㱻���Ϊ1�����ӽڵ�1���ڵ�2��

3���������ڵ㱻���Ϊ2�����ӽڵ�2���䱾������γ�һ����ѭ����

���ӻ�������ͼ�ṹ����ͼ��ʾ


˼·һ��

�����Ŀ���ѵ�������δ���ÿ���ڵ��neighbors����������ȿ���ÿһ���ڵ�󣬻�Ҫ��������neighbors�ŵ�һ��vector�У�
����α����ظ������أ�
�����þͺ������нڵ�ֵ��ͬ���������ǿ���ʹ�ù�ϣ������Ӧ�ڵ�ֵ�������ɵĽڵ㡣
����ͼ�ı�����������������������������DFS�͹����������BFS
��������ʹ�������������DFS�������⡣
*/
public class Solution {

	private Map<Integer, UndirectedGraphNode> map = new HashMap<>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode cloned = map.get(node.label);
		if (cloned != null)
			return cloned;
		cloned = new UndirectedGraphNode(node.label);
		map.put(cloned.label, cloned);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			cloned.neighbors.add(cloneGraph(neighbor));
		}
		return cloned;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
