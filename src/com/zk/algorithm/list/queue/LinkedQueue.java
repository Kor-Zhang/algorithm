package com.zk.algorithm.list.queue;

/**
 * 链式队列
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 *            队列的值域类型
 */
public class LinkedQueue<E> extends AbstractQueue<E> {

	private Integer size;// 队列大小

	private Node headNode;// 头节点

	private Node tailNode;// 尾节点

	private Node cacheNode;// 用于缓存的node

	public LinkedQueue() {
		super();

		this.size = 0;

		tailNode = headNode = new Node(null, null, null);

	}

	@Override
	public E delete() {

		E t = headNode.next.e;

		headNode.next = headNode.next.next;

		--size;

		if (size == 0) {
			tailNode = headNode;
		}

		return t;
	}

	@Override
	public boolean add(E e) {

		cacheNode = new Node(e, tailNode, null);

		tailNode.next = cacheNode;

		tailNode = cacheNode;

		++size;

		return true;
	}

	@Override
	public int size() {
		return size;
	}


	/**
	 * 链式队列节点
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private class Node {
		private E e;// 值域
		private Node prev;// 指向上一个节点
		private Node next;// 指向下一个节点

		public Node(E e, LinkedQueue<E>.Node prev, LinkedQueue<E>.Node next) {
			super();
			this.e = e;
			this.next = next;
			this.prev = prev;
		}

	}
}
