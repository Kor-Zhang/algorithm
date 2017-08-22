package com.zk.algorithm.sort.inner.other;

import java.lang.reflect.Array;

import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;
import com.zk.algorithm.sort.Sorter;
/**
 * 基数排序;<br/>
 * 核心:基数排序是通过“分配”和“收集”过程来实现排序。<br/>
 * 只能对数值排序;
 * @author Kor_Zhang
 * @param <T>
 *
 */
public class RadixSort implements Sorter<Integer> {
	@SuppressWarnings("unchecked")
	private List<Integer>[] linkedList = (List<Integer>[]) Array.newInstance(DoubleLinkedList.class, 10);

	
	
	public RadixSort() {
		super();
		for (int i = 0; i < linkedList.length; i++) {
			linkedList[i] = new DoubleLinkedList<Integer>();
		}
	}
	@Override
	public void sort(Comparable<Integer>[] bucket) {
		int m = max(bucket);
		for (int i = 1; i <= m; i++) {//最高位数多少位就收集多少次
			for (int j = 0; j < bucket.length; j++) {//遍历data，分配data数据到桶中
				Integer num = (Integer) bucket[j];
				//放入对应的桶中
				linkedList[getDigit(num, i)].add((Integer) bucket[j]);
			}
			//收集完成后,放入原数组
			int index = 0;
			for (int j = 0; j < linkedList.length; j++) {
				List<Integer> l = linkedList[j];
				for (int k = 0; k < l.size(); k++) {
					bucket[index++] = l.get(k);
				}
				//清空桶,准备下一位的排序
				l.clear();
			}
			
		}
	}
	/**
	 * 统计数组中的最高位数
	 * @param data
	 * @return
	 */
	private int max(Comparable<Integer>[] data){
		int max = 0;
		for (int i = 0; i < data.length; i++) {
			int t = maxDigit((Integer) data[i]);
			if(max < t){
				max = t;
			}
		}
		return max;
	}
	/**
	 * 获取某个数的最高位
	 * @param num	待计算数字
	 * @return
	 */
	private int maxDigit(Integer num) {
		int r = 0;
		
		while(num%(Math.pow(10, r+1))!=num){
			++r;
		}
		return r+1;
	}
	/**
	 * 获取某个数字的第i位数字的值;
	 * @param num
	 * @param i
	 * @return
	 */
	private int getDigit(int num,int i){
		int r = (int) (num/Math.pow(10, i-1)) - ((int) (num/Math.pow(10, i)))*10 ;
		return r;
	}
	
}
