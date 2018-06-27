package back_track.subsets;
//https://leetcode-cn.com/problems/subsets/description/
//���ײο���https://blog.csdn.net/mine_song/article/details/69731168
/*
��ǰ��ļ��� = ��һ��ļ��� + ��һ��ļ��ϼ��뵱ǰ�㴦���Ԫ�صõ������м��ϣ����������ǿռ�������˿��Դӵڶ��㿪ʼ����һ���ǿռ��ϣ������������һ������м��ϣ���Ҷ�ӽڵ㣩
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<List<Integer>> subsets(int[] nums) {  
        List<List<Integer>> res = new ArrayList<List<Integer>>();  
        List<Integer> tmp = new ArrayList<>();  
        // ������Ա����ظ���Ȼ�������԰�װ˳�����  
        // Arrays.sort(nums);//���ⲻ��Ҫ����  
        dfsCore2(res, 0, tmp, nums);  
        System.out.println(res);  
        return res;  
    }  
  
	
    private void dfsCore(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {  
        if (curIdx <= nums.length) {  
            res.add(new ArrayList<Integer>(tmp));  
        }  
        // �±��curIdx��ʼ  
        for (int i = curIdx; i < nums.length; i++) {  
            tmp.add(nums[i]);  
            dfsCore(res, i + 1, tmp, nums);  
            tmp.remove(tmp.size() - 1);  
        }  
  
    }  
    
    private void dfsCore2(List<List<Integer>> res, int curIdx, List<Integer> tmp, int[] nums) {  
        // ע���˳������Ĳ�ͬ  
        if (curIdx == nums.length) {  
            res.add(new ArrayList<Integer>(tmp));  
            return;  
        }  
        // ������nums[curIdx]  
        dfsCore2(res, curIdx + 1, tmp, nums);  
        // ����nums[curIdx]  
        tmp.add(nums[curIdx]);  
        dfsCore2(res, curIdx + 1, tmp, nums);  
        // ����  
        tmp.remove(tmp.size() - 1);  
  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {1,2,3};
		new Solution().subsets(data);
		
	}

}
