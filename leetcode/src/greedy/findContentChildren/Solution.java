package greedy.findContentChildren;

import java.util.Arrays;

/*
 * 
 * 
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 
 * 
示例 1:

输入: [1,2,3], [1,1]

输出: 1

解释: 
你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
所以你应该输出1。
示例 2:

输入: [1,2], [1,2,3]

输出: 2

解释: 
你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
你拥有的饼干数量和尺寸都足以让所有孩子满足。
所以你应该输出2.
 */
public class Solution {

	public int findContentChildren(int[] g, int[] s) {
		
		int res = 0;
		int index_g = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] >= g[index_g])
			{
				res++;
				index_g++;
				
				if(index_g >= g.length)
					break;
			}
		}
		
		return res;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
