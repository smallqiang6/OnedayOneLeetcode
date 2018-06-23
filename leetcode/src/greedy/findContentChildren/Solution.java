package greedy.findContentChildren;

import java.util.Arrays;

/*
 * 
 * 
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 
 * 
ʾ�� 1:

����: [1,2,3], [1,1]

���: 1

����: 
�����������Ӻ�����С���ɣ�3�����ӵ�θ��ֵ�ֱ��ǣ�1,2,3��
��Ȼ��������С���ɣ��������ǵĳߴ綼��1����ֻ����θ��ֵ��1�ĺ������㡣
������Ӧ�����1��
ʾ�� 2:

����: [1,2], [1,2,3]

���: 2

����: 
�����������Ӻ�����С���ɣ�2�����ӵ�θ��ֵ�ֱ���1,2��
��ӵ�еı��������ͳߴ綼���������к������㡣
������Ӧ�����2.
 */
public class Solution {

	public int findContentChildren(int[] g, int[] s) {
		
		int res = 0;
		int index_g = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		
		for(int i = 0; i < s.length; i++)
		{
			if(s[i] >= g[index_g])
			{
				res++;
				index_g++;
				
				if(index_g >= g.length)
					break;
			}
		}
		
		return res;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
