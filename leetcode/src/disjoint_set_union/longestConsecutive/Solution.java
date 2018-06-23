package disjoint_set_union.longestConsecutive;

import java.util.HashMap;

/*
http://kickcode.iteye.com/blog/2264925
 */
/*
Longest Consecutive Sequence 
����һ��δ������������飬�ҳ�������������С�Ҫ��ʱ�临�Ӷ�ΪO(n)�� 
���磺����nums[] = {100, 4, 200, 1, 3, 2} 
�����4    �����������Ϊ��1��2��3��4�� 

�����ù�ϣ����Ԫ���Ƿ񱻷��ʹ���
Ȼ��ӵ�һ��Ԫ�ؿ�ʼ��
�ֱ��������ߵ�Ԫ�أ�
Ҳ���Ƕ������м�1�ͼ�1�Ĳ�����
����ϣ�����Ƿ���ڣ���¼���ĸ�����
��ͺ����Խڵ㹹���˼�������
ֻҪ�ҵ������ǿ������ǽ���ˡ�

*/
public class Solution {

	public int longestConsecutive(int[] nums) {  
		  
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();  
        int max = 1;  
        if(nums == null || nums.length == 0) return 0;  
        for(int i : nums) hm.put(i, 0);  
  
        for(int i = 0; i < nums.length; i++) {  
            int count = 1;   
            int left = -1;   
            int right = 1;  
            if(hm.get(nums[i]) == 1) {  
                continue;  
            }  
            hm.put(nums[i], 1);  
            while(hm.containsKey(nums[i] + left)) {  
                hm.put(nums[i] + left, 1);  
                count ++;  
                left --;  
            }  
            while(hm.containsKey(nums[i] + right)) {  
                hm.put(nums[i] + right, 1);  
                count ++;  
                right ++;  
                }  
            max = Math.max(count, max);  
        }  
        return max;  
          
    }  
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
