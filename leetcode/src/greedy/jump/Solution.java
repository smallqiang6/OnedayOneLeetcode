package greedy.jump;
/*
https://leetcode-cn.com/problems/jump-game-ii/description/

����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�

ʾ��:

����: [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
˵��:

���������ǿ��Ե�����������һ��λ�á�
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
//���ö�̬�滮��˼·������һ��stepMatrix[]���飬���浽��ÿ��λ������Ҫ����С����
//�ӵ�һ��λ�ÿ�ʼ��stepMatrix[0] = 0���������ܵ����λ�ò���+1
//Ȼ��һ��һ��λ�õ������ƣ�ֱ���ҵ�����λ�á�
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
			int maxfar = 0;// ̰���㷨 ÿ��ѡ����һ���ɴ���Զ����һ��
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
			cur = nextstep;// ̰���㷨 ÿ��ѡ����һ���ɴ���Զ����һ��
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
