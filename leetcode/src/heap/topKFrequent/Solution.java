package heap.topKFrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 */
/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

例如，

给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。

注意：

你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。



解法1: 桶排序（Bucket Sort） 时间复杂度O(n)

1. 遍历数组nums，利用字典cntDict统计各元素出现次数。
2. 遍历cntDict，利用嵌套列表freqList记录出现次数为i（ i∈[1, n] ）的所有元素
3. 逆序遍历freqList，将其中的前k个元素输出。

解法2: 哈希表 + 堆   时间复杂度O(n * log k)，其中k为独立元素的个数。

Java: Solution 1
*/



//靠谱参考：https://www.cnblogs.com/lightwindy/p/8674041.html
class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
public class Solution {

	static HashMap<Integer, Integer> map;  
	public static void main(String[] args) {  
	    int[] num = {1,1,1,2,2,3};  
	    ArrayList<Integer> nums = (ArrayList<Integer>) new Solution().topKFrequent(num,2);  
	    System.out.println(nums);  
	    
	    //int[] num2 = {-1,-1}; 
/*	    int[] num2 = {1,2};
	    ArrayList<Integer> nums = (ArrayList<Integer>) new Solution().topKFrequent(num2,2);  
	    System.out.println(nums);  */
	}  
	
	public List<Integer> topKFrequent_1(int[] nums, int k) {
	    //count the frequency for each element
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int num: nums){
	        if(map.containsKey(num)){
	            map.put(num, map.get(num)+1);
	        }else{
	            map.put(num, 1);
	        }
	    }
	  
	    //get the max frequency
	    int max = 0;
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        max = Math.max(max, entry.getValue());
	    }
	  
	    //initialize an array of ArrayList. index is frequency, value is list of numbers
	    //2. 遍历cntDict，利用嵌套列表freqList记录出现次数为i（ i∈[1, n] ）的所有元素
	    //注意：都出现x次的元素可能有很多个
	    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
	    for(int i=1; i<=max; i++){
	        arr[i]=new ArrayList<Integer>();
	    }
	  
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        int count = entry.getValue();
	        int number = entry.getKey();
	        arr[count].add(number);
	    }
	  
	    List<Integer> result = new ArrayList<Integer>();
	  
	    //add most frequent numbers to result
	    for(int j=max; j>=1; j--){
	        if(arr[j].size()>0){
	            for(int a: arr[j]){
	            	System.out.println("add one"+a+" count="+j);
	                result.add(a);
	                System.out.println(result.size()+ "k="+k);
	                //if size==k, stop
	                if(result.size() == k){
	            	    return result;
	                }
	            }
	        }
	    }
	  
	    return result;
	}
	public List<Integer> topKFrequent(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
  
        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });
  
        //maintain a heap of size k.
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }
  
        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        //reverse the order
        Collections.reverse(result);
  
        return result;
    }


}
