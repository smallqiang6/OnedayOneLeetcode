package test.week96;

import java.util.Arrays;
import java.util.Comparator;



/*
885. 救生艇
用户通过次数 0
用户尝试次数 0
通过次数 0
提交次数 0
题目难度 Medium
第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。

每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。

返回载到每一个人所需的最小船数。(保证每个人都能被船载)。

 

示例 1：

输入：people = [1,2], limit = 3
输出：1
解释：1 艘船载 (1, 2)
示例 2：

输入：people = [3,2,2,1], limit = 3
输出：3
解释：3 艘船分别载 (1, 2), (2) 和 (3)
示例 3：

输入：people = [3,5,3,4], limit = 5
输出：4
解释：4 艘船分别载 (3), (3), (4), (5)
提示：

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
*/

public class Solution2 {
	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int count = 0;
		
		for(int i = people.length -1,j = 0 ; i >= 0 && i >= j ; i--) {
			
			//selected[i] = true;
			count++;
			if(i == j) {
				return count;
			}
					
			if(people[j] + people[i] <= limit) {
				//System.out.println(people[i]+"and"+people[j]+"一条船");

				j++;
			}
			
		}
		
		return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data0 = {3,5,3,4};
		System.out.println(new Solution2().numRescueBoats(data0, 5));
		
		int[] data1 = {3,2,2,1};
		System.out.println(new Solution2().numRescueBoats(data1, 3));
		
		int[] data2 = {1,1,2};
		System.out.println(new Solution2().numRescueBoats(data2, 3));
		
		int[] data3 = {3,2,3,2,2};
		System.out.println(new Solution2().numRescueBoats(data3, 6));
		int[] data4 = {};
	}

}
