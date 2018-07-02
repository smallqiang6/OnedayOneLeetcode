package greedy.canCompleteCircuit;
/*
https://leetcode-cn.com/problems/gas-station/description/
*/

/*
这道题目很容易想到直观的算法：以每一个点作为出发点，尝试是否能走完一圈；若均不能，则没有。时间复杂度为O(n2)。 
实际上经过分析我们可以发现：
若以i为出发点，
走到j时无法走到下一个点。
对于在i和j中的任意一点k，走到k点时剩余油量一定是大于等于0的。
所以，如果从i为出发点最多只能走到j，那么从k也最多只能走到j。
所以若以i为出发点无法走完一圈时，i到j之间的点都可以排除。时间复杂度为O(n)。
*/
/*
输入: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。


*/


public class Solution {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int cur_gas = 0;
		int cur_cost = 0;
		int res = -1;
		for (int curr = 0; curr < gas.length; curr++) {
			// 挨个换起点，从start出发
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
/*示例 1:

	输入: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]

	输出: 3

	解释:
	从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
	开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
	开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
	开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
	开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
	开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
	因此，3 可为起始索引。
	示例 2:

	输入: 
	gas  = [2,3,4]
	cost = [3,4,3]

	输出: -1

	解释:
	你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
	我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
	开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
	开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
	你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
	因此，无论怎样，你都不可能绕环路行驶一周。	*/
		int gas [] = {1,2,3,4,5};
		int cost [] = {3,4,5,1,2};
		
		new Solution().canCompleteCircuit(gas, cost);
		//---------------------------
		int gas1 [] = {2,3,4};
		int cost1 [] = {3,4,3};
		
		new Solution().canCompleteCircuit(gas1, cost1);
		
		
		
		/*输入：
		[4,5,2,6,5,3]
		[3,2,7,3,2,9]
		输出：
		3
		预期：
		-1*/
		int gas2 [] = {4,5,2,6,5,3};
		int cost2 [] = {3,2,7,3,2,9};
		
		new Solution().canCompleteCircuit(gas2, cost2);
	}

}
