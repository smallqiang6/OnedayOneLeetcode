package heap.frequencySort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;


import java.util.PriorityQueue;
import java.util.Queue;

/*https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
	输入:
		"tree"

		输出:
		"eert"

		解释:
		'e'出现两次，'r'和't'都只出现一次。
		因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
		示例 2:

		输入:
		"cccaaa"

		输出:
		"cccaaa"

		解释:
		'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
		注意"cacaca"是不正确的，因为相同的字母必须放在一起。
		示例 3:

		输入:
		"Aabb"

		输出:
		"bbAa"

		解释:
		此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
		注意'A'和'a'被认为是两种不同的字符。
	*/
	
public class Solution {

	class Pair{
		Character character;
		int count;
		public Pair(Character c, int cnt) {
			character = c;
			count = cnt;
		}
	}
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		Comparator<Pair> cmp = new Comparator<Pair>()
        {
            public int compare(Pair p1,Pair p2)
            {
                return p2.count - p1.count;
            }
        };
		
		Queue<Pair> queue = new PriorityQueue<Pair>(cmp);
		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		for(Character key:map.keySet())
        {
			queue.offer(new Pair(key,map.get(key)));
        }
		
		StringBuilder res = new StringBuilder();
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < p.count; i++) {
				res.append(p.character);
			}
		}

		return res.toString();
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().frequencySort("Aabb"));
	}

}
