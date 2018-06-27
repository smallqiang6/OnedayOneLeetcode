package test.week90;




public class Solution_buddyStrings {

	public boolean buddyStrings(String A, String B) {
		if(A == "" || B == "") {
			return false;
		}
		if(A.length() != B.length()) {
			return false;
		}
		if(A.length() <= 1) {
			return false;
		}
		
		int data [] = new int[2];
		int count = 0;
		for(int i = 0; i < A.length(); i++){  
			if(0 != A.charAt(i) - B.charAt(i)) {
				if(count >= 2) {
					return false;
				}	
				data[count++] = A.charAt(i) - B.charAt(i);
				
			}
		}
		if(0 == count) {
			//相等的情况要考虑是否有两个相同的元素，是否有重复元素。
			for(int i = 0; i < A.length()-1; i++){  
	            if(A.indexOf(A.charAt(i), i+1) != -1){  
	                return true;//有重复元素  
	            }  
	        } 
			return false;
		}else {
			//不相等的情况,
			if(count != 2) {
				return false;
			}
			if(data[0] + data[1] != 0)
			{
				return false;
			}
		}
		
		return true;
        
    }
	/*给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。

	示例 1：

	输入： A = "ab", B = "ba"
	输出： true
	示例 2：

	输入： A = "ab", B = "ab"
	输出： false
	示例 3:

	输入： A = "aa", B = "aa"
	输出： true
	示例 4：

	输入： A = "aaaaaaabc", B = "aaaaaaacb"
	输出： true
	示例 5：

	输入： A = "", B = "aa"
	输出： false*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(true == new Solution_buddyStrings().buddyStrings("ab", "ba")) {
			System.out.println("testcase1 pass");
		}
		if(false == new Solution_buddyStrings().buddyStrings("ab", "ab")) {
			System.out.println("testcase2 pass");
		}
		if(true == new Solution_buddyStrings().buddyStrings("aa", "aa")) {
			System.out.println("testcase3 pass");
		}
		if(true == new Solution_buddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb")) {
			System.out.println("testcase4 pass");
		}
		if(false == new Solution_buddyStrings().buddyStrings("", "aa")) {
			System.out.println("testcase5 pass");
		}
	}

}
