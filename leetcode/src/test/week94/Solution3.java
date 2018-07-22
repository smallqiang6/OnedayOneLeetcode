package test.week94;

import java.util.Arrays;


/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/koko-eating-bananas/
	
	875. 爱吃香蕉的珂珂
	用户通过次数 0
	用户尝试次数 0
	通过次数 0
	提交次数 0
	题目难度 Medium
	珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。

	珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  

	珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

	返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。

	 

	示例 1：

	输入: piles = [3,6,7,11], H = 8
	输出: 4
	示例 2：

	输入: piles = [30,11,23,4,20], H = 5
	输出: 30
	示例 3：

	输入: piles = [30,11,23,4,20], H = 6
	输出: 23
	 

	提示：

	1 <= piles.length <= 10^4
	piles.length <= H <= 10^9
	1 <= piles[i] <= 10^9
	*/
	

public class Solution3 {

	public int minEatingSpeed(int[] piles, int H) {
		int max = 0;
		for(int i: piles) {
			max = Math.max(max, i);
		}
        int min = 0;
        return binarySearch(piles,H,min,max);
    }
	
	//条件是H小时内吃完  ，每小时能吃的数量从最小值low和最大值high中间取值
	//二分查找寻找第一个>=n的数的下标  == 最后一个小于目标值
	//findFirstGE
	
	//二分查找寻找最后一个<=的数的下标 == 第一个大于目标值
	//findLastLE
	public int binarySearch(int[] piles,int H,int low,int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(mid == 0)
				return 1;
			//求的是最小速度
			//等价于满足<=H的最大的actualTime
			int actualTime = 0;
			for(int pile:piles) {
				if(pile % mid == 0) {
					actualTime += (pile/mid);
				}else {
					actualTime += (pile/mid + 1);
				}
			}
			//这里实际条件是>= 对于low high来说
			if (actualTime <= H)//实际花的时间小于H小时 ， 每小时吃的熟练还可以再小一点    实际花的时间大于H小时 ， 每小时吃的数量还可以再多一点
				high = mid - 1;
			else//对于low来说这里是<
				low = mid + 1;
		}
//return永远是-1的那个   要加头加尾 start -1   end + 1
		return high+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles1 = {3,6,7,11};
		int[] piles2 = {30,11,23,4,20};
		int[] piles3 = {30,11,23,4,20};
		System.out.println(new Solution3().minEatingSpeed(piles1, 8));
		System.out.println(new Solution3().minEatingSpeed(piles2, 5));
		System.out.println(new Solution3().minEatingSpeed(piles2, 6));
	}

}
