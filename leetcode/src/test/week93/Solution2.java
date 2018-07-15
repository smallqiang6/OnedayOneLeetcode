package test.week93;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {
	/*�������� N ��ʼ�����ǰ��κ�˳�򣨰���ԭʼ˳�򣩽�������������ע����ǰ�����ֲ���Ϊ�㡣

	������ǿ���ͨ��������ʽ�õ� 2 ���ݣ����� true�����򣬷��� false��

	 

	ʾ�� 1��

	���룺1
	�����true
	ʾ�� 2��

	���룺10
	�����false
	ʾ�� 3��

	���룺16
	�����true
	ʾ�� 4��

	���룺24
	�����false
	ʾ�� 5��

	���룺46
	�����true
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
	        for(int i = index;i<=str.length -1;i++)//��i�����ֱ�������������ֽ������ܵõ��µ�����  
	        {

	            swap(str, i, index);  
	            //res = helper(str, index+1);//��ʾ����sur��sum����ʱ���  
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
