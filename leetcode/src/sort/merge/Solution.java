package sort.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*https://blog.csdn.net/xygy8860/article/details/46892417
*/	
	//思路：题意很明确，首先对各区间按开始来排序，最后遍历，如果前面和后面的区间有重合，合并。
public class Solution {

	public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> list = new ArrayList<Interval>();
    	//排序，实现了Comparator接口
    	Collections.sort(intervals,new Comparator<Interval>() {
 
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;//起始值升序排序
			}
		});
 
    	if(intervals.size() == 0)
    		return list;
    	
    	Interval i1 = intervals.get(0);
    	//遍历
    	for(int i = 0; i < intervals.size(); i++){
    		Interval i2;
    		//分情况i2赋值
    		if(i == intervals.size() - 1)//如果i到最后，增加一个虚拟最大的区间
    			i2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
    		else//否则，i2最后i1后面的值
    			i2 = intervals.get(i+1);
    		//合并区间	
    		if(i2.start >= i1.start && i2.start <= i1.end){
    			i1.end = Math.max(i1.end, i2.end);
    		}else{//没有交集，直接添加
    			list.add(i1);
    			i1 = i2;//i1更迭
    		}
    	}
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
