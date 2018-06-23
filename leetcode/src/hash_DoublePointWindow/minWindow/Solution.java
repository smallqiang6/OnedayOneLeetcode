package hash_DoublePointWindow.minWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * https://leetcode-cn.com/articles/longest-substring-without-repeating-characters/
 * 
 * ����һ���ַ������ҳ��������ظ��ַ�����Ӵ��ĳ��ȡ�
 * 
 * ʾ����
 * 
 * ���� "abcabcbb" ��û���ظ��ַ�����Ӵ��� "abc" ����ô���Ⱦ���3��
 * 
 * ���� "bbbbb" ������Ӵ����� "b" ��������1��
 * 
 * ���� "pwwkew" ����Ӵ��� "wke" ��������3����ע��𰸱�����һ���Ӵ���"pwke" �� ������  �������Ӵ���
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
