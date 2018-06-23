package binary_search.searchRange;
/*
https://leetcode-cn.com/problems/search-for-a-range/description/
 */

/*

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */

//照葫芦画瓢
public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int [] ret = new int[2];
		
		int n = nums.length;  
        
        int l = 0, h = n - 1;  
        while (l <= h ) { 
            int m = l + (h - l) / 2;  
        	//System.out.println("l="+l+";h="+l+";m="+m);            
            if (nums[m] < target)  
                l = m + 1;  
            else if(nums[m] > target)   
                h = m - 1;  
            else {
            	l = m;
            	while(nums[l] == target && l > 0)
            	{
            		l--;
            	}
            	ret[0] = nums[l] != target ? l+1 : 0;
            	h = m;
            	while(nums[h] == target && h < n - 1)
            	{
            		h++;
            	}
            	ret[1] = nums[h] != target ? h-1 : n-1;
            	break;
            }
        } 
        if(l > h)
        {
        	ret[0] = -1;
        	ret[1] = -1;
        }

 //System.out.println("ret0="+ret[0]+";ret1="+ret[1]);

        return ret;  //最后返回的是 l 位置的字符  
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data []  = {5,7,7,8,8,8,8,10};
		new Solution().searchRange(data, 9);

	}

}
