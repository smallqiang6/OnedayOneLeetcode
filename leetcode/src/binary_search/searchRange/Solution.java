package binary_search.searchRange;
/*
https://leetcode-cn.com/problems/search-for-a-range/description/
 */

/*

����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�

����㷨ʱ�临�Ӷȱ����� O(log n) ����

��������в�����Ŀ��ֵ������ [-1, -1]��

ʾ�� 1:

����: nums = [5,7,7,8,8,10], target = 8
���: [3,4]
ʾ�� 2:

����: nums = [5,7,7,8,8,10], target = 6
���: [-1,-1]
 */

//�պ�«��ư
public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int [] ret = new int[2];
		
		int n = nums.length;  
        
        int l = 0, h = n - 1;  
        while (l <= h ) { 
            int m = l + (h - l) / 2;  
        	//System.out.println("l="+l+";h="+l+";m="+m);            
            if (nums[m] < target)  
                l = m + 1;  
            else if(nums[m] > target)   
                h = m - 1;  
            else {
            	l = m;
            	while(nums[l] == target && l > 0)
            	{
            		l--;
            	}
            	ret[0] = nums[l] != target ? l+1 : 0;
            	h = m;
            	while(nums[h] == target && h < n - 1)
            	{
            		h++;
            	}
            	ret[1] = nums[h] != target ? h-1 : n-1;
            	break;
            }
        } 
        if(l > h)
        {
        	ret[0] = -1;
        	ret[1] = -1;
        }

 //System.out.println("ret0="+ret[0]+";ret1="+ret[1]);

        return ret;  //��󷵻ص��� l λ�õ��ַ�  
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data []  = {5,7,7,8,8,8,8,10};
		new Solution().searchRange(data, 9);

	}

}
