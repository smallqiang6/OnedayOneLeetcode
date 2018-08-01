package trie.replaceWords;

import java.util.List;
//
//https://leetcode-cn.com/problems/replace-words/description/
//	在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
//
//	现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
//	你需要输出替换之后的句子。
//
//	示例 1:
//
//	输入: dict(词典) = ["cat", "bat", "rat"]
//	sentence(句子) = "the cattle was rattled by the battery"
//	输出: "the cat was rat by the bat"
//	注:
//
//	输入只包含小写字母。
//	1 <= 字典单词数 <=1000
//	1 <=  句中词语数 <= 1000
//	1 <= 词根长度 <= 100
//	1 <= 句中词语长度 <= 1000	


public class Solution {

	private class TrieNode {
        char val;
        TrieNode[] children;
        boolean isWord;
 
        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
	
	private TrieNode buildTrie(List<String> dict) {
        TrieNode root = new TrieNode(' ');
        for (String word : dict) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        return root;
    }
	
	private String getShortestReplacement(String token, final TrieNode root) {
        TrieNode temp = root;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : token.toCharArray()) {
            stringBuilder.append(c);
            if (temp.children[c - 'a'] != null) {
                if (temp.children[c - 'a'].isWord) {
                    return stringBuilder.toString();
                }
                temp = temp.children[c - 'a'];
            } else {
                return token;
            }
        }
        return token;
    }

	private String replaceWords(String[] tokens, TrieNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String token : tokens) {
            stringBuilder.append(getShortestReplacement(token, root));
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

	public String replaceWords(List<String> dict, String sentence) {
		String[] tokens = sentence.split(" ");
        TrieNode trie = buildTrie(dict);
        return replaceWords(tokens, trie);
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
