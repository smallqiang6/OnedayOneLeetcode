package greedy.monotoneIncreasingDigits;

/*
 * https://www.cnblogs.com/grandyang/p/8068326.html
 */

/*
我们可以发现规律:
要找到从后往前遍历的最后一个值升高的位置，让前一位减1，并把当前位以及后面的所有位都变成9，就可以得到最大的单调递增数啦。
 */

public class Solution {
	public int monotoneIncreasingDigits(int N) {
		String string = Integer.toString(N);
		char str [] = string.toCharArray();
        int n = str.length, j = n;
        for (int i = n - 1; i > 0; --i) {
            if (str[i] >= str[i-1]) 
            	continue;
            str[i-1]--;
            j = i;
        }        
        for (int i = j; i < n; ++i) {
            str[i] = '9';
        }
        return Integer.parseInt(new String(str));
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
 * 示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299
 */
		if( 299 == new Solution().monotoneIncreasingDigits(332))
		{
			System.out.println("testcase1 pass");
		}

	}

}
