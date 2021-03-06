package back_track.getPermutation;

import java.util.ArrayList;
import java.util.List;

/*
 * 
https://leetcode-cn.com/problems/permutation-sequence/description/
 */

//  数学规律法：https://www.cnblogs.com/ariel-dreamland/p/9149577.html
//  字典序下一个排列法：https://blog.csdn.net/guoziqing506/article/details/51787763
	
public class Solution {

	
	public String getPermutation(int n, int k) {
		List<Character> res =new ArrayList<>();
		List<Character> num = new ArrayList<>();

		for(char c: "123456789".toCharArray())
		{
			num.add(c);
		}
		int f[] = new int[n];
		f[0]  = 1;
		for (int i = 1; i < n; ++i) 
			f[i] = f[i - 1] * i;
		
		--k;
		for (int i = n; i >= 1; --i) {

			int j = k / f[i - 1];
			k %= f[i - 1];
			res.add(num.get(j));
			num.remove(num.get(j));
		}
		StringBuilder sb = new StringBuilder(res.size());
		for (char c : res)
		    sb.append(c);

		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().getPermutation(4, 17));
	}

}
