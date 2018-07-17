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
�����������ʣ�beginWord �� endWord����һ���ֵ䣬�ҵ��� beginWord �� endWord �����ת�����еĳ��ȡ�ת������ѭ���¹���

ÿ��ת��ֻ�ܸı�һ����ĸ��
ת�������е��м䵥�ʱ������ֵ��еĵ��ʡ�
˵��:

���������������ת�����У����� 0��
���е��ʾ�����ͬ�ĳ��ȡ�
���е���ֻ��Сд��ĸ��ɡ�
�ֵ��в������ظ��ĵ��ʡ�
����Լ��� beginWord �� endWord �Ƿǿյģ��Ҷ��߲���ͬ��
ʾ�� 1:

����:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

���: 5

����: һ�����ת�������� "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     �������ĳ��� 5��
ʾ�� 2:

����:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

���: 0

����: endWord "cog" �����ֵ��У������޷�����ת����
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
							setTransformed.add(dic);//s->dic �Ѿ����ǹ���
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
