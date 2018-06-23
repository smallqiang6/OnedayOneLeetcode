package back_track.combinationSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * 
 * 
 * 
https://leetcode-cn.com/problems/combination-sum-ii/description/



ʾ�� 1:

����: candidates = [10,1,2,7,6,1,5], target = 8,
����⼯Ϊ:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
ʾ�� 2:

����: candidates = [2,5,2,1,2], target = 5,
����⼯Ϊ:
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
		// �Ƚ�������������ظ�����
		Arrays.sort(candidates);
		helper(candidates, target, 0, tmp);
		return res;
	}

	private void helper(int[] nums, int target, int index, List<Integer> tmp) {
		// �����ǰ���Ѿ�����Ŀ�꣬˵����·������
		if (target < 0) {
			return;
			// �����ǰ�͵���Ŀ�꣬˵������һ����ȷ·������¼��·��
		} else if (target == 0) {
			List<Integer> oneComb = new LinkedList<Integer>(tmp);
			res.add(oneComb);
			// ���򣬶�ʣ�����п����Խ��������������
			
		} else {
			// ѡȡ֮���ÿ�����ֶ���һ�ֿ�����
			for (int i = index; i < nums.length; i++) {
				// ���͵��ȼ���Ԫ�أ��ٽ����������ݹ�������Ƴ�Ԫ�ص�DFS�ⷨ
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
