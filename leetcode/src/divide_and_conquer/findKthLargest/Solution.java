package divide_and_conquer.findKthLargest;

/**
 * 
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 * /

/*���ÿ�������ķ�ʽ�������е�Ԫ�ؽ������򣨽������У���ÿ���һ���������ȷ��һ��Ԫ�ص�λ�ã�

��1��������λ��ǡ����K��ô��������k֮ǰ��Ԫ�ؼ�Ϊ����

��2��������λ���ڱ�k����ô��k�������һ���������λ��֮ǰ�����λ����ǰk����������Ͻ硣

��3��������λ�ñ�kС����ô ��k�������һ�������λ��֮����ô���λ����ǰk����������½�*/

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		return findKthLargestFromTo(nums,k,0,nums.length - 1);      
    }
	public static int findKthLargestFromTo(int[] nums, int k, int from, int to)
	{	
		int p =  qsort_partition(nums,from,to);
		//System.out.println("findKthLargestFromTo p = " + p );
		
		
		if(p == to - k + 1)
		{
			//System.out.println("findKthLargestFromTo ret = " + nums[p] );
			return nums[p];
		}else if(p > to - k + 1)//from--p
		{
			if(p == to)
				p = p - 1;
			return findKthLargestFromTo(nums, k - (to - p), from, p);
		}else if(p < to - k + 1)//p--to
		{
			if(p == from)
				p = p + 1;
			return findKthLargestFromTo(nums, k, p,to);
		}
		return 0;
		
	}
	
	/* partion by the element nums[end] */
	/* �㷨���۱�׼ʵ�ְ汾 */
	public static int qsort_partition(int[] nums, int start, int end)
	{
		int base = nums[end];
		int i = start - 1;  //i�±�ָ���Ԫ���Լ�֮ǰ��Ԫ�ض�С��base
		for(int j = start; j < end; j++)
		{
			if(nums[j] <= base)//С��base��i�ƶ�һ��
			{
				i++;
				swap(nums,i,j);			
			}
		}
		swap(nums,i+1,end);
		return i+1;
	}
	
	static void swap(int[] ary,int x,int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data1 [] = {3,2,1,5,6,4};
		if( 5 == new Solution().findKthLargest(data1, 2) )
		{
			System.out.println("testcase1 pass");
		}
		
		int data2 [] = {3,2,3,1,2,4,5,5,6};
		if( 4 == new Solution().findKthLargest(data2, 4) )
		{
			System.out.println("testcase2 pass");
		}

	}

}
