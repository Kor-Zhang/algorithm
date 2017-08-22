package com.zk.algorithm.sort.inner.select;

import com.zk.algorithm.sort.Sorter;

/**
 * 简单选择排序;Simple Selection Sort
 * 
 * @author Kor_Zhang
 *
 */
public class _3S<T> implements Sorter<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] bucket) {
		for (int i = 0; i < bucket.length - 1; i++) {// i代表当前最小元素存放位置,也代表趟数
			int minPos = i;// 当前最小元素所在位置
			T min = (T) bucket[minPos];// 当前最小元素
			// 寻找i以后的最小的元素
			int j = i + 1;
			for (; j < bucket.length; j++) {
				if (bucket[j].compareTo(min) == -1) {// 循环
					min = (T) bucket[j];
					minPos = j;
				}
			}
			// 找到最小的元素的所在位置minPos
			bucket[minPos] = bucket[i];
			bucket[i] = (Comparable<T>) min;

		}

	}

}
