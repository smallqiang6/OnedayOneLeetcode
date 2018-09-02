package test.week100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
https://leetcode-cn.com/contest/weekly-contest-100/problems/bitwise-ors-of-subarrays/
	898. 子数组按位或操作
	用户通过次数 14
	用户尝试次数 123
	通过次数 14
	提交次数 348
	题目难度 Medium
	我们有一个非负整数数组 A。

	对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。

	返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）

	 

	示例 1：

	输入：[0]
	输出：1
	解释：
	只有一个可能的结果 0 。
	示例 2：

	输入：[1,1,2]
	输出：3
	解释：
	可能的子数组为 [1]，[1]，[2]，[1, 1]，[1, 2]，[1, 1, 2]。
	产生的结果为 1，1，2，1，3，3 。
	有三个唯一值，所以答案是 3 。
	示例 3：

	输入：[1,2,4]
	输出：6
	解释：
	可能的结果是 1，2，3，4，6，以及 7 。
	 

	提示：

	1 <= A.length <= 50000
	0 <= A[i] <= 10^9*/

public class Solution3 {

	public int subarrayBitwiseORs(int[] A) {
		
		/*
		 * 一个元素时： 两个元素时：以前一个元素结尾的所有子数组 + 第二个元素单独 一般情况n：N-1的解集 + （N-1为结尾的所有子数组&N +
		 * N元素单独）等价于 N为结尾的所有子数组
		 * 
		 */
		// 以N元素结尾的所有子数组

		HashSet<Integer> total = new HashSet<>();
		HashSet<Integer> cur = new HashSet<>();
		for (int i : A) {
			HashSet<Integer> nc = new HashSet<>();
			nc.add(i);
			for (int j : cur)
				nc.add(i | j);
			for (int j : nc)
				total.add(j);
			cur = nc;
		}
		return total.size();

	}

	/*
	 * public int subarrayBitwiseORs(int[] A) { List<Integer> list = new
	 * LinkedList<Integer>(); dfs(A, 0, list);
	 * 
	 * return 0;
	 * 
	 * }
	 * 
	 * void dfs(int[] A, int index, List<Integer> list) { if (index == A.length) {
	 * // System.out.println(list); return; }
	 * 
	 * dfs(A, index + 1, list); list.add(A[index]); dfs(A, index + 1, list);
	 * list.remove(list.size() - 1);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 1, 2, 4 };
		System.out.println(new Solution3().subarrayBitwiseORs(test));
	}

}
