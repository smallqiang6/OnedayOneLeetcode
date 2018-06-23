package back_track.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
/*
 * 思路：合法的情况是，任意一时刻，左（“(”）括号数要大于等于右（")"）括号数。关键在于题中只给了括号的对数，没有形象的左右括号字符，如何在脑海中转过弯去解题。故，在某次的调用中，

1）left大于right（left和right分别表示剩余左右括号的个数），即，临时变量中右括号的数大于左括号的数，则说明出现了“)(”，这是非法情况，返回即可；

2）left和right都等于0说明，临时变量中左右括号数相等，所以将临时变量中的值存入res中；

3）其余的情况是，先放左括号，然后放右括号，然后递归。注意参数的更新。
 */


/*
 * 靠谱参考：https://www.cnblogs.com/love-yh/p/7159404.html
 */

public class Solution {
	
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		generateDFS(n,n,"",res);
		return res;
    }
	
	/*left、right分别是左右括号剩下的括号数*/
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
