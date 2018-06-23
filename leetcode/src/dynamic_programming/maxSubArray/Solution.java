package dynamic_programming.maxSubArray;


//动态规划，照葫芦画瓢
//int maxn = 10000;
/*
		int len = s.length();
		//char s[] = new char[10000];
		int dp[] = new int[10000];
		int Max = 0;
		//init
	    for(int i = 0; i < len; i++) 
	        dp[i] = 0;
	    for(int i = len-2; i >= 0; i--) {
	        if(s.charAt(i) == '(') {
	            int j = i + 1 + dp[i+1];//1
	            if(j < len && s.charAt(j) == ')') {
	                dp[i] += dp[i+1] + 2;//2
	                if(j+1 < len)
	                    dp[i] += dp[j+1];//3
	            }
	            if(Max < dp[i]) 
	            	Max = dp[i];
	        }
	    }
	    return Max;
*/
public class Solution {

	public int maxSubArray(int[] nums) {
		int len = nums.length;
		int dp[] = new int[nums.length];// current △
		int Max = Integer.MIN_VALUE;

		dp[0] = nums[0];
		Max = dp[0];

		if (len == 1)
			return Max;

		for (int i = 1; i < len; i++) {
			if (dp[i - 1] < 0)
				dp[i] = nums[i];
			else
				dp[i] = dp[i - 1] + nums[i];

			if (Max < dp[i])
				Max = dp[i];
		}
		return Max;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
 输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

[-2,-1]
预期：
-1

[-1,-2]
预期：
-1
		 */

		int data[] = {-2,1,-3,4,-1,2,1,-5,4};
		if(6 == new Solution().maxSubArray(data))
		{
			System.out.println("tesecase pass");
		}
		
		int data2[] = {-2,-3,-1};
		if(-1 == new Solution().maxSubArray(data2))
		{
			System.out.println("tesecase2 pass");
		}
		
		int data3[] = {-1,-2};
		if(-1 == new Solution().maxSubArray(data2))
		{
			System.out.println("tesecase3 pass");
		}

	}

}
