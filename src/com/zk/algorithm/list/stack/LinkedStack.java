package com.zk.algorithm.list.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 链式栈;
 * @author Kor_Zhang
 *
 */
public class LinkedStack<E> extends AbstractStack<E> {
	//栈链表的头结点,即bottom
	private Node<E> headNode;
	//栈链表的尾结点,即top
	private Node<E> tailNode;
	//栈的大小
	private int size;
	//用作缓存的node
	private Node<E> cacheNode;
	/**
	 * 初始化栈
	 */
	public LinkedStack() {
		super();
		
		headNode = new Node<E>(null, null,null);
		
		tailNode = headNode;
		
		size = 0;
		
		cacheNode = null;
	}
	
	@Override
	public boolean push(E e) {
		cacheNode = new Node<E>(e, null,tailNode);
		
		tailNode.next = cacheNode;
		
		tailNode = cacheNode;
		
		++size;
		
		return true;
	}

	@Override
	public E pop() {
		if(isEmpty()){
			return null;
		}
		
		E e = tailNode.getE();
		
		tailNode = tailNode.getPrev();
		
		tailNode.setNext(null);
		
		--size;
		
		return e;
	}
	@Override
	public int size() {

		return size;
	}
	@Override
	public boolean isEmpty() {
		return headNode.getNext() == null;
	}
	@Override
	public E top() {
		return tailNode.getE();
	}
	@Override
	public E[] toArray() {
		@SuppressWarnings("unchecked")
		E[] retArr = (E[]) Array.newInstance(Object.class, this.size());
		cacheNode = headNode.getNext();
		
		int index = 0;
		
		while(cacheNode != null){
			retArr[index++] = cacheNode.getE();
			
			cacheNode = cacheNode.getNext();
			
		}
		System.out.println(Arrays.toString(retArr));
		return retArr;
	}
	@Override
	public int maxSize() {
		return -1;
	}
	/**
	 * 栈节点
	 * @author Kor_Zhang
	 *
	 * @param <E>
	 */
	private static class Node<E>{
		private E e;//数据域

		private Node<E> next;//后继

		private Node<E> prev;//后继
		

		public E getE() {
			return e;
		}

		public void setE(E e) {
			this.e = e;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setNext(Node<E> next) {
			this.next = next;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}


		public Node(E e, Node<E> next, Node<E> prev) {
			super();
			this.e = e;
			this.next = next;
			this.prev = prev;
		}

		public Node() {
			super();
		}
		
		
	}
	
}
