package test.week93;
/*
https://leetcode-cn.com/contest/weekly-contest-93/problems/binary-gap/
	*/
public class Solution1 {
/*	
	输入：22
	输出：2
	解释：
	22 的二进制是 0b10110 。
	在 22 的二进制表示中，有三个 1，组成两对连续的 1 。
	第一对连续的 1 中，两个 1 之间的距离为 2 。
	第二对连续的 1 中，两个 1 之间的距离为 1 。
	答案取两个距离之中最大的，也就是 2 。
	*/
	public int binaryGap(int N) {
		int res = 0;
		int count = 0;
		boolean flagBeginCnt = false;
		while(N != 0) {
			if(N == (N >> 1) << 1) {//0
				if(flagBeginCnt) {
					count++;
				}
	        	
	        }else {//1
	        	if(flagBeginCnt) {
	        		count++;
	        		res = Math.max(res, count);
	        		count = 0;
	        		
	        	}else {
	        		flagBeginCnt = true;
	        		count = 0;
	        	}
	        }
			N = (N >> 1);
		}
		return res;
	        
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(new Solution1().binaryGap(22));
	}

}
