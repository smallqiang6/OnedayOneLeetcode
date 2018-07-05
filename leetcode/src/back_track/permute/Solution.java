package back_track.permute;
/*
 * https://leetcode-cn.com/problems/permutations/description/
 */
/*
����һ��û���ظ����ֵ����У����������п��ܵ�ȫ���С�

ʾ��:

����: [1,2,3]
���:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
�򵥵�˵�����ǵ�һ�����ֱ��Ժ���������н���

E��g��E = ��a , b , c������ prem��E��= a.perm��b,c��+ b.perm��a,c��+ c.perm��a,b��

Ȼ��a.perm��b,c��= ab.perm��c��+ ac.perm��b��= abc + acb.���εݹ����
*/

public class Solution {
	List<List<Integer>> res;
	public List<List<Integer>> permute(int[] nums) {
		res = new LinkedList<List<Integer>>();

		// �Ƚ�������������ظ�����
		Arrays.sort(nums);
		helper(nums, 0);
		return res;
    }
	private void helper(int[] nums, int index) {
		if(index == nums.length -1)  
	    {  
			ArrayList<Integer> in = new ArrayList<Integer>();  
		    for(int i = 0;i<nums.length;i++)  
		    {  
		        in.add(nums[i]);  
		    }  
		    res.add(in);  
		    return ;   
	    }  
	    else  
	    {  
	        for(int i = index;i<=nums.length -1;i++)//��i�����ֱ�������������ֽ������ܵõ��µ�����  
	        {  
	            swap(nums, i, index);  
	            helper(nums, index+1);//��ʾ����sur��sum����ʱ���  
	            swap(nums, i, index);  
	        }  
	    }  
	}
	public void swap(int[] num ,int i , int j)  
	{  
	    int temp = num[i];  
	    num[i] = num[j];  
	    num[j] = temp;  
	}  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[]  = {2,3,5};
		List<List<Integer>> res = new Solution().permute(data);
		for(List l : res)
		{
			System.out.println(l);
		}
	}

}
