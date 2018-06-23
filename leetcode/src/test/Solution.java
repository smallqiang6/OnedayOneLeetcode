package test;

/*
 * https://leetcode-cn.com/contest/weekly-contest-87/problems/backspace-string-compare/
 */
public class Solution {

	public boolean backspaceCompare(String S, String T) {
		char trimS[] = new char[256];
		int indexS = 0;
		char trimT[] = new char[256];
		int indexT = 0;
		for(int i = 0; i < S.length(); i++)
		{
			if(S.charAt(i) == '#')
			{
				indexS = indexS - 1 < 0 ? 0:indexS-1;
			}else {
				trimS[indexS] = S.charAt(i);
				indexS++;
			}
		}
		for(int i = 0; i < T.length(); i++)
		{
			if(T.charAt(i) == '#')
			{
				indexT = indexT - 1 < 0 ? 0:indexT-1;
			}else {
				trimT[indexT] = T.charAt(i);
				indexT++;
			}
		}
		//System.out.println("indexT = "+indexT+"    indexS = "+ indexS);
		if(indexT != indexS)
		{
			return false;
		}else {
			for(int i = 0; i < indexT; i++)
			{
				//System.out.println("trimS = "+trimS[i] +"  trimT = "+trimT[i]);
				if(trimS[i] != trimT[i])
				{
					return false;
				}
			}
			return true;
		}
		
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(true == new Solution().backspaceCompare("ab#c", "ad#c"))
		{
			System.out.println("test case1 pass");
		}
		if(true == new Solution().backspaceCompare("ab##", "c#d#"))
		{
			System.out.println("test case2 pass");
		}
		if(true == new Solution().backspaceCompare("a##c", "#a#c"))
		{
			System.out.println("test case3 pass");
		}
		if(false == new Solution().backspaceCompare("a#c", "b"))
		{
			System.out.println("test case4 pass");
		}

	}

}
