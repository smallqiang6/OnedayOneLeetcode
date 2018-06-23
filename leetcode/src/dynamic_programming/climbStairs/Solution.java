package dynamic_programming.climbStairs;
/*
https://leetcode-cn.com/problems/climbing-stairs/description/
 */


public class Solution {

	int record [] = null; 
	public int climbStairs(int n) {//�ܹ��ж������߷�
		if(record == null)//first time init
		{
			record = new int[n+1];
			for(int i = 0; i < n+1; i++)
			{
				record[i] = 0;
			}
		}

		//�Ѿ��ǹ��ʵģ�����ģ�ֱ�ӷ���
		if(record[n] != 0)
			return record[n];
		
		if(n == 1)//ֻ��һ��
		{
			if(record[1] == 0)
			{
				record[1] = 1;
			}

		}
		
		if(n == 2)//ֻ������
		{
			if(record[2] == 0)
			{
				record[2] = 2;
			}

		}
		if(n > 2)
		{
			//int n2 = climbStairs(n - 2);
			//int n1 = climbStairs(n - 1);
			record[n] = climbStairs(n - 2) + climbStairs(n - 1);

		}

		return record[n];
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(3 == new Solution().climbStairs(3))
		{
			System.out.println("testcase pass");
		}
	}

}
