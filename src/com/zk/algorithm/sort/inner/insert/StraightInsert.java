package com.zk.algorithm.sort.inner.insert;

import com.zk.algorithm.sort.Sorter;

/**
 * 直接插入排序
 * 
 * @author Kor_Zhang
 *
 */
public class StraightInsert<T> implements Sorter<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] data) {
		int i = 1;// 无序序列的第一个(这里假设下表为0的数字为有序序列)
		while (i < data.length) {// 对未排序的序列排序
			T minInUnderSequence = (T) data[i];//假设第无序序列中的第一个数为最小的数据
			int j = i - 1;//有序序列的最后一个
			//由后向前扫描,移动数据
			while (j >= 0 && data[j].compareTo(minInUnderSequence) == 1) {
				data[j + 1] = data[j];
				--j;
			}

			data[++j] = (Comparable<T>) minInUnderSequence;

			++i;
		}
	}

}
