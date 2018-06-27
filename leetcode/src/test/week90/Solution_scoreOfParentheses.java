package test.week90;

/*
https://leetcode-cn.com/contest/weekly-contest-90/problems/score-of-parentheses/
	
����һ��ƽ�������ַ��� S�����������������ַ����ķ�����

() �� 1 �֡�
AB �� A + B �֣����� A �� B ��ƽ�������ַ�����
(A) �� 2 * A �֣����� A ��ƽ�������ַ�����

ʾ�� 1��

���룺 "()"
����� 1
ʾ�� 2��

���룺 "(())"
����� 2
ʾ�� 3��

���룺 "()()"
����� 2
ʾ�� 4��

���룺 "(()(()))"
����� 6
*/	
public class Solution_scoreOfParentheses {

	public int scoreOfParentheses(String S) {
		if (S.length() == 0)
			return 0;
		if (S.charAt(0) == '(' && S.charAt(1) == ')') {
			return 1 + scoreOfParentheses(S.substring(2));
		}
		int d = 0;
		int end = -1;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == '(')
				d++;
			else
				d--;
			if (d == 0) {
				end = i + 1;
				break;
			}
		}
		return 2 * scoreOfParentheses(S.substring(1, end - 1)) + scoreOfParentheses(S.substring(end));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
