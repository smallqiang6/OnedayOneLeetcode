package hash.groupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
https://leetcode-cn.com/problems/group-anagrams/description/\
	
	����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

	ʾ��:

	����: ["eat", "tea", "tan", "ate", "nat", "bat"],
	���:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	˵����

	���������ΪСд��ĸ��
	�����Ǵ������˳��

*/


public class Solution {

	public List<List<String>> groupAnagrams(String[] strs) {
		
		Map<List<Character>, List<String>> map = new HashMap<List<Character>, List<String>>();
		
		for(String s:strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			
			List<Character> list = new LinkedList<Character>();
			for(char c: chars) {
				list.add(c);
			}
			if(!map.containsKey(list)) {
				List<String> ls = new LinkedList<String>();
				map.put(list, ls);
			}
			map.get(list).add(s);
		}
		
		List<List<String>> res = new LinkedList<List<String>>(map.values());
		
		return res;
        
    }
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(new Solution().groupAnagrams(strs));
	}
}
