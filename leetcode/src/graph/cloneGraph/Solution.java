package graph.cloneGraph;

import java.util.HashMap;
import java.util.Map;

import dlx_util.UndirectedGraphNode;

/*
https://leetcode-cn.com/problems/clone-graph/description/
*/
/*
题意：

克隆一个无向图。无向图中每一个节点包含一个标签和一个邻居节点集。

OJ的无向图序列化为：

每个节点都有唯一的标签。

使用#号作为每一个节点的分隔符，使用，号作为标签和每一个邻居节点的分隔符。

例如，序列化的无向图为{0, 1,2#1,2#2, 2}。

这个图总共有三个节点，并且包含由#号分隔开来的三个部分。

1、第一个节点被标记为0，连接节点0跟节点1和节点2；

2、第二个节点被标记为1，连接节点1跟节点2；

3、第三个节点被标记为2，连接节点2到其本身，因此形成一个自循环。

可视化的无向图结构如上图所示


思路一：

这道题目的难点在于如何处理每个节点的neighbors，由于在深度拷贝每一个节点后，还要将其所有neighbors放到一个vector中，
而如何避免重复拷贝呢？
这道题好就好在所有节点值不同，所以我们可以使用哈希表来对应节点值和新生成的节点。
对于图的遍历的两大基本方法是深度优先搜索DFS和广度优先搜索BFS
这里我们使用深度优先搜索DFS来解答此题。
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
