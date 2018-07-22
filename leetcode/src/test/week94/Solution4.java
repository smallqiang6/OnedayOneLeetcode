package test.week94;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/length-of-longest-fibonacci-subsequence/
	
	873. ���쳲����������еĳ���
	�û�ͨ������ 19
	�û����Դ��� 36
	ͨ������ 19
	�ύ���� 110
	��Ŀ�Ѷ� Medium
	������� X_1, X_2, ..., X_n ����������������˵���� 쳲�����ʽ �ģ�

	n >= 3
	�������� i + 2 <= n������ X_i + X_{i+1} = X_{i+2}
	����һ���ϸ�����������������γ����У��ҵ� A �����쳲�����ʽ�������еĳ��ȡ����һ�������ڣ�����  0 ��

	������һ�£��������Ǵ�ԭ���� A �����������ģ����� A ��ɾ������������Ԫ�أ�Ҳ���Բ�ɾ���������ı�����Ԫ�ص�˳�����磬 [3, 5, 8] �� [3, 4, 5, 6, 7, 8] ��һ�������У�

	 

	ʾ�� 1��

	����: [1,2,3,4,5,6,7,8]
	���: 5
	����:
	���쳲�����ʽ������Ϊ��[1,2,3,5,8] ��
	ʾ�� 2��

	����: [1,3,7,11,12,14,18]
	���: 3
	����:
	���쳲�����ʽ�������У�
	[1,11,12]��[3,11,14] �Լ� [7,11,18] ��
	 

	��ʾ��

	3 <= A.length <= 1000
	1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
	�������� Java��C��C++���Լ� C# ���ύ��ʱ�����Ʊ������� 50%��
*/
public class Solution4 {
	Set<Integer> set = new HashSet<>();

	public int lenLongestFibSubseq(int[] A) {
		int n = A.length;
		for (int i : A)
			set.add(i);
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				int a = A[i];
				int b = A[j];
				int len = 2;
				while (set.contains(a + b)) {
					int tmp = b;
					b = a + b;
					a = tmp;
					++len;
				}
				ans = Math.max(ans, len);
			}
		}
		if (ans < 3)
			ans = 0;
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
