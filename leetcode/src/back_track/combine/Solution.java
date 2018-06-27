package back_track.combine;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> combine(int n, int k) {  
        List<List<Integer>> ret = new ArrayList<>();  
        List<Integer> tmp = new ArrayList<>();  
        combineCore(n, k, ret, tmp, 1);  
        System.out.println(ret);  
        return ret;  
  
    }  
  
    private void combineCore(int n, int k, List<List<Integer>> ret, List<Integer> tmp, int idx) {  
        // 求指定数目组合  
        // 用k判断而非idx  
        if (k <= 0) {  
            ret.add(new ArrayList<>(tmp));  
            return;  
        }  
        for (int i = idx; i <= n; i++) {  
            tmp.add(i);  
            // 传入i+1非重复  
            combineCore(n, k - 1, ret, tmp, i + 1);  
            tmp.remove(tmp.size() - 1);  
        }  
    }  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().combine(4, 2);

	}

}
