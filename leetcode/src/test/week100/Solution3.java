package test.week100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
https://leetcode-cn.com/contest/weekly-contest-100/problems/bitwise-ors-of-subarrays/
	898. �����鰴λ�����
	�û�ͨ������ 14
	�û����Դ��� 123
	ͨ������ 14
	�ύ���� 348
	��Ŀ�Ѷ� Medium
	������һ���Ǹ��������� A��

	����ÿ���������ģ������� B = [A[i], A[i+1], ..., A[j]] �� i <= j�������Ƕ� B �е�ÿ��Ԫ�ؽ��а�λ���������ý�� A[i] | A[i+1] | ... | A[j]��

	���ؿ��ܽ���������� ����γ��ֵĽ�������մ��н�����һ�Ρ���

	 

	ʾ�� 1��

	���룺[0]
	�����1
	���ͣ�
	ֻ��һ�����ܵĽ�� 0 ��
	ʾ�� 2��

	���룺[1,1,2]
	�����3
	���ͣ�
	���ܵ�������Ϊ [1]��[1]��[2]��[1, 1]��[1, 2]��[1, 1, 2]��
	�����Ľ��Ϊ 1��1��2��1��3��3 ��
	������Ψһֵ�����Դ��� 3 ��
	ʾ�� 3��

	���룺[1,2,4]
	�����6
	���ͣ�
	���ܵĽ���� 1��2��3��4��6���Լ� 7 ��
	 

	��ʾ��

	1 <= A.length <= 50000
	0 <= A[i] <= 10^9*/

public class Solution3 {

	public int subarrayBitwiseORs(int[] A) {
		
		/*
		 * һ��Ԫ��ʱ�� ����Ԫ��ʱ����ǰһ��Ԫ�ؽ�β������������ + �ڶ���Ԫ�ص��� һ�����n��N-1�Ľ⼯ + ��N-1Ϊ��β������������&N +
		 * NԪ�ص������ȼ��� NΪ��β������������
		 * 
		 */
		// ��NԪ�ؽ�β������������

		HashSet<Integer> total = new HashSet<>();
		HashSet<Integer> cur = new HashSet<>();
		for (int i : A) {
			HashSet<Integer> nc = new HashSet<>();
			nc.add(i);
			for (int j : cur)
				nc.add(i | j);
			for (int j : nc)
				total.add(j);
			cur = nc;
		}
		return total.size();

	}

	/*
	 * public int subarrayBitwiseORs(int[] A) { List<Integer> list = new
	 * LinkedList<Integer>(); dfs(A, 0, list);
	 * 
	 * return 0;
	 * 
	 * }
	 * 
	 * void dfs(int[] A, int index, List<Integer> list) { if (index == A.length) {
	 * // System.out.println(list); return; }
	 * 
	 * dfs(A, index + 1, list); list.add(A[index]); dfs(A, index + 1, list);
	 * list.remove(list.size() - 1);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = { 1, 2, 4 };
		System.out.println(new Solution3().subarrayBitwiseORs(test));
	}

}
