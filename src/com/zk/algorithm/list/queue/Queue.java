package com.zk.algorithm.list.queue;
/**
 * 队列接口;
 * @author Kor_Zhang
 *
 */
public interface Queue<E> {
	/**
	 * 移除队头元素
	 * @return	移除的元素
	 */
	E delete();
	/**
	 * 添加一个元素到队尾
	 * @param e	添加的元素
	 * @return	true:添加成功
	 */
	boolean add(E e);
	
	/**
	 * 获取队列长度
	 * @return
	 */
	int size();
	/**
	 * 判断是否为空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 队列的最大容量
	 * @return
	 */
	int maxSize();
}
