package hash.twoSum;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode-cn.com/problems/two-sum/description/
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {  
        int[] result = new int[2];  
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();  
        for (int i = 0; i < nums.length; i++)  
            map.put(nums[i],i);  
  
        for (int i = 0; i < nums.length; i++) {  
            int v = target - nums[i];  
            if (map.containsKey(v) && i != map.get(v)){  
                result[0] = i;  
                result[1] = map.get(v);  
                return result;  
            }  
        }  
        return result;  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
