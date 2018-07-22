package test.week94;

import java.util.Arrays;


/*
https://leetcode-cn.com/contest/weekly-contest-94/problems/koko-eating-bananas/
	
	875. �����㽶������
	�û�ͨ������ 0
	�û����Դ��� 0
	ͨ������ 0
	�ύ���� 0
	��Ŀ�Ѷ� Medium
	����ϲ�����㽶�������� N ���㽶���� i ������ piles[i] ���㽶�������Ѿ��뿪�ˣ����� H Сʱ�������

	������Ծ��������㽶���ٶ� K ����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ���㽶�����гԵ� K �����������㽶���� K ���������Ե���ѵ������㽶��Ȼ����һСʱ�ڲ����ٳԸ�����㽶��  

	����ϲ�������ԣ�����Ȼ���ھ�������ǰ�Ե����е��㽶��

	������������ H Сʱ�ڳԵ������㽶����С�ٶ� K��K Ϊ��������

	 

	ʾ�� 1��

	����: piles = [3,6,7,11], H = 8
	���: 4
	ʾ�� 2��

	����: piles = [30,11,23,4,20], H = 5
	���: 30
	ʾ�� 3��

	����: piles = [30,11,23,4,20], H = 6
	���: 23
	 

	��ʾ��

	1 <= piles.length <= 10^4
	piles.length <= H <= 10^9
	1 <= piles[i] <= 10^9
	*/
	

public class Solution3 {

	public int minEatingSpeed(int[] piles, int H) {
		int max = 0;
		for(int i: piles) {
			max = Math.max(max, i);
		}
        int min = 0;
        return binarySearch(piles,H,min,max);
    }
	
	//������HСʱ�ڳ���  ��ÿСʱ�ܳԵ���������Сֵlow�����ֵhigh�м�ȡֵ
	//���ֲ���Ѱ�ҵ�һ��>=n�������±�  == ���һ��С��Ŀ��ֵ
	//findFirstGE
	
	//���ֲ���Ѱ�����һ��<=�������±� == ��һ������Ŀ��ֵ
	//findLastLE
	public int binarySearch(int[] piles,int H,int low,int high) {

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(mid == 0)
				return 1;
			//�������С�ٶ�
			//�ȼ�������<=H������actualTime
			int actualTime = 0;
			for(int pile:piles) {
				if(pile % mid == 0) {
					actualTime += (pile/mid);
				}else {
					actualTime += (pile/mid + 1);
				}
			}
			//����ʵ��������>= ����low high��˵
			if (actualTime <= H)//ʵ�ʻ���ʱ��С��HСʱ �� ÿСʱ�Ե�������������Сһ��    ʵ�ʻ���ʱ�����HСʱ �� ÿСʱ�Ե������������ٶ�һ��
				high = mid - 1;
			else//����low��˵������<
				low = mid + 1;
		}
//return��Զ��-1���Ǹ�   Ҫ��ͷ��β start -1   end + 1
		return high+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles1 = {3,6,7,11};
		int[] piles2 = {30,11,23,4,20};
		int[] piles3 = {30,11,23,4,20};
		System.out.println(new Solution3().minEatingSpeed(piles1, 8));
		System.out.println(new Solution3().minEatingSpeed(piles2, 5));
		System.out.println(new Solution3().minEatingSpeed(piles2, 6));
	}

}
