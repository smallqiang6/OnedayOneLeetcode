package test.week96;

import java.util.Arrays;
import java.util.Comparator;



/*
885. ����ͧ
�û�ͨ������ 0
�û����Դ��� 0
ͨ������ 0
�ύ���� 0
��Ŀ�Ѷ� Medium
�� i ���˵�����Ϊ people[i]��ÿ�Ҵ����Գ��ص��������Ϊ limit��

ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊ limit��

�����ص�ÿһ�����������С������(��֤ÿ���˶��ܱ�����)��

 

ʾ�� 1��

���룺people = [1,2], limit = 3
�����1
���ͣ�1 �Ҵ��� (1, 2)
ʾ�� 2��

���룺people = [3,2,2,1], limit = 3
�����3
���ͣ�3 �Ҵ��ֱ��� (1, 2), (2) �� (3)
ʾ�� 3��

���룺people = [3,5,3,4], limit = 5
�����4
���ͣ�4 �Ҵ��ֱ��� (3), (3), (4), (5)
��ʾ��

1 <= people.length <= 50000
1 <= people[i] <= limit <= 30000
*/

public class Solution2 {
	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int count = 0;
		
		for(int i = people.length -1,j = 0 ; i >= 0 && i >= j ; i--) {
			
			//selected[i] = true;
			count++;
			if(i == j) {
				return count;
			}
					
			if(people[j] + people[i] <= limit) {
				//System.out.println(people[i]+"and"+people[j]+"һ����");

				j++;
			}
			
		}
		
		return count;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data0 = {3,5,3,4};
		System.out.println(new Solution2().numRescueBoats(data0, 5));
		
		int[] data1 = {3,2,2,1};
		System.out.println(new Solution2().numRescueBoats(data1, 3));
		
		int[] data2 = {1,1,2};
		System.out.println(new Solution2().numRescueBoats(data2, 3));
		
		int[] data3 = {3,2,3,2,2};
		System.out.println(new Solution2().numRescueBoats(data3, 6));
		int[] data4 = {};
	}

}
