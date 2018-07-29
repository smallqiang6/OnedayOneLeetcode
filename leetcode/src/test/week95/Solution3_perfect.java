package test.week95;

public class Solution3_perfect {
	public int nthMagicalNumber(int K, int A, int B) {
		long low = 0, high = 2000000000000000000L;
		int G = A * B / gcd(A, B);
		while (high - low > 1) {
			long h = high + low >> 1;
			long num = h / A + h / B - h / G;
			if (num >= K) {
				high = h;
			} else {
				low = h;
			}
		}
		return (int) (high % 1000000007);
	}

	public int gcd(int a, int b) {
		while (b > 0) {
			int c = a;
			a = b;
			b = c % b;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution3().nthMagicalNumber(1, 2, 3));
		System.out.println(new Solution3().nthMagicalNumber(4, 2, 3));
		System.out.println(new Solution3().nthMagicalNumber(3, 6, 4));
		System.out.println(new Solution3().nthMagicalNumber(5, 2, 4));  // 2 4 6 8 10
	
		System.out.println(new Solution3().nthMagicalNumber(10, 10, 8));//8 10 16 20 24 30 32 40 48 50
		System.out.println(new Solution3().nthMagicalNumber(1000000000, 40000, 40000));
	}

}
