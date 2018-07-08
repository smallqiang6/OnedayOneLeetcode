package binary_search.kthSmallest;

public class Solution {

	public int kthSmallest(int[][] matrix, int k) {
        int l = matrix[0][0];
        int h = matrix[matrix.length - 1][matrix.length - 1];

        while(l <= h) {
        	int m = l + (h - l)/2;
        	//System.out.println("m = "+m);
        	if(count(matrix,k,m) >= k) {//ƫ��(����С��������K��)
        		h = m - 1;
        		//System.out.println("guess:"+m+"ƫ��");
        	}else {//ƫС
        		//System.out.println("guess:"+m+"ƫС");

        		l = m + 1;
        	}
        }
        return h;
        
    }
	/* �ж�ֵg�ǲ��ǵ�KС��Ԫ�أ����� */
	public int count(int[][] matrix, int k,int g) {
		int cnt = 0;//��һ���ж��ٸ�����g��
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
				 l��󷵻ص����϶��Ǳ�Ŀ������ԭ�����б�Ŀ���������С����ֵ��
				 
				 */
				 if(matrix[i][m] < g) {
					 l = m + 1;					 
				 }else {
					 h = m - 1;//���������-1
				 }
				 /*
				 ��ʱh��󷵻ص����պ���Ŀ����ҪС��������
				  */		
			 }
			 //System.out.println("��"+i +"��"+"����"+(h+1)+"������Ŀ����"+g+"С");
			 cnt += (h+1);
			 
		}
		//System.out.println("����"+cnt+"������Ŀ����"+g+"С");
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
