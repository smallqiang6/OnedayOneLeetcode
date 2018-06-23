package greedy.monotoneIncreasingDigits;

/*
 * https://www.cnblogs.com/grandyang/p/8068326.html
 */

/*
���ǿ��Է��ֹ���:
Ҫ�ҵ��Ӻ���ǰ���������һ��ֵ���ߵ�λ�ã���ǰһλ��1�����ѵ�ǰλ�Լ����������λ�����9���Ϳ��Եõ����ĵ�������������
 */

public class Solution {
	public int monotoneIncreasingDigits(int N) {
		String string = Integer.toString(N);
		char str [] = string.toCharArray();
        int n = str.length, j = n;
        for (int i = n - 1; i > 0; --i) {
            if (str[i] >= str[i-1]) 
            	continue;
            str[i-1]--;
            j = i;
        }        
        for (int i = j; i < n; ++i) {
            str[i] = '9';
        }
        return Integer.parseInt(new String(str));
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
 * ʾ�� 1:

����: N = 10
���: 9
ʾ�� 2:

����: N = 1234
���: 1234
ʾ�� 3:

����: N = 332
���: 299
 */
		if( 299 == new Solution().monotoneIncreasingDigits(332))
		{
			System.out.println("testcase1 pass");
		}

	}

}
