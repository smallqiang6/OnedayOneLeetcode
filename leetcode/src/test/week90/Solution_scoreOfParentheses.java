package test.week90;

/*
https://leetcode-cn.com/contest/weekly-contest-90/problems/score-of-parentheses/
	
给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：

() 得 1 分。
AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
(A) 得 2 * A 分，其中 A 是平衡括号字符串。

示例 1：

输入： "()"
输出： 1
示例 2：

输入： "(())"
输出： 2
示例 3：

输入： "()()"
输出： 2
示例 4：

输入： "(()(()))"
输出： 6
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
