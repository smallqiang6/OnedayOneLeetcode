package back_track.subsets;
//https://leetcode-cn.com/problems/subsets/description/
//靠谱参考：https://blog.csdn.net/mine_song/article/details/69731168
/*
当前层的集合 = 上一层的集合 + 上一层的集合加入当前层处理的元素得到的所有集合（其中树根是空集），因此可以从第二层开始（第一层是空集合）迭代地求最后一层的所有集合（即叶子节点）
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> tmp = new ArrayList<>();  
        // 排序可以避免重复，然后结果可以安装顺序输出  
        // Arrays.sort(nums);//此题不需要排序  
        dfsCore2(res, 0, tmp, nums);  
        System.out.println(res);  
        return res;  
    }  
  
	
    private void dfsCore(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {  
        if (curIdx <= nums.length) {  
            res.add(new ArrayList<Integer>(tmp));  
        }  
        // 下标从curIdx开始  
        for (int i = curIdx; i < nums.length; i++) {  
            tmp.add(nums[i]);  
            dfsCore(res, i + 1, tmp, nums);  
            tmp.remove(tmp.size() - 1);  
        }  
  
    }  
    
    private void dfsCore2(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {  
        // 注意退出条件的不同  
        if (curIdx == nums.length) {  
            res.add(new ArrayList<Integer>(tmp));  
            return;  
        }  
        // 不加入nums[curIdx]  
        dfsCore2(res, curIdx + 1, tmp, nums);  
        // 加入nums[curIdx]  
        tmp.add(nums[curIdx]);  
        dfsCore2(res, curIdx + 1, tmp, nums);  
        // 回溯  
        tmp.remove(tmp.size() - 1);  
  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {1,2,3};
		new Solution().subsets(data);
		
	}

}
