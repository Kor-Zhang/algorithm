package com.zk.algorithm.list;

import java.io.Serializable;
import java.util.Iterator;

/**
 * 线性表
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 *            线性表储存的值的类型;
 * 
 * @see DoubleLinkedList
 * @see SingleLinkedList
 */
public interface List<E> extends Serializable, Comparable<List<E>> {
	/**
	 * 移除指定位置的元素;
	 * 
	 * @param index
	 */
	void remove(int index);

	/**
	 * 移除指定的元素;<br/>
	 * 将调用{@link Object#equals(Object)}比较对象;
	 * 
	 * @param e
	 */
	void removeElement(E e);

	/**
	 * 添加一个元素
	 * 
	 * @param e
	 */
	void add(E e);

	/**
	 * 获取指定位置元素
	 * 
	 * @param index
	 *            [0,n]
	 * @return
	 */
	E get(Integer index);

	/**
	 * 获取线性表长度
	 * 
	 * @return
	 */
	Integer size();

	/**
	 * 将链表元素转化为数组;<br/>
	 * 为何不转化成E[]泛型?<br/>
	 * 因为如果用户调用add(null),然后将Object[]转化为E[],这种行为将产生类型转换错误;
	 * 
	 * @return
	 */
	Object[] toArray();

	/**
	 * 
	 * 数组转化为链表
	 * 
	 * @param eArr
	 *            待转换的数组
	 * @param append
	 *            是否添加
	 */
	void fromArray(E[] eArr, boolean append);

	/**
	 * 追加一个新链表到现有链表
	 * 
	 * @param subList
	 *            追加的链表
	 */
	void addAll(List<E> subList);

	/**
	 * 清空线性表
	 */
	void clear();

	/**
	 * 返回一个迭代器
	 * 
	 * @return 迭代器
	 */
	Iterator<E> iterator();

	/**
	 * 将元素插入到指定位置
	 * 
	 * @param e
	 *            待插入元素
	 * @param index插入的位置
	 *            [0,n]
	 */
	void insert(E e, Integer index);

	/**
	 * 复制一份内容返回
	 * 
	 * @return
	 */
	List<E> copy();

	/**
	 * 获取元素的指定位置;<br/>
	 * 将调用{@link Object#equals(Object)}比较对象;
	 * 
	 * @param e
	 *            待查找元素
	 * @return 返回元素的位置[-1,n];-1表示未找到;
	 */
	Integer indexOf(E e);

	/**
	 * 线性表是否包含某个元素;<br/>
	 * 通过{@link List#indexOf(Object)}方法实现;
	 * 
	 * @param e
	 *            待查找元素
	 * @return true表示存在;
	 */
	boolean contain(E e);

}
