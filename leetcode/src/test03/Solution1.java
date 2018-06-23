package test03;
/*
https://leetcode-cn.com/contest/weekly-contest-89/problems/peak-index-in-a-mountain-array/
 */

/*
示例 1：

输入：[0,1,0]
输出：1
示例 2：

输入：[0,2,1,0]
输出：1
 */
public class Solution1 {

	
	public int peakIndexInMountainArray(int[] A) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < A.length;i++ )
		{
			if(A[i] < max)
			{
				//System.out.println("ret = "+i);
				return i-1;
			}else {
				max = A[i];
			}
		}
		return -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {0,1,0};
		if(1 == new Solution1().peakIndexInMountainArray(data))
		{
			System.out.println("testcase pas");
		}
		
	}

}
