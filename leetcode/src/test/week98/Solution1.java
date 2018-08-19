package test.week98;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Solution1 {

//	888. ��ƽ���ǹ�����
//	�û�ͨ������ 0
//	�û����Դ��� 0
//	ͨ������ 0
//	�ύ���� 0
//	��Ŀ�Ѷ� Easy
//	����˿�ͱ����в�ͬ��С���ǹ�����A[i] �ǰ���˿ӵ�еĵ� i ���ǵĴ�С��B[j] �Ǳ���ӵ�еĵ� j ���ǵĴ�С��
//
//	��Ϊ���������ѣ����������뽻��һ���ǹ������������������Ƕ�����ͬ���ǹ���������һ����ӵ�е��ǹ�����������ӵ�е��ǹ�����С���ܺ͡���
//
//	����һ���������� ans������ ans[0] �ǰ���˿���뽻�����ǹ����Ĵ�С��ans[1] �� Bob ���뽻�����ǹ����Ĵ�С��
//
//	����ж���𰸣�����Է��������κ�һ������֤�𰸴��ڡ�
//
//	 
//
//	ʾ�� 1��
//
//	���룺A = [1,1], B = [2,2]    2  4
//	�����[1,2]
//	ʾ�� 2��
//
//	���룺A = [1,2], B = [2,3]   3  5
//	�����[1,2]
//	ʾ�� 3��
//
//	���룺A = [2], B = [1,3]   2  4 
//	�����[2,3]
//	ʾ�� 4��
//
//	���룺A = [1,2,5], B = [2,4]  8   6 
//	�����[5,4]
//	 
//
//	��ʾ��
//
//	1 <= A.length <= 10000
//	1 <= B.length <= 10000
//	1 <= A[i] <= 100000
//	1 <= B[i] <= 100000
//	��֤����˿�뱫�����ǹ�������ͬ��
//	�𰸿϶����ڡ�
	
	public int[] fairCandySwap(int[] A, int[] B) {
		//Arrays.sort(A);
		//Arrays.sort(B);
		Set<Integer> setB = new HashSet<Integer>();
		
		int sumA = 0 ,sumB = 0;
		for(int i:A) {
			sumA += i;
		}
		for(int i:B) {
			sumB += i;
			setB.add(i);
		}
		int gap = Math.abs(sumA - sumB)/2;
		int[] res  = new int[2];
		if(sumA > sumB) {
			//AҪ��һ������Сgap��Ԫ�ػ���
			for(int i:A) {
				if (setB.contains(i - gap)) {
					res[0] = i;
					res[1] = i - gap;
					return res;
				}
			}
		}else if(sumA < sumB) {
			for(int i:A) {
				if (setB.contains(i + gap)) {
					res[0] = i;
					res[1] = i + gap;
					return res;
				}
			}
		}
			
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		���룺A = [1,2,5], B = [2,4]  8   6 
//		�����[5,4]
		int[] A = {1,2,5};
		int[] B = {2,4};
		int[] res = new Solution1().fairCandySwap(A, B);
		System.out.println(res[0]+" "+ res[1]);
	}

}
