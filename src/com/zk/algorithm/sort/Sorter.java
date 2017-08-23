package com.zk.algorithm.sort;
/**
 * 排序算法接口;<br/>
 * 参数必须为{@link Comparable}的子类
 * @param T	指定排序的类型;<br/>
 * @author Kor_Zhang
 */
public interface Sorter<T>{
	/**
	 * 对继承了{@link Comparable}接口的类型的对象数组进行排序;
	 * @param bucket	待排序数据 
	 * 
	 */
	void sort(Comparable<T>[] bucket);
}
