package com.zk.algorithm.list.queue;
/**
 * 队列接口;
 * @author Kor_Zhang
 *
 */
public interface Queue<E> {
	/**
	 * 移除队头元素;<br/>
	 * 如果和{@link Queue#size()}一起使用循环结构时,请注意{@link Queue#size()}是动态获取长度,会影响for循环的次数;
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
	 * 获取队列长度;<br/>
	 * 是动态获取长度,会影响for循环的执行次数,所以建议先保存长度到变量,利用变量进行for循环;
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
	 * @return	-1表示无限
	 */
	int maxSize();
}
