package greedy.canJump;
/*
https://leetcode-cn.com/problems/jump-game/description/
*/
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
示例 2:

输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

*/
/*
http://www.cnblogs.com/wmx24/p/9032719.html

用贪心的思想，从数组第一个数开始遍历，保存一个值far为在当前位置能跳跃的最大长度。具体来说far初值赋为-1，对于每个位置：

判断当前位置跳跃的长度是否大于far，若大于则更新far为当前数字
判断从当前位置跳跃far的长度能否到达最后一个位置，若能就返回true
判断far是否等于0，若为0说明在当前位置一步也无法跳跃，所以停止遍历并返回false
将当前位置能跳跃的最大长度减1，继续判断下个位置能跳跃的最大长度
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data1 [] = {2,3,1,1,4};
		if(true == new Solution().canJump(data1))
		{
			System.out.println("testcase1 pass");
		}
	}

}
