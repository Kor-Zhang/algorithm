package com.zk.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

import com.zk.algorithm.sort.inner.insert.ShellSort;
import com.zk.algorithm.sort.inner.insert.StraightInsert;
import com.zk.algorithm.sort.inner.other.MaxHeapSort;
import com.zk.algorithm.sort.inner.other.MergeSort;
import com.zk.algorithm.sort.inner.other.RadixSort;
import com.zk.algorithm.sort.inner.quick.QuickSort;
import com.zk.algorithm.sort.inner.select._3S;

public class Demo {
	public static void main(String[] args) {
		Integer[] data = new Integer[100000];
		int dataLen = data.length;
		for (int i = 0; i < data.length; i++) {
			data[i] = new Random().nextInt(dataLen);
		}
		SorterManager sm = new SorterManager();

//		System.out.println(Arrays.toString(data));
		long s = System.currentTimeMillis();
		
		//直接插入排序
//		sm.sort(data, new StraightInsert());
		//希尔排序
//		sm.sort(data, new ShellSort(8));

		//简单选择排序
//		sm.sort(data, new _3S());

		//快速排序
//		sm.sort(data, new QuickSort());
		
		//归并排序,1000w用时:5822
		sm.sort(data, new MergeSort<Integer>());
		//Arrays自带排序工具,1000w用时:4942
//		Arrays.sort(data);
		//基数排序
//		sm.sort(data, new RadixSort());
		//堆排序
		sm.sort(data, new MaxHeapSort<Integer>());
		
		System.out.println("用时:"+(System.currentTimeMillis() - s));
		
//		System.out.println(Arrays.toString(data));
	}
}
