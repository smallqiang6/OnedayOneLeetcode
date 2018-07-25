package hash.findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode-cn.com/problems/repeated-dna-sequences/description/
	

所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。

示例:

输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

输出: ["AAAAACCCCC", "CCCCCAAAAA"]	
*/
public class Solution {

	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> string_map = new HashMap<String, Integer>();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String str = s.substring(i, i + 10); // substring前闭后开

			if (!string_map.containsKey(str))
				string_map.put(str, 1);
			else {
				int count = string_map.get(str);
				string_map.put(str, count + 1);
			}
		}
		for (String key : string_map.keySet()) {
			if (string_map.get(key) > 1) {
				result.add(key);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
