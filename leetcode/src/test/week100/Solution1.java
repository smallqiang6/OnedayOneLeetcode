package test.week100;

/*https://leetcode-cn.com/contest/weekly-contest-100/problems/monotonic-array/

	896. ��������
	�û�ͨ������ 109
	�û����Դ��� 153
	ͨ������ 113
	�ύ���� 219
	��Ŀ�Ѷ� Easy
	��������ǵ��������򵥵��ݼ��ģ���ô���ǵ����ġ�

	����������� i <= j��A[i] <= A[j]����ô���� A �ǵ��������ġ� ����������� i <= j��A[i]> = A[j]����ô���� A �ǵ����ݼ��ġ�

	������������ A �ǵ�������ʱ���� true�����򷵻� false��

	 

	ʾ�� 1��

	���룺[1,2,2,3]
	�����true
	ʾ�� 2��

	���룺[6,5,4,4]
	�����true
	ʾ�� 3��

	���룺[1,3,2]
	�����false
	ʾ�� 4��

	���룺[1,2,4,5]
	�����true
	ʾ�� 5��

	���룺[1,1,1]
	�����true
	 

	��ʾ��

	1 <= A.length <= 50000
	-100000 <= A[i] <= 100000
	*/
public class Solution1 {
	public boolean isMonotonic(int[] A) {
        int head = A[0];
        int flag = 0;//�������ǵݼ� �������
        
        for (int i = 0; i < A.length; i++) {
			int curGap = A[i] - head;
			//
			if( (curGap > 0 && flag < 0) || (curGap < 0 && flag > 0) ) {
				return false;
			}
			flag = (curGap == 0 ? flag:curGap);
			head = A[i];
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {6,5,4,4};
		System.out.println(new Solution1().isMonotonic(test1));
	}

}
