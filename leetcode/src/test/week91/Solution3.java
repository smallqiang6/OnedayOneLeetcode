package test.week91;
/*
https://leetcode-cn.com/contest/weekly-contest-91/problems/score-after-flipping-matrix/
	*/
public class Solution3 {

	
/*	861. ��ת�����ĵ÷�
	�û�ͨ������ 31
	�û����Դ��� 38
	ͨ������ 31
	�ύ���� 49
	��Ŀ�Ѷ� Medium
	��һ����ά���� A ����ÿ��Ԫ�ص�ֵΪ 0 �� 1 ��

	�ƶ���ָѡ����һ�л��У���ת�����л����е�ÿһ��ֵ�������� 0 ������Ϊ 1�������� 1 ������Ϊ 0��

	����������������ƶ��󣬽��þ����ÿһ�ж����ն������������ͣ�����ĵ÷־�����Щ���ֵ��ܺ͡�

	���ؾ����ܸߵķ�����

	 

	ʾ����

	���룺[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
	�����39
	���ͣ�
	ת��Ϊ [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
	0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
	 

	��ʾ��

	1 <= A.length <= 20
	1 <= A[0].length <= 20
	A[i][j] �� 0 �� 1
	*/
	public int matrixScore(int[][] a) {
		int n = a.length, m = a[0].length;
		for (int i = 0; i < n; i++) {
			if (a[i][0] == 0) {
				for (int j = 0; j < m; j++) {
					a[i][j] ^= 1;
				}
			}
		}
		long ret = 0;
		for (int j = 0; j < m; j++) {
			int one = 0;
			for (int i = 0; i < n; i++) {
				if (a[i][j] == 1)
					one++;
			}
			ret = ret * 2 + Math.max(one, n - one);
		}
		return (int) ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
