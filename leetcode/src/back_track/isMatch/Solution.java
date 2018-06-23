package back_track.isMatch;

public class Solution {

	public static boolean match(String pattern, String str) {
        if (pattern == null || str == null)
            return false;
 
        boolean result = false;
        char c; // ��ǰҪƥ����ַ���
        boolean beforeStar = false; // �Ƿ�����ͨ���*
        int back_i = 0;// ����,������ͨ���ʱ,ƥ�䲻�ɹ������
        int back_j = 0;
        int i, j;
        for (i = 0, j = 0; i < str.length();) {
            if (pattern.length() <= j) {
                if (back_i != 0) {// ��ͨ���,����ƥ��δ�ɹ�,����
                    beforeStar = true;
                    i = back_i;
                    j = back_j;
                    back_i = 0;
                    back_j = 0;
                    continue;
                }
                break;
            }
 
            if ((c = pattern.charAt(j)) == '*') {
                if (j == pattern.length() - 1) {// ͨ����Ѿ���ĩβ,����true
                    result = true;
                    break;
                }
                beforeStar = true;
                j++;
                continue;
            }
 
            if (beforeStar) {
                if (str.charAt(i) == c) {
                    beforeStar = false;
                    back_i = i + 1;
                    back_j = j;
                    j++;
                }
            } else {
                if (c != '?' && c != str.charAt(i)) {
                    result = false;
                    if (back_i != 0) {// ��ͨ���,����ƥ��δ�ɹ�,����
                        beforeStar = true;
                        i = back_i;
                        j = back_j;
                        back_i = 0;
                        back_j = 0;
                        continue;
                    }
                    break;
                }
                j++;
            }
            i++;
        }
 
        if (i == str.length() && j == pattern.length())// ȫ���������
            result = true;
        return result;
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
