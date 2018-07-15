package test.week93;

import java.util.TreeMap;

public class Solution3_perfect {
	public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = A.length;
        for (int i = 0; i < n; ++i){
            if (!map.containsKey(A[i])){
                map.put(A[i], 1);
            }else{
                map.put(A[i], map.get(A[i]) + 1);
            }
        }
        int[] res = new int[n];
        for (int i = 0; i < n; ++i){
            Integer ceil = map.ceilingKey(B[i] + 1);
            if (ceil == null){
                ceil = map.firstKey();   
            }
            res[i] = ceil;  
            if (map.get(ceil) > 1){
                map.put(ceil, map.get(ceil) - 1);
            }else{
                map.remove(ceil);
            }
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
