package hash.minWindow;
/*
 * ����һ���ַ��� S ��һ���ַ��� T������ S ���ҳ����� T ������ĸ����С�Ӵ���
 * https://leetcode-cn.com/problems/minimum-window-substring/description/
 * 
 * ����һ���ַ��� S ��һ���ַ��� T������ S ���ҳ����� T ������ĸ����С�Ӵ���
 * 
 * ʾ����
 * 
 * ����: S = "ADOBECODEBANC", T = "ABC"
 * ���: "BANC"
 * 
 * ˵����
 * 
 * ��� S �в����������Ӵ����򷵻ؿ��ַ��� ""��
 * ��� S �д����������Ӵ������Ǳ�֤����Ψһ�Ĵ𰸡�
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
		//����s
		//��ôȷ���ǲ�����С����  ��
		//��һ��������¼��ǰ�ҵ���t�еĶ��ٸ��ַ� ��˳�����s�ַ������ҵ�t�е������ַ��󣬴�ʱ�ٱ���ȥ��ͷ���ķ�t���߶�t���ַ�
		//ע�⣬��һ��ֻ�ҵ�������һ�����������ַ�������Ҫ����������
		//������ҧ�����Ӵ���һ��ͷ����˳����������s�ַ���
		
		/*��¼����Ҫ����Ӵ���λ�ã��Լ��ҵ����ַ�����*/  
        int beg = -1, end = s.length(), found = 0, minLen = s.length();  
        for (int i = 0, start = i; i < s.length(); ++i)  
        {  
            ++countS[s.charAt(i)];  
            /*���µ�ǰ�ҵ����ַ�����*/  
            if (countS[s.charAt(i)] <= countT[s.charAt(i)])  
                ++found;  
            /*�ж��Ƿ��ҵ������ַ�*/  
            if (found == t.length())  
            {  
                /*��Դ����ͷδ������Ŀ�괮���ַ�����*/  
                while (start < i && countS[s.charAt(start)] > countT[s.charAt(start)])  
                {  
                    --countS[s.charAt(start)];  
                    ++start;  
                    //System.out.println("kick "+s.charAt(start));
                }//while  
                /*�ҵ�����Ҫ���Ӵ�����βλ��start �� i*/  
                if (i - start < minLen)  
                {  
                    minLen = i - start;  
                    beg = start;  
                    end = i;  
                    //System.out.println("beg = "+beg+",end = "+i);
                }//if  
                /*�������Ӵ��Ŀ�ͷλ�ã�Ѱ����һ���Ӵ�*/  
                --countS[s.charAt(start++)];  
                --found;  
            }//if  
        }//for  
  
        /*���begֵΪ-1��˵���������������Ӵ�*/  
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
