package bit.singleNumber;
/*
https://leetcode-cn.com/problems/single-number/description/
*/
public class Solution {

	
	public int singleNumber(int[] nums) {
		int res = 0;
        for(int i:nums) {
        	res ^= i;
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {4,1,2,1,2};
		System.out.println(new Solution().singleNumber(data));
	}

}
