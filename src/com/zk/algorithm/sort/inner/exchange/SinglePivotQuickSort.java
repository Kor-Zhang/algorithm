package com.zk.algorithm.sort.inner.exchange;

import com.zk.algorithm.sort.Sorter;

/**
 * 单轴快速排序
 * 
 * @author Kor_Zhang
 *
 */
public class SinglePivotQuickSort<T> implements Sorter<T> {
	@Override
	public void sort(Comparable<T>[] bucket) {
		recSort(bucket, 0, bucket.length - 1);

	}

	/**
	 * 递归排序;
	 * 
	 * @param data
	 *            待排序数据
	 * @param low
	 *            最低位
	 * @param high
	 *            最高位
	 */
	private void recSort(Comparable<T>[] data, int low, int high) {
		if (low < high) {
			// 以key为标准排序
			int middle = round(data, low, high);

			// 分为两个子序列排序;

			// 左序列排序
			recSort(data, low, middle - 1);

			// 右序列排序
			recSort(data, middle + 1, high);

		}
	}

	/**
	 * 以low所在的数据为key进行一趟排序;<br>
	 * 将移动所有右边的比key小的元素到左边,在移动所有左边的比key元素大的元素到右边;
	 * 
	 * @param data
	 *            待排序数据
	 * @param low
	 *            最低位
	 * @param high
	 *            最高位
	 * @return 返回排序后keys所在位置
	 */
	@SuppressWarnings("unchecked")
	private int round(Comparable<T>[] data, int low, int high) {
		// 将轴保存,low位被挖坑，等待填坑
		Comparable<T> pivot = (Comparable<T>) data[low];//

		// 反复移动左右的数据
		while (low < high) {
			// 右部小数据移动到左边
			while (low < high && (data[high].compareTo((T) pivot) == 1 || data[high].compareTo((T) pivot) == 0)) {
				--high;
			}
			// 填坑
			data[low] = data[high];

			// 左部小数据移动到右边
			while (low < high && (data[low].compareTo((T) pivot) == -1 || data[low].compareTo((T) pivot) == 0)) {
				++low;
			}
			// 填坑
			data[high] = data[low];
		}
		// 回填
		data[low] = (Comparable<T>) pivot;

		return low;
	}

}
