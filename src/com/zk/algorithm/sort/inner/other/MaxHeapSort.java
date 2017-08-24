package com.zk.algorithm.sort.inner.other;

import com.zk.algorithm.sort.Sorter;

/**
 * 大根堆排序
 * 
 * @author Kor_Zhang
 * @param <T>
 *            待排序的数据类型
 *
 */
public class MaxHeapSort<T> implements Sorter<T> {

	@SuppressWarnings("unchecked")
	@Override
	public void sort(Comparable<T>[] bucket) {
		// 构建大根堆
		buildMaxHeap(bucket);

		for (int i = bucket.length - 1; i >= 0; --i) {
			// 最后一个和第一个交换,最后一个为已排好序的,第一个元素是等待排序的
			T t = (T) bucket[i];
			bucket[i] = bucket[0];
			bucket[0] = (Comparable<T>) t;
			adjustTop2Down(bucket, 0, i);
		}
	}

	/**
	 * 将数组构建成一棵树;
	 * 
	 * @param bucket
	 *            未构建成树的数组;
	 */
	private void buildMaxHeap(Comparable<T>[] bucket) {
		// 从数组的最后一个节点开始,不断的将节点加入树,反复调整
		for (int i = (bucket.length - 1 - 1) / 2; i >= 0; --i) {
			//反复调整树
			adjustTop2Down(bucket, i, bucket.length);
		}
	}

	/**
	 * 自顶向底将以k为根节点树调整为大根堆;
	 * 
	 * @param bucket
	 *            整树
	 * @param k
	 *            需要调整的数的索引
	 * @param len
	 *            树所在数组的长度
	 */
	@SuppressWarnings("unchecked")
	private void adjustTop2Down(Comparable<T>[] bucket, int k, int len) {
		// k代表当前待填的坑
		Comparable<T> root = bucket[k];
		// 向下遍历子树
		for (int i = 2 * k + 1; i < len - 1; i = i * 2 + 1) {
			if (i < len && bucket[i].compareTo((T) bucket[i + 1]) == -1) {// 如果左子节点小于右子节点,i<len预防右子节点越界
				++i;
			}
			if (root.compareTo((T) bucket[i]) == 1) {// 如果根大于最大子节点
				break;
			} else {
				// 下移当前的根的值
				bucket[k] = bucket[i];
				k = i;
			}
		}
		bucket[k] = root;
	}

}
