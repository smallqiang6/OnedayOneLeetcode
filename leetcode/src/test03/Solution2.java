package test03;

import java.util.Arrays;
import java.util.Dictionary;

/*
https://leetcode-cn.com/contest/weekly-contest-89/problems/car-fleet/
 */
public class Solution2 {


	public int carFleet(int target, int[] position, int[] speed) {
		if (position == null || speed == null) {
			return 0;
		}
		if (position.length == 0) {
			return 0;
		}
		// �Ȳ������ظ�λ�õ�������ͳ������յ�����
		// ������
		bubbleSort(position, speed);

		return convergence(target, position, speed, position.length - 1);

	}
	

	public int convergence(int target, int[] position, int[] speed, int i) {
		int j = i - 1;
		if (i == 0) {
			return 1;
		}

		if (i == 1) {
			// ֱ�ӷ���
			double ti = (double) (target - position[i]) / speed[i];
			double tj = (double) (target - position[j]) / speed[j];
			if (ti >= tj)// �϶��ᷢ����������
			{
				// i j����
				return 1;
			} else {// ���ܸ���
				return 2;
			}
		}

		// ����J��֮ǰ�ĳ��Ѿ��������ˡ��ܹ���N���Σ����ӣ�����
		double ti = (double) (target - position[i]) / speed[i];
		double tj = (double) (target - position[j]) / speed[j];
		if (ti >= tj)// �϶��ᷢ����������
		{
			// i j����
			// ti��ʱ��ᷴѹ
			position[j] = position[i];
			speed[j] = speed[i];
			return convergence(target, position, speed, j);
		} else {// ���ܸ���
			return convergence(target, position, speed, j) + 1;
		}

	}

	public void bubbleSort(int[] position, int[] speed) {
		int t = 0;
		for (int i = 0; i < position.length - 1; i++)
			for (int j = 0; j < position.length - 1 - i; j++)
				if (position[j] > position[j + 1]) {
					t = position[j];
					position[j] = position[j + 1];
					position[j + 1] = t;
					// speedҲͬ����
					t = speed[j];
					speed[j] = speed[j + 1];
					speed[j + 1] = t;
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ʾ����

		���룺target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
		�����3
		���ͣ�
		�� 10 �� 8 ��ʼ�ĳ������һ�����ӣ������� 12 ��������
		�� 0 ����ʼ�ĳ��޷�׷�����������������Լ�����һ�����ӡ�
		�� 5 �� 3 ��ʼ�ĳ������һ�����ӣ������� 6 ��������
		��ע�⣬�ڵ���Ŀ�ĵ�֮ǰû����������������Щ���ӣ����Դ��� 3��
			 */
		int target = 12;

		
		int speed[] = {2,4,1,1,3};
		int position[] = {10,8,0,5,3};
		int position2[] = {};
		int speed2[] = {};
		
		int position3[] = {3};
		int speed3[] = {3};
		
		if(3 == new Solution2().carFleet(target,position,speed))
		{
			System.out.println("pass1");
		}
		//new Solution2().carFleet(10,position2,speed2);
		//if(1 == new Solution2().carFleet(10,position3,speed3))
		//{
			//System.out.println("pass3");
		//}
		
		int position4[] = {0,4,2};
		int speed4[] = {2,1,3};
		
		if(1 == new Solution2().carFleet(10,position4,speed4))
		{
			System.out.println("pass4");
		}

	}

}
