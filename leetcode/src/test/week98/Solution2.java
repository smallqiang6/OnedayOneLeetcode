package test.week98;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Solution2 {

//	890. ���Һ��滻ģʽ
//	�û�ͨ������ 82
//	�û����Դ��� 97
//	ͨ������ 83
//	�ύ���� 107
//	��Ŀ�Ѷ� Medium
//	����һ�������б� words ��һ��ģʽ  pattern������֪�� words �е���Щ������ģʽƥ�䡣
//
//	���������ĸ������ p ��ʹ�ý�ģʽ�е�ÿ����ĸ x �滻Ϊ p(x) ֮�����Ǿ͵õ�������ĵ��ʣ���ô������ģʽ��ƥ��ġ�
//
//	������һ�£���ĸ�������Ǵ���ĸ����ĸ��˫�䣺ÿ����ĸӳ�䵽��һ����ĸ��û��������ĸӳ�䵽ͬһ����ĸ����
//
//	���� words �������ģʽƥ��ĵ����б�
//
//	����԰��κ�˳�򷵻ش𰸡�
//
//	 
//
//	ʾ����
//
//	���룺words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
//	�����["mee","aqq"]
//	���ͣ�
//	"mee" ��ģʽƥ�䣬��Ϊ�������� {a -> m, b -> e, ...}��
//	"ccc" ��ģʽ��ƥ�䣬��Ϊ {a -> c, b -> c, ...} �������С�
//	��Ϊ a �� b ӳ�䵽ͬһ����ĸ��
//	 
//
//	��ʾ��
//
//	1 <= words.length <= 50
//	1 <= pattern.length = words[i].length <= 20
	
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		
		List<String> res = new LinkedList<String>();
		Map<Character, Character> map;
		for(int j = 0;j < words.length; j++) {
			String s = words[j];
			StringBuilder sBuilder = new StringBuilder(s);
			map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				if(!map.containsKey(s.charAt(i))) {
					map.put(s.charAt(i), pattern.charAt(i));
					//s = s.replace(s.charAt(i), pattern.charAt(i));
					sBuilder.replace(i, i+1, ""+pattern.charAt(i));
					//System.out.println(sBuilder);
				}else {
					sBuilder.replace(i, i+1, ""+map.get(s.charAt(i)));
				}
			}
			//System.out.println(map.keySet());
			//System.out.println(map.values());
			//System.out.println(sBuilder.toString());
			if(sBuilder.toString().equals(pattern)&&map.keySet().size() == new HashSet<>(map.values()).size()) {
				res.add(words[j]);
			}	
		}
		
		return res;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[] w = {"abc","deq","mee","aqq","dkd","ccc"};
		//String[] w = {"abc","cba"};
		String[] w = {"mee","aqq"};
		System.out.println(new Solution2().findAndReplacePattern(w, "abb"));
	}

}
