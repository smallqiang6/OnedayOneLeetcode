package binary_search.nextGreatestLetter;


/*
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/
 */

//tips: a>b>c>d...>x>y>z>a
public class Solution {
	public char nextGreatestLetter(char[] letters, char target) {
		int n = letters.length;  
        
        int l = 0, h = n - 1;  
        while (l <= h) { 
            int m = l + (h - l) / 2;  
        	//System.out.println("l="+l+";h="+l+";m="+m);            
            if (letters[m] <= target)  
                l = m + 1;  
            else  
                h = m - 1;  
        }  
        return l < n ? letters[l] : letters[0];  //最后返回的是 l 位置的字符  
        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
