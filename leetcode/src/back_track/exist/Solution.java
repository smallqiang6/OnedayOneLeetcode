package back_track.exist;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/word-search/description/
	����һ����ά�����һ�����ʣ��ҳ��õ����Ƿ�����������С�

	���ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ����С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�

	ʾ��:

	board =
	[
	  ['A','B','C','E'],
	  ['S','F','C','S'],
	  ['A','D','E','E']
	]

	���� word = "ABCCED", ���� true.
	���� word = "SEE", ���� true.
	���� word = "ABCB", ���� false.	
	
*/

public class Solution {
	int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };// r c
	/*boolean[][] Used;
	public void initUsed() {
		for (int i = 0; i < Used[0].length; i++) {// һ���м�����
			for (int j = 0; j < Used.length; j++) {// ������
				Used[j][i] = false;
			}
		}
	}
	public void arrayCopy(boolean[][] used, boolean[][] curr) {
		for (int i = 0; i < used[0].length; i++) {// һ���м�����
			for (int j = 0; j < used.length; j++) {// ������
				curr[j][i] = used[j][i] ;
			}
		}
	}*/
	public boolean exist(char[][] board, String word) {
		//Used = new boolean[board.length][board[0].length];
		boolean isExist = false;
		
		for (int i = 0; i < board[0].length; i++) {// һ���м�����
			for (int j = 0; j < board.length; j++) {// ������
				//initUsed();
				isExist = search(word.toCharArray(), 0, board, j, i);
				if (isExist) {
					return true;
				}
			}
		}

		return false;

	}

	public boolean search(char[] word, int w, char[][] board, int r, int c) {
		char pre ;
		if (board[r][c] == word[w]) {
			pre = board[r][c];
			board[r][c] = ' ';
			w++;
			if (word.length == w) {
				return true;
			}
		} else {
			return false;
		}

		for (int i = 0; i < direction.length; i++) {
			int tempR = r + direction[i][0];
			int tempC = c + direction[i][1];

			// �߽��ж�
			if (tempR >= board.length || tempC >= board[0].length || tempR < 0 || tempC < 0 ) {
				continue;
			}

			if (search(word, w, board, tempR, tempC)) {
				return true;
			}

		}
		board[r][c] = pre;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'},
		};
		char[][] board2 = {
				{'A','A','A','A'},
				{'A','A','A','A'},
				{'A','A','A','A'},
		};
		char[][] board3 = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'},
		};
		
		System.out.println(new Solution().exist(board, "ABCCED"));
		System.out.println(new Solution().exist(board3, "ABCESEEEFS"));
		System.out.println(new Solution().exist(board, "ABCB"));
		System.out.println(new Solution().exist(board2, "AAAAAAAAAAAAA"));
	}

}
