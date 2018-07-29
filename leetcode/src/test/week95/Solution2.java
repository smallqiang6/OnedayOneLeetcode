package test.week95;

import java.util.Collections;
import java.util.Stack;


/*
https://leetcode-cn.com/contest/weekly-contest-95/problems/stone-game/
	877. ʯ����Ϸ
	�û�ͨ������ 0
	�û����Դ��� 0
	ͨ������ 0
	�ύ���� 0
	��Ŀ�Ѷ� Medium
	������˹�����ü���ʯ��������Ϸ��ż����ʯ���ų�һ�У�ÿ�Ѷ�����������ʯ�� piles[i] ��

	��Ϸ��˭���е�ʯ�����������ʤ����ʯ�ӵ�����������������û��ƽ�֡�

	������˹�����������У�������˹�ȿ�ʼ�� ÿ�غϣ���Ҵ��еĿ�ʼ�������ȡ������ʯͷ�� �������һֱ������û�и����ʯ�Ӷ�Ϊֹ����ʱ����ʯ��������һ�ʤ��

	����������˹������ӳ����ˮƽ����������˹Ӯ�ñ���ʱ���� true ������Ӯ�ñ���ʱ���� false ��

	 

	ʾ����

	���룺[5,3,4,5]
	�����true
	���ͣ�
	������˹�ȿ�ʼ��ֻ����ǰ 5 �Ż�� 5 ��ʯ�� ��
	������ȡ��ǰ 5 �ţ���һ�оͱ���� [3,4,5] ��
	���������ǰ 3 �ţ���ôʣ�µ��� [4,5]��������˹���ߺ� 5 ��Ӯ�� 10 �֡�
	��������ߺ� 5 �ţ���ôʣ�µ��� [3,4]��������˹���ߺ� 4 ��Ӯ�� 9 �֡�
	�������ȡǰ 5 ��ʯ�Ӷ�������˹��˵��һ��ʤ���ľٶ����������Ƿ��� true ��
	 

	��ʾ��

	2 <= piles.length <= 500
	piles.length ��ż����
	1 <= piles[i] <= 500
	sum(piles) ��������*/
	
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
	public boolean back_track(int[] piles,int start,int end,int moveCnt) {//�Ƿ�always win
		
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
