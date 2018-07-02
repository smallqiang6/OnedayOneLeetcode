package greedy.canCompleteCircuit;
/*
https://leetcode-cn.com/problems/gas-station/description/
*/

/*
�����Ŀ�������뵽ֱ�۵��㷨����ÿһ������Ϊ�����㣬�����Ƿ�������һȦ���������ܣ���û�С�ʱ�临�Ӷ�ΪO(n2)�� 
ʵ���Ͼ����������ǿ��Է��֣�
����iΪ�����㣬
�ߵ�jʱ�޷��ߵ���һ���㡣
������i��j�е�����һ��k���ߵ�k��ʱʣ������һ���Ǵ��ڵ���0�ġ�
���ԣ������iΪ���������ֻ���ߵ�j����ô��kҲ���ֻ���ߵ�j��
��������iΪ�������޷�����һȦʱ��i��j֮��ĵ㶼�����ų���ʱ�临�Ӷ�ΪO(n)��
*/
/*
����: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

���: 3

����:
�� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
��ˣ�3 ��Ϊ��ʼ������


*/


public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int cur_gas = 0;
		int cur_cost = 0;
		int res = -1;
		for (int curr = 0; curr < gas.length; curr++) {
			// ��������㣬��start����
			cur_gas = gas[curr];
			boolean complete = true;
			for (int step = 1; step <= gas.length; step++) {
				int nextindex = (curr + step) % gas.length;
				int index = (curr + step - 1) % gas.length;
				if (cur_gas < cost[index]) {
					complete = false;
					curr += step-1;
					break;
				} else {
					cur_gas -= cost[index];
					cur_gas += gas[nextindex];
					//System.out.println("start="+curr+"   step"+step+":  cur_gas="+cur_gas);
				}
			}
			if (complete) {
				//System.out.println(curr);
				return curr;
			}

		}
		//System.out.println(-1);
		return -1;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*ʾ�� 1:

	����: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]

	���: 3

	����:
	�� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
	���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
	���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
	���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
	���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
	���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
	��ˣ�3 ��Ϊ��ʼ������
	ʾ�� 2:

	����: 
	gas  = [2,3,4]
	cost = [3,4,3]

	���: -1

	����:
	�㲻�ܴ� 0 �Ż� 1 �ż���վ��������Ϊû���㹻�����Ϳ���������ʻ����һ������վ��
	���Ǵ� 2 �ż���վ���������Ի�� 4 �����͡� ��ʱ������ = 0 + 4 = 4 ������
	���� 0 �ż���վ����ʱ������ 4 - 3 + 2 = 3 ������
	���� 1 �ż���վ����ʱ������ 3 - 3 + 3 = 3 ������
	���޷����� 2 �ż���վ����Ϊ������Ҫ���� 4 �����ͣ������������ֻ�� 3 �����͡�
	��ˣ������������㶼�������ƻ�·��ʻһ�ܡ�	*/
		int gas [] = {1,2,3,4,5};
		int cost [] = {3,4,5,1,2};
		
		new Solution().canCompleteCircuit(gas, cost);
		//---------------------------
		int gas1 [] = {2,3,4};
		int cost1 [] = {3,4,3};
		
		new Solution().canCompleteCircuit(gas1, cost1);
		
		
		
		/*���룺
		[4,5,2,6,5,3]
		[3,2,7,3,2,9]
		�����
		3
		Ԥ�ڣ�
		-1*/
		int gas2 [] = {4,5,2,6,5,3};
		int cost2 [] = {3,2,7,3,2,9};
		
		new Solution().canCompleteCircuit(gas2, cost2);
	}

}
