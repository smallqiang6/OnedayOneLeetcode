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
		// 先不考虑重复位置的情况，和出发在终点的情况
		// 先排序
		bubbleSort(position, speed);

		return convergence(target, position, speed, position.length - 1);

	}
	

	public int convergence(int target, int[] position, int[] speed, int i) {
		int j = i - 1;
		if (i == 0) {
			return 1;
		}

		if (i == 1) {
			// 直接返回
			double ti = (double) (target - position[i]) / speed[i];
			double tj = (double) (target - position[j]) / speed[j];
			if (ti >= tj)// 肯定会发生反超相遇
			{
				// i j收敛
				return 1;
			} else {// 各跑各的
				return 2;
			}
		}

		// 假设J车之前的车已经收敛好了。总共是N批次（车队）到达
		double ti = (double) (target - position[i]) / speed[i];
		double tj = (double) (target - position[j]) / speed[j];
		if (ti >= tj)// 肯定会发生反超相遇
		{
			// i j收敛
			// ti这时候会反压
			position[j] = position[i];
			speed[j] = speed[i];
			return convergence(target, position, speed, j);
		} else {// 各跑各的
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
					// speed也同步排
					t = speed[j];
					speed[j] = speed[j + 1];
					speed[j + 1] = t;
				}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		示例：

		输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
		输出：3
		解释：
		从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
		从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
		从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
		请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
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
