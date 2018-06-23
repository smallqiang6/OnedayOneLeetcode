package dynamic_programming.splitArray;

/*
 * https://leetcode-cn.com/problems/split-array-largest-sum/description/
 * 410. 分割数组的最大值
 * 
 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

 */


/*
 * 
 * 题目等价于：一个int型数组，数组元素代表每件事工人工作时长，现有m个工人，这些工人可以同时工作，问最短多久工作可以完成
 * 
 * 等价于：充分利用这m个工人，时间再短一点就要加一个工人了
 * 
 * 
 * 解法1：设m个子数组的最大值为变量X （X取值在元素最大值 和 元素之和 中间）
 * 
 * 解法2：
 * dp[i][j]表示将数组中前j个数字分成i组所能得到的最小的各个子数组中最大值，初始化为整型最大值，如果无法分为i组，那么还是保持为整型最大值
 * 
 * 假如中间任意一个位置k，dp[i-1][k]表示数组中前k个数字分成i-1组所能得到的最小的各个子数组中最大值，而sums[j]-sums[k]就是后面的数字之和
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class Solution {
	public int splitArray(int[] nums, int m) {
		
		int n = nums.length;
        int sums [] = new int [n+1];
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i < m+1; i++)
        {
        	for(int j = 0; j < n+1; j++)
        	{
        		dp[i][j] = Integer.MAX_VALUE;
        	}
        }
        dp[0][0] = 0;
        
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
       /* 
        * 输入:
        	nums = [7,2,5,10,8]
        	m = 2

        	输出:
        	18*/
        /*
         * 已知给定一组数，分成i-1组的结论已有，求分成i组的结论
         * 最后一组的分组情况，那么几种情况都遍历一遍就有了
         */
        
        for (int i = 1; i <= m; ++i) {  //分成i组，在上面的例子中，i取1到2
            for (int j = 1; j <= n; ++j) { //前j个数，在上面的例子中，j取1到5
            	//j不变，假设前面已有把前j个数分成i-1组  分割数组最大值最小的结论，dp[i-1][j]已知
            	//如何从dp[i-1][j] 推出  dp[i][j]！！！！
            	//  dp[i][j] 的确定需要 dp[i-1][i-1  ~ j-1]  根据这个值推倒出来

                for (int k = i - 1; k < j; ++k) {//K取值  i-1  到   j
                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);//这个条件信息量太大
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }
        }
        return dp[m][n];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {7,2,5,10,8};
		if(18 == new Solution().splitArray(data,2))
		{
			System.out.println("testcase1 pass");
		}

	}

}
