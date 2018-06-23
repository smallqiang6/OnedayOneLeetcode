package hash_DoublePointWindow.minWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/
 * 
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * 
 * 示例：
 * 
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
public class Solution {
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	
	public int lengthOfLongestSubstring_index(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(new Solution().lengthOfLongestSubstring("abcabcbb") == 3)
		{
			System.out.println("testcase1 pass");
		}

	}

}
