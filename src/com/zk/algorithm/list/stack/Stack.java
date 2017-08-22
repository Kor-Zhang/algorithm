package com.zk.algorithm.list.stack;

/**
 * 栈接口
 * @author Kor_Zhang
 *
 * @param <E>	栈内元素类型
 */
public interface Stack<E> {
	/**
	 * 入栈
	 * @param e	入栈元素
	 * @return	入栈是否成功
	 */
	boolean push(E e);
	
	/**
	 * 出栈
	 * @return
	 */
	E pop();
	/**
	 * 获取栈顶元素但不删除
	 * @return
	 */
	E top();
	
	/**
	 * 栈当前长度
	 * @return
	 */
	int size();
	/**
	 * 栈的最大允许长度
	 * @return	<0表示无无限制
	 */
	int maxSize();
	/**
	 * 判断是否栈空
	 * @return
	 */
	boolean isEmpty();
	/**
	 * 将栈元素从栈底到栈顶转化成数组
	 * @return
	 */
	E[] toArray();
	
}
