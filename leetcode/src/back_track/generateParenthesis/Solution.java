package back_track.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
/*
 * ˼·���Ϸ�������ǣ�����һʱ�̣��󣨡�(����������Ҫ���ڵ����ң�")"�����������ؼ���������ֻ�������ŵĶ�����û����������������ַ���������Ժ���ת����ȥ���⡣�ʣ���ĳ�εĵ����У�

1��left����right��left��right�ֱ��ʾʣ���������ŵĸ�������������ʱ�����������ŵ������������ŵ�������˵�������ˡ�)(�������ǷǷ���������ؼ��ɣ�

2��left��right������0˵������ʱ������������������ȣ����Խ���ʱ�����е�ֵ����res�У�

3�����������ǣ��ȷ������ţ�Ȼ��������ţ�Ȼ��ݹ顣ע������ĸ��¡�
 */


/*
 * ���ײο���https://www.cnblogs.com/love-yh/p/7159404.html
 */

public class Solution {
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		generateDFS(n,n,"",res);
		return res;
    }
	
	/*left��right�ֱ�����������ʣ�µ�������*/
	void generateDFS(int left,int right,String temp,List<String> res)
	{
		if(left > right) 
			return;
		
		if(left == 0 && right == 0)
		{
			res.add(temp);
		}else
		{
			if(left > 0)
			{
				generateDFS(left-1,right,temp+'(',res);
			}
			
			if(right > 0)
			{
				generateDFS(left,right-1,temp+')',res);
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> res = new Solution().generateParenthesis(3);
		for(String s: res)
		{
			System.out.println(s);
		}

	}

}
