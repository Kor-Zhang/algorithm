package com.zk.algorithm.list.queue;

import java.lang.reflect.Array;

/**
 * 顺序结构的循环队列;<br/>
 * 队尾和对头之间预留一个空间作为判断队列空或者满;<br/>
 * 
 * <pre>
 * 即	
 * 队满=>(rear+1)%maxSize == front
 * 队空=>rear == front
 * </pre>
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class CircularQueue<E> extends AbstractQueue<E> {
	private int rear;// 队尾,永远指向待填充位置
	private int front;// 队头,永远待取数据位置
	private E[] bucket;// 储存数据
	private int maxSize;// 最大储存容量

	/**
	 * 初始化队列
	 * 
	 * @param maxSize
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue(int maxSize) {
		super();

		this.maxSize = maxSize + 1;

		front = rear = 0;

		// 对分配一位用于分辨队空和对满
		bucket = (E[]) Array.newInstance(Object.class, maxSize);
	}

	@Override
	public E delete() {
		if (rear == front) {
			return null;
		}
		E r = bucket[front];

		front = (++front) % maxSize;

		return r;
	}

	@Override
	public boolean add(E e) {
		if (null == e) {
			return false;
		}
		if ((rear + 1) % maxSize == front) {
			return false;
		}
		bucket[rear++] = e;
		return true;
	}

	@Override
	public int size() {
		return (rear - front + maxSize) % maxSize;
	}


	@Override
	public int maxSize() {
		return maxSize;
	}

}
