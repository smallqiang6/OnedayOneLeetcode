package array.firstMissingPositive;
//Ҫ�� �������ռ�  ��On
//�ȼ���--��1��ʼ������1�������������������
//tips1��������Щ����
//tips2���������10���������ؽ����ֵ���ֵ��11����Сֵ��1  ����������п��ܣ������ȷ�����ֵ�أ�
//tips3����10��������Ӧ10���⣬������ʱ�򣬶���һ��������6��˵���������1~11֮�䣬�͵����������
//tips4����������10�������ĵ������

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
	//����ǰi�����Ѿ��ҵ����ֱ�����A[0...I-1]�У���������A[I]
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
//TODO �������пռ�
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
