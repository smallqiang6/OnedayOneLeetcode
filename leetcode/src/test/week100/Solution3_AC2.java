package test.week100;

import java.util.HashSet;
import java.util.Set;

public class Solution3_AC2 {

	Set<Integer> ans;
    int[] tmp;

    public int subarrayBitwiseORs(int[] A) {
        ans = new HashSet<>();
        tmp = new int[A.length];
        dfs(A, 0, A.length - 1);
        return ans.size();
    }

    void dfs(int[] A, int l, int r) {
        if (l == r) {
            ans.add(A[l]);
        } else {
            int mid = (l + r) / 2, full = 0;
            dfs(A, l, mid);
            dfs(A, mid + 1, r);

            int mask = 0;
            int L = mid, R = mid + 1;
            for (int i = mid; i >= l; i--) {
                mask |= A[i];
                full |= A[i];
                if (L == mid || mask != tmp[L + 1]) {
                    tmp[L] = mask;
                    L--;
                }
            }
            mask = 0;
            for (int i = mid + 1; i <= r; i++) {
                mask |= A[i];
                full |= A[i];
                if (R == mid + 1 || mask != tmp[R - 1]) {
                    tmp[R] = mask;
                    R++;
                }
            }

            for (int i = mid; i > L; i--) {
                for (int j = mid + 1; j < R; j++) {
                    mask = tmp[i] | tmp[j];
                    ans.add(mask);
                    if (mask == full) {
                        break;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution3_AC2 sol = new Solution3_AC2();

        System.out.println(sol.subarrayBitwiseORs(new int[]{0}));
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 1, 2}));
        System.out.println(sol.subarrayBitwiseORs(new int[]{1, 2, 4}));

        int n = 50000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (int) (Math.random() * 100000);
        }
        System.out.println(sol.subarrayBitwiseORs(a));
        System.out.println(new Solution3_AC().subarrayBitwiseORs(a));

    }

}
