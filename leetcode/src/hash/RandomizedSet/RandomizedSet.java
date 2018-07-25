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
设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。

insert(val)：当元素 val 不存在时，向集合中插入该项。
remove(val)：元素 val 存在时，从集合中移除该项。
getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
示例 :

// 初始化一个空的集合。
RandomizedSet randomSet = new RandomizedSet();

// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
randomSet.insert(1);

// 返回 false ，表示集合中不存在 2 。
randomSet.remove(2);

// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
randomSet.insert(2);

// getRandom 应随机返回 1 或 2 。
randomSet.getRandom();

// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
randomSet.remove(1);

// 2 已在集合中，所以返回 false 。
randomSet.insert(2);

// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
randomSet.getRandom();


*/

/*
https://blog.csdn.net/whuwangyi/article/details/18897387

在O(1)时间内支持前两种操作的数据结构其实不多，很容易让人联想到哈希表。关键是如何支持HashMap的随机选择操作。这里假设key和value都是整数类型，简单的用java实现代码如下：

思路很简单，因为对于一个数组，要获得其中一个随机元素非常容易。利用这个性质，可以先获得HashMap里的key set，映射到一个数组里，然后随机生成数组下标，从而随机的指定一个key。拥有这样一个random key后，就可以获得一个random element了。
可惜的是以上方法并不是严格的O(1)时间，因为生成一个ArrayList其实需要将HashMap里所有的key都拷贝一份。除非是这个HashMap是只读的，不再增加或者删除元素，然后保存这个数组留着以后继续使用，从而得到均摊的O(1)时间。

不过想到这里其实离答案已经很接近了，既然用HashMap可以满足前2个条件，而用数组可以满足第3个条件，那么我们就可以混搭一下，设计一个包含有一个数组和一个HashMap的数据结构。

1. Insert：将server分别加入到HashMap和数组（尾部）；另外让对应的数组元素被数组末尾元素覆盖，然后去掉末尾元素

2. Delete：首先获得要删除的server的对应数组下标，然后将该server从HashMap中删除。另外让对应的数组元素被数组末尾元素覆盖，并且在HashMap里原来那个数组末尾元素的数组下标，最后删除数组的末尾元素。

3. Find Random：在数组中随机选一个数组下标，把相应的server作为key到HashMap里去找。
	
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
	 * 作者：Nancyberry 链接：https://www.jianshu.com/p/b022676684ce 來源：简书
	 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
