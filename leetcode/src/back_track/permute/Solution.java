package back_track.permute;
/*
 * https://leetcode-cn.com/problems/permutations/description/
 */
/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
简单地说：就是第一个数分别以后面的数进行交换

E．g：E = （a , b , c），则 prem（E）= a.perm（b,c）+ b.perm（a,c）+ c.perm（a,b）

然后a.perm（b,c）= ab.perm（c）+ ac.perm（b）= abc + acb.依次递归进行
*/

public class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> permute(int[] nums) {
		res = new LinkedList<List<Integer>>();

		// 先将数组排序避免重复搜素
		Arrays.sort(nums);
		helper(nums, 0);
		return res;
    }
	private void helper(int[] nums, int index) {
		if(index == nums.length -1)  
	    {  
			ArrayList<Integer> in = new ArrayList<Integer>();  
		    for(int i = 0;i<nums.length;i++)  
		    {  
		        in.add(nums[i]);  
		    }  
		    res.add(in);  
		    return ;   
	    }  
	    else  
	    {  
	        for(int i = index;i<=nums.length -1;i++)//第i个数分别与它后面的数字交换就能得到新的排列  
	        {  
	            swap(nums, i, index);  
	            helper(nums, index+1);//表示，若sur和sum相邻时输出  
	            swap(nums, i, index);  
	        }  
	    }  
	}
	public void swap(int[] num ,int i , int j)  
	{  
	    int temp = num[i];  
	    num[i] = num[j];  
	    num[j] = temp;  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]  = {2,3,5};
		List<List<Integer>> res = new Solution().permute(data);
		for(List l : res)
		{
			System.out.println(l);
		}
	}

}
