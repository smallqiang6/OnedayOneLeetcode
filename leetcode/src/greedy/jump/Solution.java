package greedy.jump;
/*
https://leetcode-cn.com/problems/jump-game-ii/description/

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
*/
public class Solution {
public boolean canJump(int[] nums) {
		
		if(nums.length == 0)
			return false;
		int length = nums.length;
		int far = -1;
		for(int i = 0; i < length; i++) {
			if(nums[i] > far) {
				far = nums[i];
			}
			if(far >= length-i-1) {
				return true;
			}
			if(far == 0) {
				break;
			}
			far--;
		}
		return false;
        
    }
//
//利用动态规划的思路，构建一个stepMatrix[]数组，保存到达每个位置所需要的最小步数
//从第一个位置开始，stepMatrix[0] = 0，将其所能到达的位置步数+1
//然后一个一个位置的往后推，直到找到最后的位置。
	public int jump_bianli(int[] nums) {
		int stepMatrix[] = new int[nums.length];
		for(int i = 0; i < stepMatrix.length; i++)
		{
			stepMatrix[i] = Integer.MAX_VALUE;
		}
		stepMatrix[0] = 0;
		for(int i = 0; i < nums.length; i++)
		{
			int thisfar = nums[i];
			//int bound = Math.min(nums.length-1, arg1)
			for(int j = 1; j <= thisfar;j++)
			{
				if(i+j > nums.length-1)
					break;
				stepMatrix[i+j] = Math.min(stepMatrix[i+j], stepMatrix[i]+1);
			}
		}
		
		return stepMatrix[nums.length-1];
	    
	}
	
	public int jump_greedy(int[] nums) {
		/*
		 * int stepMatrix[] = new int[nums.length]; for(int i = 0; i <
		 * stepMatrix.length; i++) { stepMatrix[i] = Integer.MAX_VALUE; } stepMatrix[0]
		 * = 0;
		 */
		int stepcnt = 0;
		// for(int i = 0; i < nums.length; i++)
		int cur = 0;
		while (cur < nums.length - 1) {
			stepcnt++;
			int thisfar = nums[cur];
			int maxfar = 0;// 贪心算法 每次选择下一步可达最远的那一格
			int nextstep = -1;
			// int bound = Math.min(nums.length-1, arg1)
			for (int j = 1; j <= thisfar; j++) {

				if (cur + j >= nums.length - 1) {
					return stepcnt;
				}

				if (cur + j + nums[cur + j] > maxfar) {
					maxfar = cur + j + nums[cur + j];
					nextstep = cur + j;
				}

			}
			cur = nextstep;// 贪心算法 每次选择下一步可达最远的那一格
		}

		return stepcnt;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {2,3,1,1,4};
		if(2 == new Solution().jump_greedy(data))
		{
			System.out.println("testcase1 pass");
		}
	}

}
