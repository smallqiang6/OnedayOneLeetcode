package heap.frequencySort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;


import java.util.PriorityQueue;
import java.util.Queue;

/*https://leetcode-cn.com/problems/sort-characters-by-frequency/description/
	����:
		"tree"

		���:
		"eert"

		����:
		'e'�������Σ�'r'��'t'��ֻ����һ�Ρ�
		���'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
		ʾ�� 2:

		����:
		"cccaaa"

		���:
		"cccaaa"

		����:
		'c'��'a'���������Ρ����⣬"aaaccc"Ҳ����Ч�Ĵ𰸡�
		ע��"cacaca"�ǲ���ȷ�ģ���Ϊ��ͬ����ĸ�������һ��
		ʾ�� 3:

		����:
		"Aabb"

		���:
		"bbAa"

		����:
		���⣬"bbaA"Ҳ��һ����Ч�Ĵ𰸣���"Aabb"�ǲ���ȷ�ġ�
		ע��'A'��'a'����Ϊ�����ֲ�ͬ���ַ���
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
