package test.week95;


/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/nth-magical-number/
	
	878. 第 N 个神奇数字
	用户通过次数 0
	用户尝试次数 0
	通过次数 0
	提交次数 0
	题目难度 Hard
	如果正整数可以被 A 或 B 整除，那么它是神奇的。

	返回第 N 个神奇数字。由于答案可能非常大，返回它模 10^9 + 7 的结果。

	 

	示例 1：

	输入：N = 1, A = 2, B = 3
	输出：2
	示例 2：

	输入：N = 4, A = 2, B = 3
	输出：6
	示例 3：

	输入：N = 5, A = 2, B = 4
	输出：10
	示例 4：

	输入：N = 3, A = 6, B = 4
	输出：8
	 

	提示：

	1 <= N <= 10^9
	2 <= A <= 40000
	2 <= B <= 40000	

*/
public class Solution3 {

	int gcd(int a,int b) {
		int temp;
		if(a < b){
	        temp = a;
	        a = b;
	        b = temp;
	        
	    }
	    while(a%b != 0){
	            temp = a%b;
	            a = b;
	            b = temp;
	    }
	    return b;
	}
	int gcd = 0;
	public int nthMagicalNumber(int N, int A, int B) {
		int m = Math.min(A, B);
		long max = 2000000000000000000L;
		int min = N;
		gcd = gcd(A,B);
		System.out.println("GCD:" + gcd);

		return binary_search(min, max, A, B,N);
	}

	public int binary_search(long min, long max, int A, int B, int N) {//
		long l = min;
		long h = max;

		while (l <= h) {
			long m = l + (h - l) / 2;

			int num = cal(m, A, B);
			//System.out.println(num);
			if (num < N) {
				l = m + 1;
			} else {
				h = m - 1;
			}
			
			
		}
		return (int)(l%1000000007);

	}

	int cal(long m, long A, long B) {

		return (int) (m / A + m / B - (m * gcd / (A * B)));

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(new Solution3().nthMagicalNumber(1, 2, 3));
		System.out.println(new Solution3().nthMagicalNumber(4, 2, 3));
		System.out.println(new Solution3().nthMagicalNumber(3, 6, 4));
		System.out.println(new Solution3().nthMagicalNumber(5, 2, 4));  // 2 4 6 8 10
	
		System.out.println(new Solution3().nthMagicalNumber(10, 10, 8));//8 10 16 20 24 30 32 40 48 50
*/		System.out.println(new Solution3().nthMagicalNumber(1000000000, 40000, 40000));
		
	}

}
