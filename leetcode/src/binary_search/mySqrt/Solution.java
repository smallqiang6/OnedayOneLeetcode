package binary_search.mySqrt;
/*
https://leetcode-cn.com/problems/sqrtx/description/
 */
public class Solution {
	
	public int mySqrt(int x) {
		int low = 0, high = x;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			long square = (long) mid * (long) mid;
			long square1 = (long) (mid + 1) * (long) (mid + 1);
			long square2 = (long) (mid - 1) * (long) (mid - 1);

			if (square == x)
				return mid;
			if (square < x && square1 > x)
				return mid;
			if (square > x && square2 < x)
				return mid - 1;
			if (square < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().mySqrt(8);
	}

}
