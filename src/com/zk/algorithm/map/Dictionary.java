package com.zk.algorithm.map;

import java.io.Serializable;

import com.zk.algorithm.list.List;

/**
 * 提供了字典接口;
 * @author Kor_Zhang
 *
 * @param <K>
 * @param <V>
 */
public interface Dictionary<K, V> extends Serializable{
	
	/**
	 * 存放键值对数据
	 * @param key	键
	 * @param value	值
	 */
	void put(K key,V value);
	
	/**
	 * 通过键查找值;<br/>
	 * @param key	键
	 * @param defaultVal	没有该key时返回
	 * @return
	 */
	V get(K key,V defaultVal);
	/**
	 * 通过键查找值;<br/>
	 * @param key	键
	 * @return
	 */
	V get(K key);
	
	/**
	 * 移除指定key的节点
	 * @param key
	 */
	void remove(K key);
	/**
	 * 是否包含某键
	 * @param key	键
	 * @return	返回查询结果:true包含,false不包含;
	 */
	boolean contain(K key);
	
	
	/**
	 * 集合大小
	 * @return
	 */
	int size();	
	
	/**
	 * 清空集合
	 */
	void clear();
	
	/**
	 * 获取所有的键
	 * @return	所有键的集合
	 */
	List<K> keys();
	
	/**
	 * 获取所有的值
	 * @return	所有值的集合
	 */
	List<V> values();
}
