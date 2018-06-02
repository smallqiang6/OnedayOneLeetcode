package array.firstMissingPositive;
//要求 常数个空间  大On
//等价于--从1开始（包含1）的最长的连续数字序列
//tips1：忽略那些负数
//tips2：假如给我10个数，返回结果的值最大值是11，最小值是1  其他情况都有可能，如何能确认这个值呢？
//tips3：搞10个变量对应10个解，遍历的时候，对于一个数比如6来说，如果它在1~11之间，就点亮这个变量
//tips4；最后清点这10个变量的点亮情况

public class Solution {
	public int firstMissingPositive_hash(int[] nums) {
		int ret = 1;
		//step1 init
		boolean flag [] = new boolean[nums.length +1];
		for(int i = 0; i < flag.length ; i++)
		{
			flag[i] = false;
		}
		//step2 mainloop
		for(int i = 0;i < nums.length;i++)
		{
			if(nums[i]  >= 1  &&  nums[i] <= nums.length)
			{
				//do nothing
				flag[nums[i]] = true;
			}
		}
		//step3 check
		for(int i = 1 ; i < flag.length; i++)
		{
			if(flag[i] == true && i == ret)
			{
				ret++;
			}
		}
		System.out.println("nums.length="+nums.length);
		System.out.println("ret="+ret);		
		return ret;
    }

	public int firstMissingPositive(int[] nums) {
		int i = 0;
		for(i = 0 ; i < nums.length; i++)
		{
			firstMissingPositiveCheckI(nums,i);
		}

		i = 0;
		//nums[0:n]  like this: 1,2,3,4,....
		while (i < nums.length)
		{
			if(nums[i] == i+1)
			{
				i++;
			}
			else
			{
				break;
			}
		}
		System.out.println("ret="+(i+1));
		return i+1;

	}
	
    static void swap(int[] ary,int x,int y) {
        int temp = ary[x];
        ary[x] = ary[y];
        ary[y] = temp;
    }
	//假设前i个数已经找到，分别存放在A[0...I-1]中，继续考察A[I]
	public static void firstMissingPositiveCheckI(int[] nums , int I)  
	{
		if(nums[I] == I+1)
		{
			return;//perfect
		}
		if(nums[I] > I+1 )
		{
			if(nums[I] <= nums.length)
			{
				//swap with index nums[I] - 1, then (nums[nums[I] - 1] == nums[I])
				if(nums[nums[I] - 1] != nums[I])
				{
					swap(nums,I,nums[I] - 1);
					firstMissingPositiveCheckI(nums,I);
				}

			}
			else//nums[I] > nums.length
			{
				//ignore 
			}
		}
		if(nums[I] < I+1 && nums[I] > 0)
		{
			nums[nums[I] - 1] = nums[I];
		}		
		return;	
	}
//TODO 常量运行空间
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testcase1:
		int [] data1 = {7,8,9,11,12};
		if(1 == new Solution().firstMissingPositive(data1))
		{
			System.out.println("testcase1 pass here");
		}
		int [] data2 = {3,4,-1,1};
		if(2 == new Solution().firstMissingPositive(data2))
		{
			System.out.println("testcase2 pass here");
		}
		int [] data3 = {1,2,0};
		if(3 == new Solution().firstMissingPositive(data3))
		{
			System.out.println("testcase3 pass here");
		}
		int [] data4 = {2,2};
		if(1 == new Solution().firstMissingPositive(data4))
		{
			System.out.println("testcase4 pass here");
		}
		

	}

}
