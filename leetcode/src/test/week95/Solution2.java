package test.week95;

import java.util.Collections;
import java.util.Stack;


/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/stone-game/
	877. 石子游戏
	用户通过次数 0
	用户尝试次数 0
	通过次数 0
	提交次数 0
	题目难度 Medium
	亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

	游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。

	亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。

	假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。

	 

	示例：

	输入：[5,3,4,5]
	输出：true
	解释：
	亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
	假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
	如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
	如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
	这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
	 

	提示：

	2 <= piles.length <= 500
	piles.length 是偶数。
	1 <= piles[i] <= 500
	sum(piles) 是奇数。*/
	
public class Solution2 {

	Stack<Integer> alex = new Stack<Integer>();
	Stack<Integer> li = new Stack<Integer>();
	int sumA = 0;
	int sumL = 0;
	public boolean stoneGame(int[] piles) {

		return back_track(piles, 0, piles.length-1,0);
        
    }
	
	public boolean compare() {
		int sumA = 0;
		int sumL = 0;
		for(int i:alex) {
			//System.out.println("A:"+i);
			sumA += i;
		}
		for(int i:li) {
			//System.out.println("B:"+i);
			sumL += i;
		}
		if(sumA > sumL) {
			return true;
		}else {
			return false;
		}
		
	}
	public boolean back_track(int[] piles,int start,int end,int moveCnt) {//是否always win
		
		if(moveCnt >= piles.length) {
			return sumA > sumL ? true:false;
		}
		boolean res1 ,res2;
		
		if(moveCnt%2 == 0) {//alex
			sumA += (piles[start]);
			res1 = back_track(piles, start+1, end,moveCnt+1);
			sumA -=  (piles[start]);
			if(res1) {
				return true;
			}

			sumA +=(piles[end]);
			res2 = back_track(piles, start, end-1,moveCnt+1);
			sumA -=(piles[end]);
			if(res2) {
				return true;
			}
			
			
		}else {
			sumL += (piles[start]);
			res1 = back_track(piles, start+1, end,moveCnt+1);
			sumL -= (piles[start]);
			if(res1) {
				return true;
			}
			
			sumL += (piles[end]);
			res2 = back_track(piles, start, end-1,moveCnt+1);
			sumL -= (piles[start]);
			if(res2) {
				return true;
			}
		}
		return false;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {5,3,4,5};
		System.out.println(new Solution2().stoneGame(data));
	}

}
