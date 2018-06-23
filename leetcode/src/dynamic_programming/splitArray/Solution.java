package dynamic_programming.splitArray;

/*
 * https://leetcode-cn.com/problems/split-array-largest-sum/description/
 * 410. �ָ���������ֵ
 * 
 ����һ���Ǹ����������һ������ m������Ҫ���������ֳ� m ���ǿյ����������顣���һ���㷨ʹ���� m ����������Ժ͵����ֵ��С��

ע��:
���鳤�� n ������������:

1 �� n �� 1000
1 �� m �� min(50, n)
ʾ��:

����:
nums = [7,2,5,10,8]
m = 2

���:
18

 */


/*
 * 
 * ��Ŀ�ȼ��ڣ�һ��int�����飬����Ԫ�ش���ÿ���¹��˹���ʱ��������m�����ˣ���Щ���˿���ͬʱ����������̶�ù����������
 * 
 * �ȼ��ڣ����������m�����ˣ�ʱ���ٶ�һ���Ҫ��һ��������
 * 
 * 
 * �ⷨ1����m������������ֵΪ����X ��Xȡֵ��Ԫ�����ֵ �� Ԫ��֮�� �м䣩
 * 
 * �ⷨ2��
 * dp[i][j]��ʾ��������ǰj�����ֳַ�i�����ܵõ�����С�ĸ��������������ֵ����ʼ��Ϊ�������ֵ������޷���Ϊi�飬��ô���Ǳ���Ϊ�������ֵ
 * 
 * �����м�����һ��λ��k��dp[i-1][k]��ʾ������ǰk�����ֳַ�i-1�����ܵõ�����С�ĸ��������������ֵ����sums[j]-sums[k]���Ǻ��������֮��
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
        * ����:
        	nums = [7,2,5,10,8]
        	m = 2

        	���:
        	18*/
        /*
         * ��֪����һ�������ֳ�i-1��Ľ������У���ֳ�i��Ľ���
         * ���һ��ķ����������ô�������������һ�������
         */
        
        for (int i = 1; i <= m; ++i) {  //�ֳ�i�飬������������У�iȡ1��2
            for (int j = 1; j <= n; ++j) { //ǰj������������������У�jȡ1��5
            	//j���䣬����ǰ�����а�ǰj�����ֳ�i-1��  �ָ��������ֵ��С�Ľ��ۣ�dp[i-1][j]��֪
            	//��δ�dp[i-1][j] �Ƴ�  dp[i][j]��������
            	//  dp[i][j] ��ȷ����Ҫ dp[i-1][i-1  ~ j-1]  �������ֵ�Ƶ�����

                for (int k = i - 1; k < j; ++k) {//Kȡֵ  i-1  ��   j
                    int val = Math.max(dp[i - 1][k], sums[j] - sums[k]);//���������Ϣ��̫��
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
