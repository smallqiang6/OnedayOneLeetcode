package hash.findRepeatedDnaSequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode-cn.com/problems/repeated-dna-sequences/description/
	

���� DNA ��һϵ����дΪ A��C��G �� T �ĺ�������ɣ����磺��ACGAATTCCG�������о� DNA ʱ��ʶ�� DNA �е��ظ�������ʱ����о��ǳ��а�����

��дһ������������ DNA ���������г��ֳ���һ�ε�10����ĸ�������У��Ӵ�����

ʾ��:

����: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

���: ["AAAAACCCCC", "CCCCCAAAAA"]	
*/
public class Solution {

	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> string_map = new HashMap<String, Integer>();
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String str = s.substring(i, i + 10); // substringǰ�պ�

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
