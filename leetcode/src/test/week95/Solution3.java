package test.week95;


/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/nth-magical-number/
	
	878. �� N ����������
	�û�ͨ������ 0
	�û����Դ��� 0
	ͨ������ 0
	�ύ���� 0
	��Ŀ�Ѷ� Hard
	������������Ա� A �� B ��������ô��������ġ�

	���ص� N ���������֡����ڴ𰸿��ܷǳ��󣬷�����ģ 10^9 + 7 �Ľ����

	 

	ʾ�� 1��

	���룺N = 1, A = 2, B = 3
	�����2
	ʾ�� 2��

	���룺N = 4, A = 2, B = 3
	�����6
	ʾ�� 3��

	���룺N = 5, A = 2, B = 4
	�����10
	ʾ�� 4��

	���룺N = 3, A = 6, B = 4
	�����8
	 

	��ʾ��

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
