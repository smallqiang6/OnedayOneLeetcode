package hash.minWindow;
/*
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 * 
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 * 
 * 示例：
 * 
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 
 * 说明：
 * 
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Solution {
	public String minWindow(String s, String t) {
		int [] countS = new int[128];
		int [] countT = new int[128];
		
		for(int i = 0; i < 128; i++)
		{
			countS[i] = 0;
			countT[i] = 0;
		}
		
		for(int i = 0; i < t.length(); i++)
		{
			countT[t.charAt(i)]++;
		}
		//遍历s
		//怎么确认是不是最小的呢  ？
		//用一个变量记录当前找到了t中的多少个字符 ，顺序遍历s字符串，找到t中的所有字符后，此时再遍历去掉头部的非t或者多t的字符
		//注意，上一步只找到了其中一个这样的子字符串，还要继续遍历完
		//接下来咬掉该子串的一个头，再顺序遍历后面的s字符串
		
		/*记录符合要求的子串的位置，以及找到的字符个数*/  
        int beg = -1, end = s.length(), found = 0, minLen = s.length();  
        for (int i = 0, start = i; i < s.length(); ++i)  
        {  
            ++countS[s.charAt(i)];  
            /*更新当前找到的字符个数*/  
            if (countS[s.charAt(i)] <= countT[s.charAt(i)])  
                ++found;  
            /*判断是否找到所有字符*/  
            if (found == t.length())  
            {  
                /*将源串开头未出现在目标串的字符跳过*/  
                while (start < i && countS[s.charAt(start)] > countT[s.charAt(start)])  
                {  
                    --countS[s.charAt(start)];  
                    ++start;  
                    //System.out.println("kick "+s.charAt(start));
                }//while  
                /*找到符合要求子串的首尾位置start 与 i*/  
                if (i - start < minLen)  
                {  
                    minLen = i - start;  
                    beg = start;  
                    end = i;  
                    //System.out.println("beg = "+beg+",end = "+i);
                }//if  
                /*跳过该子串的开头位置，寻找下一个子串*/  
                --countS[s.charAt(start++)];  
                --found;  
            }//if  
        }//for  
  
        /*如果beg值为-1，说明不存在这样的子串*/  
        if (beg == -1)  
            return "";  
        else  
            return s.substring(beg, end+1);  
		
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new Solution().minWindow("ADOBECODEBANC","ABC");
		if(s.equals("BANC"))
		{
			System.out.println("testcase1 pass");
		}

	}

}
