package binary_search.search;
/*
https://leetcode-cn.com/problems/binary-search/description/
	
	����һ�� n ��Ԫ������ģ������������� nums ��һ��Ŀ��ֵ target  ��дһ���������� nums �е� target�����Ŀ��ֵ���ڷ����±꣬���򷵻� -1��


	ʾ�� 1:

	����: nums = [-1,0,3,5,9,12], target = 9
	���: 4
	����: 9 ������ nums �в����±�Ϊ 4
	ʾ�� 2:

	����: nums = [-1,0,3,5,9,12], target = 2
	���: -1
	����: 2 ������ nums ����˷��� -1
	 

	��ʾ��

	����Լ��� nums �е�����Ԫ���ǲ��ظ��ġ�
	n ���� [1, 10000]֮�䡣
	nums ��ÿ��Ԫ�ض����� [-9999, 9999]֮�䡣	
*/


public class Solution {

	
	public int search(int[] nums, int target) {
		int h = nums.length - 1;
		int l = 0;
		
		while( l <= h) {
			int m = l + (h - l)/2;
			
			//���ص�һ�����ڵ���target��Ԫ��
			if(nums[m] <= target) {//
				l = m + 1;
			}else {
				h = m - 1;
			}	
		}
		
		//System.out.println("return:"+nums[h]);
		if(h >= 0 && h < nums.length && nums[h] == target) {
			return h;
		}else {
			return -1;
		}
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[] data = {-1,0,3,5,9,12};
		int[] data = {5};
		System.out.println(new Solution().search(data, -5));
	}

}
