package com.zk.algorithm.sort.inner.other;

import java.lang.reflect.Array;

import com.zk.algorithm.sort.Sorter;
/**
 * 归并排序;
 * 分为两步,先分解数组为两部分,在有序归并数组为一部分,递归次步骤;
 * @author Kor_Zhang
 *
 */
public class MergeSort<T> implements Sorter<T> {
	@Override
	public void sort(Comparable<T>[] bucket) {
		//开始归并排序
		splitThenMerge(bucket, 0, bucket.length-1);
		

	}
	/**
	 * 分解数组;当把数组分解为length==1的众多子数组时,开始有序的合并子数组<br/>
	 * @param bucket	待排序数组
	 * @param low	最小索引
	 * @param high	最大索引
	 */
	private void splitThenMerge(Comparable<T>[] bucket, int low, int high){
		if(low < high){
			//从(low + high)/2修改为(low + high)>>2速度从1000w用时:5822=>用时:4980
			int mid = (low + high)>>1;
			//采用递归方式,分割当前序列,然后在合并排序当前序列
			splitThenMerge(bucket, low, mid);
			splitThenMerge(bucket, mid + 1, high);
			
			merge(bucket,low,mid,high);
		}
		
	}
	/**
	 * 归并数组;<br/>
	 * 将所有length==1的子数组两两合并,合并过程中排序.直至合并完所有的数组;
	 * @param bucket	待排序数组
	 * @param low	最小索引
	 * @param mid	中部索引
	 * @param high	最大索引
	 */
	@SuppressWarnings("unchecked")
	private void merge(Comparable<T>[] bucket, int low, int mid, int high) {
		/**
		 * 设置临时缓存数组的参数
		 */
		int cacheBucketLen = high - low + 1;
		int cacheBucketIndex = 0;
		T[] cacheBucket = (T[]) Array.newInstance(Object.class, cacheBucketLen);
		/**
		 * 设置左子序列信息
		 */
		int leftArrIndex = low;
		int leftArrEnd = mid;
		/**
		 * 设置右子序列的信息
		 */
		int rightArrIndex = mid + 1;
		int rightArrEnd = high;
		
		while(leftArrIndex <= leftArrEnd && rightArrIndex <= rightArrEnd){
			//比较两子序列当前数据大小,最小的放入临时序列
			if(bucket[leftArrIndex].compareTo((T) bucket[rightArrIndex])==1){
				cacheBucket[cacheBucketIndex++] = (T) bucket[rightArrIndex++];
			}else{
				cacheBucket[cacheBucketIndex++] = (T) bucket[leftArrIndex++];
			}
		}
		//合并剩余的子序列
		while(leftArrIndex <= leftArrEnd){
			cacheBucket[cacheBucketIndex++] = (T) bucket[leftArrIndex++];
		}
		while(rightArrIndex <= rightArrEnd){
			cacheBucket[cacheBucketIndex++] = (T) bucket[rightArrIndex++];
		}

		//copy回原数组
		System.arraycopy(cacheBucket, 0, bucket, low, cacheBucketLen);
	}
	
	
}
