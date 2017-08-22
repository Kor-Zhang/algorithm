package com.zk.algorithm.sort.inner.exchange;

import com.zk.algorithm.sort.Sorter;

/**
 * 冒泡排序
 * 
 * @author Kor_Zhang
 *
 */
public class BubbleSort<T> implements Sorter<T> {


	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] bucket) {
		// 记录当前排序次数
		int i = 0;
		int dataSize = bucket.length;
		while (i < dataSize) {// 多少个数,排序多少次
			// 比较
			int j = 0;
			while (j < dataSize - i - 1) {// -i表示减去比较了的次数，-1表示新数据需要放置的位置
				if (bucket[j].compareTo((T) bucket[j + 1]) == 1) {
					T temp = (T) bucket[j];
					bucket[j] = bucket[j + 1];
					bucket[j + 1] = (Comparable<T>) temp;
				}
				++j;
			}
			++i;
		}

	}
}
