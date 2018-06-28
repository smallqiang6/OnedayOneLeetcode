package dynamic_programming.Catalan;

//https://leetcode-cn.com/problems/unique-binary-search-trees/description/
//参考博客：
//https://www.cnblogs.com/ariel-dreamland/p/9159715.html
/*96. 不同的二叉搜索树
题目描述提示帮助提交记录社区讨论阅读解答
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */
/*
这道题实际上是 Catalan Number卡塔兰数的一个例子，如果对卡塔兰数不熟悉的童鞋可能真不太好做。先来看当 n = 1的情况，只能形成唯一的一棵二叉搜索树，n分别为1,2,3的情况如下所示：



复制代码
复制代码
                    1                        n = 1

                2        1                   n = 2
               /          \
              1            2
  
   1         3     3      2      1           n = 3
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
复制代码
复制代码
 

就跟斐波那契数列一样，我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。n = 2的情况可由下面式子算出：

dp[2] =  dp[0] * dp[1]　　　(1为根的情况)

　　　　+ dp[1] * dp[0]　　  (2为根的情况)

同理可写出 n = 3 的计算方法：

dp[3] =  dp[0] * dp[2]　　　(1为根的情况)

　　　　+ dp[1] * dp[1]　　  (2为根的情况)

 　　　  + dp[2] * dp[0]　　  (3为根的情况)

由此可以得出卡塔兰数列的递推式为：

C_0 = 1 \quad \mbox{and} \quad C_{n+1}=\sum_{i=0}^{n}C_i\,C_{n-i}\quad\mbox{for }n\ge 0.

我们根据以上的分析，可以写出代码如下：*/


public class Solution {
	public int numTrees(int n) {
        if (n == 0)return 0;
        if (n == 1) return 1;
 
        int[] nums = new int[n+1];
        nums[0] = 1; nums[1] = 1;
 
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] = nums[i] + nums[j] * nums[i-1-j];
            }
        }
        return nums[n];
 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
