package trie.replaceWords;

import java.util.List;
//
//https://leetcode-cn.com/problems/replace-words/description/
//	��Ӣ���У�������һ������ �ʸ�(root)�ĸ�������Ը�������һЩ�������һ���ϳ��ĵ��ʡ������ǳ������Ϊ �̳д�(successor)�����磬�ʸ�an�������ŵ��� other(����)�������γ��µĵ��� another(��һ��)��
//
//	���ڣ�����һ�������ʸ���ɵĴʵ��һ�����ӡ�����Ҫ�������е����м̳д��ôʸ��滻��������̳д����������γ����Ĵʸ���������̵Ĵʸ��滻����
//
//	����Ҫ����滻֮��ľ��ӡ�
//
//	ʾ�� 1:
//
//	����: dict(�ʵ�) = ["cat", "bat", "rat"]
//	sentence(����) = "the cattle was rattled by the battery"
//	���: "the cat was rat by the bat"
//	ע:
//
//	����ֻ����Сд��ĸ��
//	1 <= �ֵ䵥���� <=1000
//	1 <=  ���д����� <= 1000
//	1 <= �ʸ����� <= 100
//	1 <= ���д��ﳤ�� <= 1000	


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
