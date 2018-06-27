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
			//��ȵ����Ҫ�����Ƿ���������ͬ��Ԫ�أ��Ƿ����ظ�Ԫ�ء�
			for(int i = 0; i < A.length()-1; i++){  
	            if(A.indexOf(A.charAt(i), i+1) != -1){  
	                return true;//���ظ�Ԫ��  
	            }  
	        } 
			return false;
		}else {
			//����ȵ����,
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
	/*����������Сд��ĸ���ɵ��ַ��� A �� B ��ֻҪ���ǿ���ͨ������ A �е�������ĸ�õ��� B ��ȵĽ�����ͷ��� true �����򷵻� false ��

	ʾ�� 1��

	���룺 A = "ab", B = "ba"
	����� true
	ʾ�� 2��

	���룺 A = "ab", B = "ab"
	����� false
	ʾ�� 3:

	���룺 A = "aa", B = "aa"
	����� true
	ʾ�� 4��

	���룺 A = "aaaaaaabc", B = "aaaaaaacb"
	����� true
	ʾ�� 5��

	���룺 A = "", B = "aa"
	����� false*/
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
