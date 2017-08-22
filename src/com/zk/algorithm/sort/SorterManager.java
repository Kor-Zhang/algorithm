package com.zk.algorithm.sort;

/**
 * 排序器,采用策略模式,可根据实际切换排序算法;<br/>
 * 传递一个继承了{@link Sorter}接口的排序算法和一个待排序数组用来排序;
 * @author Kor_Zhang
 * @param <T>	T:排序的类型,该类型必须继承自Comparable
 *
 */
public class SorterManager{
	
	/**
	 * 根据传入的排序算法排序数组
	 * @param bucket	待排序数组
	 * @param sorter	排序算法
	 */
	public <T> void sort(Comparable<T>[] bucket,Sorter<T> sorter) {
		sorter.sort(bucket);
	}
}
