package test.week98;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Solution2 {

//	890. 查找和替换模式
//	用户通过次数 82
//	用户尝试次数 97
//	通过次数 83
//	提交次数 107
//	题目难度 Medium
//	你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
//
//	如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
//
//	（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
//
//	返回 words 中与给定模式匹配的单词列表。
//
//	你可以按任何顺序返回答案。
//
//	 
//
//	示例：
//
//	输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//	输出：["mee","aqq"]
//	解释：
//	"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
//	"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
//	因为 a 和 b 映射到同一个字母。
//	 
//
//	提示：
//
//	1 <= words.length <= 50
//	1 <= pattern.length = words[i].length <= 20
	
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		
		List<String> res = new LinkedList<String>();
		Map<Character, Character> map;
		for(int j = 0;j < words.length; j++) {
			String s = words[j];
			StringBuilder sBuilder = new StringBuilder(s);
			map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if(!map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), pattern.charAt(i));
					//s = s.replace(s.charAt(i), pattern.charAt(i));
					sBuilder.replace(i, i+1, ""+pattern.charAt(i));
					//System.out.println(sBuilder);
				}else {
					sBuilder.replace(i, i+1, ""+map.get(s.charAt(i)));
				}
			}
			//System.out.println(map.keySet());
			//System.out.println(map.values());
			//System.out.println(sBuilder.toString());
			if(sBuilder.toString().equals(pattern)&&map.keySet().size() == new HashSet<>(map.values()).size()) {
				res.add(words[j]);
			}	
		}
		
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] w = {"abc","deq","mee","aqq","dkd","ccc"};
		//String[] w = {"abc","cba"};
		String[] w = {"mee","aqq"};
		System.out.println(new Solution2().findAndReplacePattern(w, "abb"));
	}

}
