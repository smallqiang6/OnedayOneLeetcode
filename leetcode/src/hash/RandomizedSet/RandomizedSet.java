package hash.RandomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
https://leetcode-cn.com/problems/insert-delete-getrandom-o1/description/
*/
/*	
���һ��֧����ƽ�� ʱ�临�Ӷ� O(1) �£�ִ�����²��������ݽṹ��

insert(val)����Ԫ�� val ������ʱ���򼯺��в�����
remove(val)��Ԫ�� val ����ʱ���Ӽ������Ƴ����
getRandom������������м����е�һ�ÿ��Ԫ��Ӧ������ͬ�ĸ��ʱ����ء�
ʾ�� :

// ��ʼ��һ���յļ��ϡ�
RandomizedSet randomSet = new RandomizedSet();

// �򼯺��в��� 1 ������ true ��ʾ 1 ���ɹ��ز��롣
randomSet.insert(1);

// ���� false ����ʾ�����в����� 2 ��
randomSet.remove(2);

// �򼯺��в��� 2 ������ true ���������ڰ��� [1,2] ��
randomSet.insert(2);

// getRandom Ӧ������� 1 �� 2 ��
randomSet.getRandom();

// �Ӽ������Ƴ� 1 ������ true ���������ڰ��� [2] ��
randomSet.remove(1);

// 2 ���ڼ����У����Է��� false ��
randomSet.insert(2);

// ���� 2 �Ǽ�����Ψһ�����֣�getRandom ���Ƿ��� 2 ��
randomSet.getRandom();


*/

/*
https://blog.csdn.net/whuwangyi/article/details/18897387

��O(1)ʱ����֧��ǰ���ֲ��������ݽṹ��ʵ���࣬�������������뵽��ϣ���ؼ������֧��HashMap�����ѡ��������������key��value�����������ͣ��򵥵���javaʵ�ִ������£�

˼·�ܼ򵥣���Ϊ����һ�����飬Ҫ�������һ�����Ԫ�طǳ����ס�����������ʣ������Ȼ��HashMap���key set��ӳ�䵽һ�������Ȼ��������������±꣬�Ӷ������ָ��һ��key��ӵ������һ��random key�󣬾Ϳ��Ի��һ��random element�ˡ�
��ϧ�������Ϸ����������ϸ��O(1)ʱ�䣬��Ϊ����һ��ArrayList��ʵ��Ҫ��HashMap�����е�key������һ�ݡ����������HashMap��ֻ���ģ��������ӻ���ɾ��Ԫ�أ�Ȼ�󱣴�������������Ժ����ʹ�ã��Ӷ��õ���̯��O(1)ʱ�䡣

�����뵽������ʵ����Ѿ��ܽӽ��ˣ���Ȼ��HashMap��������ǰ2������������������������3����������ô���ǾͿ��Ի��һ�£����һ��������һ�������һ��HashMap�����ݽṹ��

1. Insert����server�ֱ���뵽HashMap�����飨β�����������ö�Ӧ������Ԫ�ر�����ĩβԪ�ظ��ǣ�Ȼ��ȥ��ĩβԪ��

2. Delete�����Ȼ��Ҫɾ����server�Ķ�Ӧ�����±꣬Ȼ�󽫸�server��HashMap��ɾ���������ö�Ӧ������Ԫ�ر�����ĩβԪ�ظ��ǣ�������HashMap��ԭ���Ǹ�����ĩβԪ�ص������±꣬���ɾ�������ĩβԪ�ء�

3. Find Random�������������ѡһ�������±꣬����Ӧ��server��Ϊkey��HashMap��ȥ�ҡ�
	
*/
public class RandomizedSet {

	private Map<Integer, Integer> valToIndex;
	private List<Integer> valList;
	private java.util.Random random;

	/** Initialize your data structure here. */
	public RandomizedSet() {
		valToIndex = new HashMap<>();
		valList = new ArrayList<>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain
	 * the specified element.
	 */
	public boolean insert(int val) {
		if (valToIndex.containsKey(val)) {
			return false;
		}
		valToIndex.put(val, valList.size());
		valList.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified
	 * element.
	 */
	public boolean remove(int val) {
		if (!valToIndex.containsKey(val)) {
			return false;
		}
		int index = valToIndex.get(val);
		int lastIndex = valList.size() - 1;
		if (index < lastIndex) {
			// swap val with the last element in valList
			valList.set(index, valList.get(lastIndex));
			// don't forget to update last index in map!
			valToIndex.put(valList.get(lastIndex), index);
		}
		valToIndex.remove(val);
		valList.remove(valList.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return valList.get(random.nextInt(valList.size()));
	}
	/*
	 * ���ߣ�Nancyberry ���ӣ�https://www.jianshu.com/p/b022676684ce ��Դ������
	 * ��������Ȩ���������У��κ���ʽ��ת�ض�����ϵ���߻����Ȩ��ע��������
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
