package merge_sort.thressWays;
/*
1.      递归实现归并排序

来自 <https://blog.csdn.net/angelniu1024/article/details/8765618> 

基本思想：
将待排元素分成大小大致相同的2个子集，分别对2个子集合进行排序，最终将排好序的子集合合并 就会得到一个排好序的集合 即为所求
设归并排序的当前区间是R[low..high]，分治法的三个步骤是:
① 分解：将当前区间一分为二，即求分裂点 
② 求解：递归地对两个子区间R[low..mid]和R[mid+1..high] 进行归并排序；
③ 组合：将已排序的两个子区间R[low..mid]和R[mid+1..high] 归并为一个有序的区间R[low..high]。
递归的终结条件：子区间长度为1（一个记录自然有序）。

*/
public class Solution1 {
	void mergeSort(int[] a,int begin,int end) {
		if(begin == end) {
			return;
		}
		int m = (begin + end)/2;
		mergeSort(a,begin,m);
		mergeSort(a,m+1,end);
		merge(a,begin,end);
	}
	
	void merge(int[] a,int begin,int end) {//m = (begin + end)/2;
		int i,j,k;
		i = begin;
		j = 1 + ((begin + end)>>1); 
		
		while(i <= end && j <= end && i<j) {
			while(i <= end && a[i] < a[j])  
				i++;
			k = j;//暂时保存指针j的位置 
			while(j <= end && a[j] < a[i]) 
				j++;
			if(j > k)
				RotateRight(a , i , j-1 , j-k);   //数组a[i...j-1]循环右移j-k次
			i += (j-k+1);  //第一个指针往后移动，因为循环右移后，数组a[i....i+j-k]是有序的 
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

	

	/*//merge两个数组，新申请了一段空间
	private void merge(int[] a, int[] merge, int begin, int m, int end) {
		// TODO Auto-generated method stub
		//取左右两边数组中较小的元素放入数组b中，最后得到的数组b即为有序
		int i = begin;
		int j = m+1;
		int k = begin;
		while(i <= m && j <= end) {
			if(a[i] < a[j]) {
				merge[k++] = a[i++];
			}else {
				merge[k++] = a[i++];
			}
		}
		//
		if(i > m) {
			for(int z = j; z <= end; z++) {
				merge[k++] = a[z];
			}
		}else {
			for(int z = j; z <= m; z++) {
				merge[k++] = a[z];
			}
		}
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int in[] = {49,38,65,97,76,13,27};
		new Solution1().mergeSort(in, 0, in.length -1);
		for(int i:in)
			System.out.print(i+" ");
		System.out.println();
	}

}
