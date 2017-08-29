package com.zk.algorithm.list.queue;

public class Demo {
	/**
	 * 队列测试
	 * @param args
	 */
	public static void main(String[] args) {
//		Queue<Integer> q = new CircularQueue<Integer>(4);
//		Queue<Integer> q = new LinkedQueue<Integer>();
		Queue<Integer> q = new WeightQueue<Integer>(WeightQueue.ORDER_DESC);
//		q.add(null);
		q.add(-1);
		q.add(9);
		q.add(4);
		q.add(-899);
		q.add(4);
		System.out.println(q.isEmpty());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.delete());
		System.out.println(q.isEmpty());
		
		
	}

}
