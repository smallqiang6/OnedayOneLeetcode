package test.week93;
/*
https://leetcode-cn.com/contest/weekly-contest-93/problems/binary-gap/
	*/
public class Solution1 {
/*	
	���룺22
	�����2
	���ͣ�
	22 �Ķ������� 0b10110 ��
	�� 22 �Ķ����Ʊ�ʾ�У������� 1��������������� 1 ��
	��һ�������� 1 �У����� 1 ֮��ľ���Ϊ 2 ��
	�ڶ��������� 1 �У����� 1 ֮��ľ���Ϊ 1 ��
	��ȡ��������֮�����ģ�Ҳ���� 2 ��
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
