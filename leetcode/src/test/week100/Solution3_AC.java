package test.week100;

import java.util.Arrays;

public class Solution3_AC {
	public int subarrayBitwiseORs(int[] a) {
        int n = a.length;
        int[] next = new int[31];
        Arrays.fill(next, n);
        int[] u = new int[33*n];
        int p = 0;
        long[] t = new long[31];
		for(int i = n-1;i >= 0;i--){
			for(int j = 0;j < 31;j++){
				if(a[i]<<~j<0){
					next[j] = i;
				}
				t[j] = (long)next[j]<<32|j;
			}
			Arrays.sort(t);
			u[p++] = a[i];
			int b = 0;
			for(int j = 0;j < 31;){
				int k = j;
				if(t[j]>>>32 == n)break;
				while(k < 31 && t[k]>>>32==t[j]>>>32){
					b |= 1<<(int)t[k];
					k++;
				}
				u[p++] = b;
				j = k;
			}
		}
		Arrays.sort(u, 0, p);
		int ct = 0;
		for(int i = 0;i < p;i++){
			if(i == 0 || u[i-1] != u[i])ct++;
		}
		return ct;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
