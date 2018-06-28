package sort.merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*https://blog.csdn.net/xygy8860/article/details/46892417
*/	
	//˼·���������ȷ�����ȶԸ����䰴��ʼ�����������������ǰ��ͺ�����������غϣ��ϲ���
public class Solution {

	public List<Interval> merge(List<Interval> intervals) {
    	List<Interval> list = new ArrayList<Interval>();
    	//����ʵ����Comparator�ӿ�
    	Collections.sort(intervals,new Comparator<Interval>() {
 
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;//��ʼֵ��������
			}
		});
 
    	if(intervals.size() == 0)
    		return list;
    	
    	Interval i1 = intervals.get(0);
    	//����
    	for(int i = 0; i < intervals.size(); i++){
    		Interval i2;
    		//�����i2��ֵ
    		if(i == intervals.size() - 1)//���i���������һ��������������
    			i2 = new Interval(Integer.MAX_VALUE, Integer.MAX_VALUE);
    		else//����i2���i1�����ֵ
    			i2 = intervals.get(i+1);
    		//�ϲ�����	
    		if(i2.start >= i1.start && i2.start <= i1.end){
    			i1.end = Math.max(i1.end, i2.end);
    		}else{//û�н�����ֱ�����
    			list.add(i1);
    			i1 = i2;//i1����
    		}
    	}
		return list;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
