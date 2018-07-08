package merge_sort.thressWays;
/*
����˼�룺
�������е�����Ԫ��������ԡ���Merge()�������������򣬹���n/2�鳤��Ϊ2������õ�������Σ�Ȼ���ٽ����Ǻϲ��ɳ���Ϊ4��������Σ���˼�����ȥ��ֱ�����������ź���

*/
public class Solution2 {
	void mergeSort(int[] a, int begin, int end) {
		int i, j, step;
		step = 0;
		while (step <= end - begin) {
			step = step * 2 + 1;
			//System.out.println("step:" + step);
			i = begin;
			j = i + step;
			while (i <= a.length - 1) {
				if (j <= a.length - 1)
					merge(a, i, j);
				else
					merge(a, i, a.length - 1);
				i = j + 1;
				j = i + step;
			}

		}
	}
	void merge(int[] a,int begin,int end) {//m = (begin + end)/2;
		System.out.println("merge from "+ begin+"to "+end);
		int i,j,k;
		i = begin;
		j = 1 + ((begin + end)>>1); 
		
		while(i <= end && j <= end && i<j) {
			while(i <= end && a[i] < a[j])  
				i++;
			k = j;//��ʱ����ָ��j��λ�� 
			while(j <= end && a[j] < a[i]) 
				j++;
			if(j > k)
				RotateRight(a , i , j-1 , j-k);   //����a[i...j-1]ѭ������j-k��
			i += (j-k+1);  //��һ��ָ�������ƶ�����Ϊѭ�����ƺ�����a[i....i+j-k]������� 
		}
	}
	
	private void RotateRight(int[] a, int begin, int end, int k) {
		// TODO Auto-generated method stub
		int len = end - begin + 1;
		k %= len;
		Reverse(a , begin , end - k);
		Reverse(a , end - k + 1 , end); 
		Reverse(a , begin , end);  
	}

	private void Reverse(int[] a, int begin, int end) {
		// TODO Auto-generated method stub
		for(; begin < end; begin++ , end--) {
			int temp = a[begin];
			a[begin] = a[end];
			a[end] = temp;
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int in[] = {49,38,65,97,76,13,27};
		int in[] = {4,8,3,7,1,5,6,2};
		new Solution2().mergeSort(in, 0, in.length -1);
		for(int i:in)
			System.out.print(i+" ");
		System.out.println();
	}

}
