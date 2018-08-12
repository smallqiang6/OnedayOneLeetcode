package test.week97;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution1 {
	
	public String[] uncommonFromSentences(String A, String B) {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		
		for(String s: A.split(" ")) {
			if(map1.containsKey(s)) {
				map1.put(s, map1.get(s)+1);
			}else {
				map1.put(s, 1);
			}
		}
		for(String s: B.split(" ")) {
			if(map2.containsKey(s)) {
				map2.put(s, map2.get(s)+1);
			}else {
				map2.put(s, 1);
			}
		}
		
		List<String> res = new ArrayList<String>();
		for(String s: A.split(" ")) {
			if(!map2.containsKey(s) && map1.get(s) == 1) {
				res.add(s);
			}
		}
		for(String s: B.split(" ")) {
			if(!map1.containsKey(s) && map2.get(s) == 1) {
				res.add(s);
			}
		}
		String[] temp = new String[res.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = res.get(i);
		}
		return temp;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new Solution1().uncommonFromSentences("this apple is sweet", "this apple is sour"));
	}

}
