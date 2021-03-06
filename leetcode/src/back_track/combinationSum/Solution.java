package back_track.combinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
深搜来做。
1、注意减支：如果得到的当前和sum大于target，直接返回，不再往下搜索。

2、注意去重，也起到减支的作用：一开始就将输入数组排好序，每一层往下搜索的时候，只从这个数的位置往后进行搜索，因为它的前面数，肯定已经被处理过了。

*/
public class Solution {

	List<List<Integer>> res;

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

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
				tmp.add(nums[i]);
				helper(nums, target - nums[i], i, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]  = {2,3,5};
		List<List<Integer>> res = new Solution().combinationSum(data, 8);
		for(List l : res)
		{
			System.out.println(l);
		}
	}

}
