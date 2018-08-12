package heap.kSmallestPairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/description/
给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。

定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。

找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

示例 1:

给出： nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

返回： [1,2],[1,4],[1,6]

返回序列中的前 3 对数：
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
示例 2:

给出：nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

返回： [1,1],[1,1]

返回序列中的前 2 对数：
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
示例 3:

给出：nums1 = [1,2], nums2 = [3],  k = 3 

返回： [1,3],[2,3]

也可能序列中所有的数对都被返回:
[1,3],[2,3]
*/

public class Solution {

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		Comparator<int[]> cmp = new Comparator<int[]>()
        {
            public int compare(int[] e1,int[] e2)
            {
            	int sum1 = 0;
            	int sum2 = 0;
            	for (int i = 0; i < e1.length; i++) {
					sum1 += e1[i];
				}
            	for (int i = 0; i < e2.length; i++) {
					sum2 += e2[i];
				}
                return sum1 - sum2;
            }
        };
		
		Queue<int[]> queue = new PriorityQueue<int[]>(cmp);
		
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int[] e  = new int[2];
				e[0] = nums1[i];
				e[1] = nums2[j];
				
				queue.offer(e);
			}	
		}
		
		
		List<int[]> res = new LinkedList<int[]>();
		while(k != 0 && !queue.isEmpty()) {
			k--;
			res.add(queue.poll());
		}
			
		return res;
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		System.out.println(new Solution().kSmallestPairs(nums1, nums2, 3));
	}

}
