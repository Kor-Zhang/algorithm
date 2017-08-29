package com.zk.algorithm.list.queue;


/**
 * 权重队列;<br/>
 * 根据节点的权重对队列时刻保持升序或者降序的排列状态;<br/>
 * 升序的队列:
 * <block><pre>
 * ++++++++++++++++++++++++++++++++++
 * +	1	+	22	+	33	+	55	+
 * ++++++++++++++++++++++++++++++++++
 * </pre></block>
 * 降序的队列:
 * <block><pre>
 * ++++++++++++++++++++++++++++++++++
 * +	55	+	33	+	22	+	1	+
 * ++++++++++++++++++++++++++++++++++
 * </pre></block>
 * @author Kor_Zhang
 *
 */
public class WeightQueue<E extends Comparable<E>> extends AbstractQueue<E> {
	/**
	 * 队列采用降序排列,1
	 */
	public final static Integer ORDER_DESC = -1;
	
	/**
	 * 队列采用升序排列,-1
	 */
	public final static Integer ORDER_ASC = 1;
	
	private Integer order = ORDER_ASC;// 默认为升序状态
	
	private Node headNode;//头结点和尾节点
	
	private Node cacheNode;//用于缓存对的node
	
	private Integer size;//队列大小
	/**
	 * 构造法
	 * 
	 * @param order
	 */
	public WeightQueue(Integer order) {
		super();
		
		this.order = order;
		
		this.headNode = new Node(null, null ,null);
		
		this.size = 0;
	}

	@Override
	public boolean add(E e) {
		
		if( null == e){
			return false;
		}
		if(size == 0){//如果为第一个节点,特殊处理
			
			cacheNode = new Node(e,headNode,null);
			
			headNode.next = cacheNode;
			
			++size;
			
			return true;
		}
		//非第一个节点
		cacheNode = new Node(e, null , null);
		
		Node currNode = this.headNode;//指向头指针
		
		while(currNode.next != null && cacheNode.compareTo(currNode.next) == order){
			currNode = currNode.next;
		}
		
		//重建连接
		cacheNode.prev = currNode;
		cacheNode.next= currNode.next;
		currNode.next = cacheNode;
		
		
		++size;

		return true;
	}

	@Override
	public E delete() {

		if(isEmpty()){
			return null;
		}
		
		E r = headNode.next.e;
		
		headNode.next = headNode.next.next;
		
		--size;
		
		return r;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	/**
	 * 队列节点
	 * @author Kor_Zhang
	 *
	 */
	private class Node implements Comparable<Node>{
		private E e;//值域
		private Node prev;//指向上一个节点
		private Node next;//指向下一个节点
		
		
		/**
		 * 构造法
		 * @param e
		 * @param next
		 * @param prev
		 */
		public Node(E e, WeightQueue<E>.Node prev, WeightQueue<E>.Node next) {
			super();
			this.e = e;
			this.next = next;
			this.prev = prev;
		}



		@Override
		public int compareTo(WeightQueue<E>.Node o) {
			
			return this.e.compareTo(o.e);
		}
		
		
	}
}
