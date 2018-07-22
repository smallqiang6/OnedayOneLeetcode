package back_track.subsetsWithDup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/*
https://leetcode-cn.com/problems/subsets-ii/description/
*/
/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
	List<List<Integer>> res;

	public List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);
		res = new ArrayList<List<Integer>>();

		List<Integer> list = new ArrayList();
		backTrackDFS2(nums, 0, list);

		return res;

	}

	boolean isDistinct(List<Integer> list) {

		// 和res中的每一个比都不相同才可以 有一个相同就返回false

		for (List<Integer> l : res) {

			if (list.size() != l.size()) {
				continue;
			}
			for (int i = 0; i < list.size(); i++) {
				if (l.get(i) != list.get(i)) {
					break;
				}
				if(i == list.size()-1) {

					return false;
				}
			}

		}
		return true;

	}

	void backTrackDFS(int[] nums, int index, List<Integer> list) {

		if (index == nums.length) {
			// return
			if (isDistinct(list) == true) {
				res.add(new ArrayList<Integer>(list));
				//System.out.println("++"+list);
			}
			return;

		}

		backTrackDFS(nums, index + 1, list);
		list.add(nums[index]);
		backTrackDFS(nums, index + 1, list);
		list.remove(list.size() - 1);

	}

	//{a b c} = a{bc}  
	public void backTrackDFS2(int[] nums, int pos, List<Integer> temp) {
		res.add(new ArrayList<Integer>(temp));
		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1] && i != 0)
				continue;
			temp.add(nums[i]);
			backTrackDFS2(nums, pos + 1, temp);
			temp.remove(temp.size() - 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = { 1, 2, 2 };
		System.out.println(new Solution().subsetsWithDup(data));

	}

}
