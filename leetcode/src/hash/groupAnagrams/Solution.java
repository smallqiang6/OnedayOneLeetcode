package hash.groupAnagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
https://leetcode-cn.com/problems/group-anagrams/description/\
	
	给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

	示例:

	输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
	输出:
	[
	  ["ate","eat","tea"],
	  ["nat","tan"],
	  ["bat"]
	]
	说明：

	所有输入均为小写字母。
	不考虑答案输出的顺序。

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
