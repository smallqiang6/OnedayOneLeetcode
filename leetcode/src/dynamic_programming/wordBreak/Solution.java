package dynamic_programming.wordBreak;
//

//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
//
//说明：
//
//拆分时可以重复使用字典中的单词。
//你可以假设字典中没有重复的单词。
//示例 1：
//
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
//示例 2：
//
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
//示例 3：
//
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false

import java.util.Arrays;
import java.util.List;

public class Solution {

	public boolean wordBreak(String s, List<String> wordDict) {
		// System.out.println("wordb:" + s);
		boolean res = false;
		if (wordDict.contains(s)) {
			return true;
		}
		for (int i = 1; i < s.length(); i++) {

			String pre = s.substring(0, i);
			
			System.out.println(pre);
			if (wordDict.contains(pre)) {
				res = wordBreak(s.substring(i), wordDict);
				if (res == true) {
					break;
				}
			}
		}
		return res;
	}
//
//	https://blog.csdn.net/linhuanmars/article/details/22358863
//		
	public boolean wordBreakDemo(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		boolean[] res = new boolean[s.length() + 1];
		res[0] = true;
		for (int i = 0; i < s.length(); i++) {
			StringBuilder str = new StringBuilder(s.substring(0, i + 1));
			for (int j = 0; j <= i; j++) {
				if (res[j] && wordDict.contains(str.toString())) {
					res[i + 1] = true;
					break;
				}
				str.deleteCharAt(0);
			}
		}

		return res[s.length()];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] wordDict1 = { "leet", "code" };
		String[] wordDict2 = { "apple", "pen" };
		String[] wordDict3 = { "cats", "dog", "sand", "and", "cat" };
		String l = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String[] wordDict4 = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		System.out.println(new Solution().wordBreak("leetcode", Arrays.asList(wordDict1)));
		System.out.println(new Solution().wordBreak("applepenapple", Arrays.asList(wordDict2)));
		System.out.println(new Solution().wordBreak("catsandog", Arrays.asList(wordDict3)));
		//System.out.println(new Solution().wordBreak(l, Arrays.asList(wordDict4)));

		System.out.println(new Solution().wordBreakDemo("leetcode", Arrays.asList(wordDict1)));
		System.out.println(new Solution().wordBreakDemo("applepenapple", Arrays.asList(wordDict2)));
		System.out.println(new Solution().wordBreakDemo("catsandog", Arrays.asList(wordDict3)));
		System.out.println(new Solution().wordBreakDemo(l, Arrays.asList(wordDict4)));
	}

}
