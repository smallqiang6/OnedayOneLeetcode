package test;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode-cn.com/contest/weekly-contest-87/problems/hand-of-straights/
 * 爱丽丝有一手（hand）由整数数组给定的牌。 

现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。

如果她可以完成分组就返回 true，否则返回 false。
 */
//秒杀：使用W筛子
public class Solution3 {

	
	public boolean isNStraightHand(int[] hand, int W) {
		
		LinkedList<Integer> filter [] = (LinkedList<Integer>[])new  LinkedList<?>[W];
		for(int i = 0 ; i < W; i++)
		{
			filter[i] = new LinkedList<>();
		}
		for(int i : hand)
		{
			filter[i%W].add(i);
		}
		//数量上首先要匹配
		for(int i = 0 ; i < W; i++)
		{
			if(filter[i].size() != filter[0].size())
			{
				//System.out.println("size no equal");
				return false;
			}
		}
		
		for(int i = 0 ; i < W; i++)
		{
			Collections.sort(filter[i]);
		}
		
		int loop = filter[0].size();
		int row_max = 0, row_min = 0;	
		int temp = 0;
		//
		for(int i = 0; i < loop ; i++)
		{
			//System.out.println("loop i = "+i);
			row_max = Integer.MIN_VALUE;
			row_min = Integer.MAX_VALUE;
			for(int j = 0; j < W; j++)
			{
				temp = filter[j].removeFirst().intValue();
				//System.out.println("temp = "+temp);
				row_max = Math.max(temp, row_max);
				row_min = Math.min(temp, row_min);
			}
			//System.out.println("max = "+row_max+" min = "+row_min);
			if(row_max - row_min > W - 1)
			{
				//System.out.println("value");
				return false;
			}
		}
		
		return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {1,2,3,6,2,3,4,7,8};
		if(true == new Solution3().isNStraightHand(data, 3))
		{
			System.out.println("testcase1 pass");
		}
		int data2[] = {1,2,3,4,5};
		if(false == new Solution3().isNStraightHand(data2, 4))
		{
			System.out.println("testcase2 pass");
		}

	}

}
