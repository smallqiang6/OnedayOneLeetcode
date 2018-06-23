package disjoint_set_union.longestConsecutive;

import java.util.HashMap;

/*
http://kickcode.iteye.com/blog/2264925
 */
/*
Longest Consecutive Sequence 
给定一个未排序的整型数组，找出最长的连续子序列。要求时间复杂度为O(n)。 
例如：给定nums[] = {100, 4, 200, 1, 3, 2} 
输出：4    最长连续子序列为（1，2，3，4） 

我们用哈希处理元素是否被访问过，
然后从第一个元素开始，
分别检查它两边的元素，
也就是对它进行加1和减1的操作，
检查哈希表中是否存在，记录最大的个数。
这就好像以节点构造了几棵树，
只要找到最大的那棵树就是结果了。

*/
public class Solution {

	public int longestConsecutive(int[] nums) {  
		  
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();  
        int max = 1;  
        if(nums == null || nums.length == 0) return 0;  
        for(int i : nums) hm.put(i, 0);  
  
        for(int i = 0; i < nums.length; i++) {  
            int count = 1;   
            int left = -1;   
            int right = 1;  
            if(hm.get(nums[i]) == 1) {  
                continue;  
            }  
            hm.put(nums[i], 1);  
            while(hm.containsKey(nums[i] + left)) {  
                hm.put(nums[i] + left, 1);  
                count ++;  
                left --;  
            }  
            while(hm.containsKey(nums[i] + right)) {  
                hm.put(nums[i] + right, 1);  
                count ++;  
                right ++;  
                }  
            max = Math.max(count, max);  
        }  
        return max;  
          
    }  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
