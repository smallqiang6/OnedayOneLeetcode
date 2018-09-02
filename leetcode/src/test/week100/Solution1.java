package test.week100;

/*https://leetcode-cn.com/contest/weekly-contest-100/problems/monotonic-array/

	896. 单调数列
	用户通过次数 109
	用户尝试次数 153
	通过次数 113
	提交次数 219
	题目难度 Easy
	如果数组是单调递增或单调递减的，那么它是单调的。

	如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。

	当给定的数组 A 是单调数组时返回 true，否则返回 false。

	 

	示例 1：

	输入：[1,2,2,3]
	输出：true
	示例 2：

	输入：[6,5,4,4]
	输出：true
	示例 3：

	输入：[1,3,2]
	输出：false
	示例 4：

	输入：[1,2,4,5]
	输出：true
	示例 5：

	输入：[1,1,1]
	输出：true
	 

	提示：

	1 <= A.length <= 50000
	-100000 <= A[i] <= 100000
	*/
public class Solution1 {
	public boolean isMonotonic(int[] A) {
        int head = A[0];
        int flag = 0;//递增还是递减 还是相等
        
        for (int i = 0; i < A.length; i++) {
			int curGap = A[i] - head;
			//
			if( (curGap > 0 && flag < 0) || (curGap < 0 && flag > 0) ) {
				return false;
			}
			flag = (curGap == 0 ? flag:curGap);
			head = A[i];
		}
        return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test1 = {6,5,4,4};
		System.out.println(new Solution1().isMonotonic(test1));
	}

}
