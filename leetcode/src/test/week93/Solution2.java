package test.week93;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	/*从正整数 N 开始，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。

	如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。

	 

	示例 1：

	输入：1
	输出：true
	示例 2：

	输入：10
	输出：false
	示例 3：

	输入：16
	输出：true
	示例 4：

	输入：24
	输出：false
	示例 5：

	输入：46
	输出：true
	*/
	public boolean reorderedPowerOf2(int N) {
		String str = ""+N;
		//char[] n = str.toCharArray();
		char[] n1 = str.toCharArray();
		Arrays.sort(n1);
		return helper(n1, 0);
        
    }
	private boolean helper(char[] str, int index) {
		boolean res = false;
		if(index == str.length -1)  
	    {  
			/*ArrayList<Integer> in = new ArrayList<Integer>();  
		    for(int i = 0;i<nums.length;i++)  
		    {  
		        in.add(nums[i]);  
		    }  
		    res.add(in);  */
			if(str[0] == '0') {
				return false;
			}
			String temp = new String(str);
			int a = Integer.parseInt(temp) ;
			if ( (a>0) && ((a & (a-1))==0 )){
			    System.out.println("a is the power of 2");
			    return true;
			}
			
		    return false ;   
	    }  
	    else  
	    {  
	        for(int i = index;i<=str.length -1;i++)//第i个数分别与它后面的数字交换就能得到新的排列  
	        {

	            swap(str, i, index);  
	            //res = helper(str, index+1);//表示，若sur和sum相邻时输出  
	            if(true == helper(str, index+1)) {
	            	return true;
	            }
	            swap(str, i, index);  
	        }  
	    }
		return false;
		
	}
	public void swap(char[] str ,int i , int j)  
	{  
	    char temp = str[i];  
	    str[i] = str[j];  
	    str[j] = temp;  
	}  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution2().reorderedPowerOf2(1));
		System.out.println(new Solution2().reorderedPowerOf2(10));
		System.out.println(new Solution2().reorderedPowerOf2(16));
		System.out.println(new Solution2().reorderedPowerOf2(24));
		System.out.println(new Solution2().reorderedPowerOf2(46));
	}

}
