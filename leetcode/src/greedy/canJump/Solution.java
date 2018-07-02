package greedy.canJump;
/*
https://leetcode-cn.com/problems/jump-game/description/
*/
/*
����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�

�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�

�ж����Ƿ��ܹ��������һ��λ�á�

ʾ�� 1:

����: [2,3,1,1,4]
���: true
����: ��λ�� 0 �� 1 �� 1 ��, Ȼ���� 3 ���������һ��λ�á�
ʾ�� 2:

����: [3,2,1,0,4]
���: false
����: �������������ܻᵽ������Ϊ 3 ��λ�á�����λ�õ������Ծ������ 0 �� ��������Զ�����ܵ������һ��λ�á�

*/
/*
http://www.cnblogs.com/wmx24/p/9032719.html

��̰�ĵ�˼�룬�������һ������ʼ����������һ��ֵfarΪ�ڵ�ǰλ������Ծ����󳤶ȡ�������˵far��ֵ��Ϊ-1������ÿ��λ�ã�

�жϵ�ǰλ����Ծ�ĳ����Ƿ����far�������������farΪ��ǰ����
�жϴӵ�ǰλ����Ծfar�ĳ����ܷ񵽴����һ��λ�ã����ܾͷ���true
�ж�far�Ƿ����0����Ϊ0˵���ڵ�ǰλ��һ��Ҳ�޷���Ծ������ֹͣ����������false
����ǰλ������Ծ����󳤶ȼ�1�������ж��¸�λ������Ծ����󳤶�
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
