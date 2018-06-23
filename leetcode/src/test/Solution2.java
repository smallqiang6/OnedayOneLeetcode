package test;
//使用双指针
//山脉至少3个数
//时间超了，现在使用一遍遍历
public class Solution2 {
	
	/*public int longestMountain(int[] A) {
		
		return 0;
		
	}*/
	int lastBottom = 0;
	int maxMountLen = 0;
	public int longestMountain(int[] A) {

		for(int i = 0;i+2 < A.length;i++)
		{
			if(A[i] >= A[i+1] && A[i+2] >= A[i+1])
			{
				//System.out.println("here");
				if(isMount(A,lastBottom,i+1))
				{
					maxMountLen = Math.max(maxMountLen, i+1 - lastBottom + 1);
				}
				lastBottom = i+1;
			}
		}
		if(isMount(A,lastBottom,A.length -1))
		{
			maxMountLen = Math.max(maxMountLen, A.length -1 - lastBottom + 1);
		}
		//System.out.println("maxMountLen = "+maxMountLen);
		return maxMountLen;
        
    }
	public boolean isMount(int[] A,int from,int to)
	{
		//System.out.println("check is mount: form = "+from+"to = "+to);
		if(to - from +1 < 3  || to - from +1 <= maxMountLen)
		{
			return false;
		}
		int max = A[from];
		int maxIndex = from;
		int flag_up = 0;
		int flag_down = 0;
		
		for(int i = from+1; i < to+1; i++)
		{
			if(A[i] > max)//up
			{
				flag_up  =1;
				max = A[i];
				maxIndex = i;
				if(A[i] <= A[i-1])
				{
					return false;
				}
			}else if(A[i] < max){//down
				flag_down = 1;
				if(A[i] >= A[i-1])
				{
					return false;
				}
				
			}else {
				return false;
			}		
		}	
		if(flag_up == 0 || flag_down == 0)
		{
			return false;
		}
		//System.out.println("is mount: form = "+from+"to = "+to);
		return true;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data1[] = {2,1,4,7,3,2,5};
		if(5 == new Solution2().longestMountain(data1))
		{
			System.out.println("testcase1 pass");
		}
		
		int data2[] = {2,2,2};
		if(0 == new Solution2().longestMountain(data2))
		{
			System.out.println("testcase2 pass");
		}

		int data3[] = {1,1,0,0,1,0};
		if(3 == new Solution2().longestMountain(data3))
		{
			System.out.println("testcase3 pass");
		}
		//int data4[] = {}

	}

}
