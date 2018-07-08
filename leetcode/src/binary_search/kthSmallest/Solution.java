package binary_search.kthSmallest;

public class Solution {

	public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int h = matrix[matrix.length - 1][matrix.length - 1];

        while(l <= h) {
        	int m = l + (h - l)/2;
        	//System.out.println("m = "+m);
        	if(count(matrix,k,m) >= k) {//偏大(比它小的数大于K个)
        		h = m - 1;
        		//System.out.println("guess:"+m+"偏大");
        	}else {//偏小
        		//System.out.println("guess:"+m+"偏小");

        		l = m + 1;
        	}
        }
        return h;
        
    }
	/* 判断值g是不是第K小的元素，返回 */
	public int count(int[][] matrix, int k,int g) {
		int cnt = 0;//算一下有多少个数比g大
		for(int i = 0; i < matrix.length; i++) {
			
			int l = 0 ;
			int h = matrix.length - 1;
			 while(l <= h) {
				 int m = l + (h - l)/2;
				 /*
				 if(matrix[i][m] > g) {
					 h = m - 1;
				 }else {
					 l = m + 1;
				 }
				 l最后返回的数肯定是比目标数大（原数组中比目标数大的最小的数值）
				 
				 */
				 if(matrix[i][m] < g) {
					 l = m + 1;					 
				 }else {
					 h = m - 1;//这个还会变成-1
				 }
				 /*
				 此时h最后返回的数刚好是目标数要小的最大的数
				  */		
			 }
			 //System.out.println("第"+i +"行"+"共有"+(h+1)+"个数比目标数"+g+"小");
			 cnt += (h+1);
			 
		}
		//System.out.println("共有"+cnt+"个数比目标数"+g+"小");
		return cnt ;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {
				{ 1,  5,  9},
				{10, 11, 13},
				{12, 13, 15}	
		};
		System.out.println(new Solution().kthSmallest(matrix, 3));
	}

}
