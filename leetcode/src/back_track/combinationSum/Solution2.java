package back_track.combinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * 
 * 
https://leetcode-cn.com/problems/combination-sum-ii/description/



示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class Solution2 {
	List<List<Integer>> res;
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		res = new LinkedList<List<Integer>>();
		List<Integer> tmp = new LinkedList<Integer>();
		// 先将数组排序避免重复搜素
		Arrays.sort(candidates);
		helper(candidates, target, 0, tmp);
		return res;
	}

	private void helper(int[] nums, int target, int index, List<Integer> tmp) {
		// 如果当前和已经大于目标，说明该路径错误
		if (target < 0) {
			return;
			// 如果当前和等于目标，说明这是一条正确路径，记录该路径
		} else if (target == 0) {
			List<Integer> oneComb = new LinkedList<Integer>(tmp);
			res.add(oneComb);
			// 否则，对剩余所有可能性进行深度优先搜索
			
		} else {
			// 选取之后的每个数字都是一种可能性
			for (int i = index; i < nums.length; i++) {
				// 典型的先加入元素，再进行搜索，递归回来再移出元素的DFS解法
				if(i > index && nums[i] == nums[i-1])
				{
					continue;
				}
				tmp.add(nums[i]);
				helper(nums, target - nums[i], i+1, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]  = {10,1,2,7,6,1,5};
		List<List<Integer>> res = new Solution2().combinationSum2(data, 8);
		for(List l : res)
		{
			System.out.println(l);
		}
		System.out.println("--------------------");
		int data2[]  = {2,5,2,1,2};
		List<List<Integer>> res2 = new Solution2().combinationSum2(data2, 5);
		for(List l : res2)
		{
			System.out.println(l);
		}
	}

}
