package sort.largestNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/*https://leetcode-cn.com/problems/largest-number/description/

*
*
*
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

示例 1:

输入: [10,2]
输出: 210
示例 2:

输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
*
*/

public class Solution {
	
	public String largestNumber_perfect(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i<nums.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o2.compareTo(o1);
                }
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if("0".equals(strs[0])){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<strs.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }
	//
	public String largestNumber(int[] nums) {
		ArrayList <Integer> n = new ArrayList<Integer>();
		for(int i:nums) {
			n.add(i);
		}
		Collections.sort(n,new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				List<Integer> la = new ArrayList<>();
				while(a >= 10) {
					la.add(a%10);
					a = (a - a%10)/10;
				}
				la.add(a);
				Collections.reverse(la);
				
				List<Integer> lb = new ArrayList<>();
				while(b >= 10) {
					lb.add(b%10);
					b = (b - b%10)/10;
				}
				lb.add(b);
				Collections.reverse(lb);
				
				int minSize = Math.min(la.size(), lb.size());
				
				for(int i = 0,j = 0; ;i++,j++) {
					if(la.get(i) > lb.get(j)) {
						return -1;
					}else if(la.get(i) < lb.get(j)) {
						return 1;
					}
					
					if((i == la.size() - 1) && (j == lb.size() - 1)) {
						return 1;
					}else if(j == lb.size() - 1) {
						j = -1;
					}else if(i == la.size() - 1) {
						i = -1;
					}
					
				}
			}
			
		});
		//System.out.println(n);
		while(n.isEmpty() == false && n.get(0) == 0) {
			n.remove(0);
		}
		if(n.isEmpty()) {
			return "0";
		}
		StringBuilder strB = new StringBuilder();
		for(Integer i:n) {
			strB.append(i);
		}
        return strB.toString();
    }
	//32 328
	boolean compare(int a,int b) {//a>=b ?
		List<Integer> la = new ArrayList<>();
		while(a >= 10) {
			la.add(a%10);
			a = (a - a%10)/10;
		}
		la.add(a);
		Collections.reverse(la);
		
		List<Integer> lb = new ArrayList<>();
		while(b >= 10) {
			lb.add(b%10);
			b = (b - b%10)/10;
		}
		la.add(b);
		Collections.reverse(lb);
		
		//int minSize = Math.min(la.size(), lb.size());
		
		for(int i = 0,j = 0; ;i++,j++) {
			if(la.get(i) > lb.get(j)) {
				return true;
			}else if(la.get(i) < lb.get(j)) {
				return false;
			}
			
			if((i == la.size() - 1) && (j == lb.size() - 1)) {
				return true;
			}else if(j == lb.size() - 1) {
				j = -1;
			}else if(i == la.size() - 1) {
				System.out.println("aaa");
				i = -1;

			}
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution().compare(3, 30));
		int[] data = {3,30,34,5,9};
		System.out.println(new Solution().largestNumber(data));
		int[] data2 = {0,0};
		System.out.println(new Solution().largestNumber(data2));
	}

}
