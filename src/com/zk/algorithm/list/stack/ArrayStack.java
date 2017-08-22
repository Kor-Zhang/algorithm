package com.zk.algorithm.list.stack;

import java.lang.reflect.Array;

/**
 * 数组实现栈
 * @author Kor_Zhang
 *
 * @param <E>	栈内元素类型
 */
public class ArrayStack<E> extends AbstractStack<E>{

	private E[] stack = null;
	private int top;//既是栈顶指针,也是栈当前长度;top永远指向待填充数据的区域，切记！！
	private int maxSize;
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) {
		
		this.maxSize = maxSize;
		
		stack = (E[]) new Object[maxSize];
		
		top = 0;
	}

	

	@Override
	public E pop(){
		if(top<=0){
			return null;
		}
		return stack[--top];
	}



	@Override
	public boolean push(E e){
		if(stack.length < top+1){
			return false;
		}
		stack[top++] = e;
		return true;
	}
	
	@Override
	public int size() {
		return top;
	}
	
	@Override
	public boolean isEmpty() {
		return stack.length == 0;
	}
	
	@Override
	public E top() {
		return stack[top - 1];
	}
	@Override
	public int maxSize() {
		return this.maxSize;
	}
	@Override
	public E[] toArray() {
		
		@SuppressWarnings("unchecked")
		E[] retArr = (E[]) Array.newInstance(Object.class, this.size());
		
		System.arraycopy(stack, 0, retArr, 0, this.size());
		
		return retArr;
	}
}
