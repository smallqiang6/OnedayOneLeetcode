package divide_and_conquer.findKthLargest;

/**
 * 
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 * /

/*采用快速排序的方式对数组中的元素进行排序（降序排列），每完成一趟排序可以确定一个元素的位置：

（1）如果这个位置恰好是K那么，数组中k之前的元素即为所求

（2）如果这个位置在比k大，那么第k个最大数一定都在这个位置之前，这个位置是前k个最大数的上界。

（3）如果这个位置比k小，那么 第k个最大数一定在这个位置之后，那么这个位置是前k个最大数的下届*/

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
	/* 算法导论标准实现版本 */
	public static int qsort_partition(int[] nums, int start, int end)
	{
		int base = nums[end];
		int i = start - 1;  //i下标指向的元素以及之前的元素都小于base
		for(int j = start; j < end; j++)
		{
			if(nums[j] <= base)//小于base，i移动一格
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
