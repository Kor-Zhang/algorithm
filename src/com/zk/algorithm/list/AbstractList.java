package com.zk.algorithm.list;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * 预实现一些线性表功能
 * @author Kor_Zhang
 *
 * @param <E>	线性表内部值类型;
 */
public class AbstractList<E> implements List<E>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4491232305532634464L;

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeElement(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(E e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(Integer index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer indexOf(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer size() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("{\"content\":\"");
		int index = 0;
		while(index < this.size()){
			if(index != this.size() -1){
				sb.append(this.get(index)+",");
				
			}else{
				sb.append(this.get(index));
			}
			++index;
			
		}
		sb.append("\",\"size\":\""+this.size()+"\"}");
		return sb.toString();
	}

	@Override
	public void addAll(List<E> subList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public int compareTo(List<E> o) {
		int tSize = this.size();
		int oSize = o.size();
		return tSize>oSize?1:(tSize==oSize?0:-1);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		E[] arr = (E[]) Array.newInstance(Object.class, this.size());
		for (int i = 0; i < this.size(); i++) {
			arr[i] = this.get(i);
		}
		return arr;
	}

	@Override
	public Iterator<E> iterator() {
		
		return new It();
	}
	/**
	 * 迭代器
	 * @author Kor_Zhang
	 *
	 */
	private class It implements Iterator<E>{
		/**
		 * 记录下迭代器的索引
		 */
		private Integer iteratorIndex = 0;
		
		@Override
		public boolean hasNext() {
			return iteratorIndex < AbstractList.this.size();
		}

		@Override
		public E next() {
			return AbstractList.this.get(iteratorIndex++);
		}
		
	}
	@Override
	public void insert(E e, Integer index) {
		// TODO Auto-generated method stub
		
	}
	
}
