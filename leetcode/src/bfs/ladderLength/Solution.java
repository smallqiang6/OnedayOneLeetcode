package bfs.ladderLength;
/*
https://leetcode-cn.com/problems/word-ladder/description/
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/*
给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回 0。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出: 5

解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     返回它的长度 5。
示例 2:

输入:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

输出: 0

解释: endWord "cog" 不在字典中，所以无法进行转换。
*/
public class Solution {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		boolean isContainEnd = false;
		for(String s:wordList) {
			if(s.equals(endWord)) {
				isContainEnd = true;
			}
		}
		if(isContainEnd == false) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>() ;
		HashSet <String> setTransformed = new HashSet <String>();

		
		int levelCnt = 0;
		queue.add(beginWord);
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			levelCnt++;
			for(int i = 0; i < levelSize; i++){
				String s = queue.poll();
				if(s.equals(endWord)) {
					return levelCnt;//return
				}

				for(String dic:wordList) {
					if(!setTransformed.contains(dic)) {
						if(canTransform(s, dic) ) {
							queue.add(dic);
							setTransformed.add(dic);//s->dic 已经覆盖过了
						}
					}
					
				}
			}
	
		}
		
		return 0;
       
    }
	boolean canTransform(String s,String dic) {
		if(s.length() != dic.length()) {
			return false;
		}
		int diff = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != dic.charAt(i)) {
				diff++;
			}
			if(diff > 1) {
				return false;
			}
		}
		if(diff == 1) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<String>();
		for(String s:words) {
			wordList.add(s);
		}
		System.out.println(new Solution().ladderLength(beginWord, endWord, wordList));
	}

}
