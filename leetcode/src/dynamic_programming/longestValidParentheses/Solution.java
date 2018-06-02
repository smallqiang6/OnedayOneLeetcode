package dynamic_programming.longestValidParentheses;
/*
 * reference:
 * https://blog.csdn.net/zzuzy/article/details/51223988
 */
public class Solution {

	public int longestValidParentheses(String s) {
		//int maxn = 10000;
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
		      
    }
	
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data1 = "(()";
		if(2 == new Solution().longestValidParentheses(data1))
		{
			System.out.println("testcase1 pass here");
		}
		
		String data2 = "(()";
		if(4 == new Solution().longestValidParentheses(data2))
		{
			System.out.println("testcase2 pass here");
		}

	}

}
