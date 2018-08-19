package test.week98;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class Solution1 {

//	888. 公平的糖果交换
//	用户通过次数 0
//	用户尝试次数 0
//	通过次数 0
//	提交次数 0
//	题目难度 Easy
//	爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
//
//	因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//
//	返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
//
//	如果有多个答案，你可以返回其中任何一个。保证答案存在。
//
//	 
//
//	示例 1：
//
//	输入：A = [1,1], B = [2,2]    2  4
//	输出：[1,2]
//	示例 2：
//
//	输入：A = [1,2], B = [2,3]   3  5
//	输出：[1,2]
//	示例 3：
//
//	输入：A = [2], B = [1,3]   2  4 
//	输出：[2,3]
//	示例 4：
//
//	输入：A = [1,2,5], B = [2,4]  8   6 
//	输出：[5,4]
//	 
//
//	提示：
//
//	1 <= A.length <= 10000
//	1 <= B.length <= 10000
//	1 <= A[i] <= 100000
//	1 <= B[i] <= 100000
//	保证爱丽丝与鲍勃的糖果总量不同。
//	答案肯定存在。
	
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
			//A要找一个比它小gap的元素互换
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
//		输入：A = [1,2,5], B = [2,4]  8   6 
//		输出：[5,4]
		int[] A = {1,2,5};
		int[] B = {2,4};
		int[] res = new Solution1().fairCandySwap(A, B);
		System.out.println(res[0]+" "+ res[1]);
	}

}
