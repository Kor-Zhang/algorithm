package com.zk.algorithm.list.stack;
/**
 * 抽象zhan,实现共有的逻辑;
 * @author Kor_Zhang
 *
 */
public class AbstractStack<E> implements Stack<E> {

	

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public E top() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public String toString() {
		E[] arr = this.toArray();
		
		int size = this.size();
		
		StringBuffer sb = new StringBuffer("bottom=>\t");
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+"\t");
		}
		sb.append("<=top");
		
		return sb.toString();
	}

	@Override
	public E[] toArray() {
		
		return null;
	}

	@Override
	public boolean push(E e) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int maxSize() {
		return 0;
	}
}
