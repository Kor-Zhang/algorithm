package com.zk.algorithm.sort.inner.insert;

import com.zk.algorithm.sort.Sorter;

/**
 * 希尔排序
 * 
 * @author Kor_Zhang
 *
 */
public class ShellSort<T> implements Sorter<T> {
	/**
	 * 增量
	 */
	private int d;

	public ShellSort(int d) {
		super();
		this.d = d;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] bucket) {
		while (true) {

			// x代表分组进行直接插入排序,d代表组数
			int i = 0;// 代表每组第一个 
			for (; i < d; i++) {
				int unOrderSequenceFirst = i + d;//无序队列的第一个

				// x组进行直接插入排序
				for (; unOrderSequenceFirst < bucket.length; unOrderSequenceFirst = unOrderSequenceFirst + d) {

					T temp = (T) bucket[unOrderSequenceFirst];

					int j = unOrderSequenceFirst - d;

					for (; j >= i && bucket[j].compareTo(temp) == 1; j = j - d) {

						bucket[j + d] = bucket[j];

					}

					bucket[j + d] = (Comparable<T>) temp;

				}

			}

			if (d == 1) {
				break;
			}

			d = (d / 2);
		}
	}

}
