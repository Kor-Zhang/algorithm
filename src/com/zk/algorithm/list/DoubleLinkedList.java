package com.zk.algorithm.list;

/**
 * 双向链表:DoubleLinkedList
 * @author Kor_Zhang
 *
 */
public class DoubleLinkedList<E> extends AbstractList<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1211787544856989886L;
	/**
	 * 头结点
	 */
	private Node<E> headNode;
	/**
	 * 尾结点,指向最后一个节点,方便插入数据
	 */
	private Node<E> tailNode;
	/**
	 * 链表大小,节省统计长度的时间
	 */
	private int size;
	
	/**
	 * 初始化双向链表
	 */
	public DoubleLinkedList() {
		super();
		
		headNode = new Node<E>(null,null,null);
		
		//指向头结点
		tailNode = headNode;
		
		this.size = 0;
		
		
	}
	@Override
	public void remove(int index) {
		super.remove(index);
		
		if(0 == size){
			return ;
		}
		//首元结点开始
		int curIndex = 0;
		Node<E> node = this.headNode.getNext();
		while( node != null && curIndex < index){
			node = this.headNode.getNext();
		}
		//找到了需要删除的元素位置
		if(curIndex == index){
			if(curIndex == this.size - 1){//如果你试图删除最有一个元素,那么先更改尾指针
				this.tailNode = this.tailNode.getPrev();
				this.tailNode.setNext(null);
			}else{
				node.getPrev().setNext(node.getNext());
				node.getNext().setPrev(node.getPrev());
			}
			--size;
		}
	}

	@Override
	public void removeElement(E e) {
		super.removeElement(e);
		
		if(0 == size){
			return ;
		}
		//首元节点开始
		Node<E> node = this.headNode.getNext();
		while(node != null){
			if(node.getE().equals(e)){
				//找到需要删除的节点
				
				if(node.getNext() == null){//如果为最后一个节点
					this.tailNode = this.tailNode.getPrev();
					
					this.tailNode.setNext(null);
				}else{
					node.getPrev().setNext(node.getNext());
					node.getNext().setPrev(node.getPrev());
				}
				
				--size;
				return ;
			}
			node = node.getNext();
		}
	}

	@Override
	public void add(E e) {
		super.add(e);
		
		//生成新节点,建立链接
		Node<E> refresh = new Node<E>(e,null,this.tailNode);
		
		this.tailNode.setNext(refresh);
		
		this.tailNode = refresh;
		
		++size;
	}



	@Override
	public Integer indexOf(E e) {
		//头结点开始
		int curIndex = -1;
		Node<E> node = this.headNode;
		while(node.getNext() != null){//预判下一个节点
			node = node.getNext();
			++curIndex;
			if(node.getE().equals(e)){
				return curIndex;
			}
		}
		
		return -1;
	}

	@Override
	public Integer size() {
		return size;
	}


	@Override
	public E get(Integer index) {
		int curIndex = -1;
		Node<E> node = this.headNode;
		while(node.getNext() != null && curIndex+1<=index){
			node = node.getNext();
			++curIndex;
		}
		return node.getE();
	}

	@Override
	public void clear() {
		super.clear();
		Node<E> currtDeal = this.headNode.next;//当前处理节点
		while(currtDeal!=null){
			Node<E> next = currtDeal.next;//保存下一个节点
			
			//处理当前节点
			currtDeal.setE(null);
			currtDeal.setNext(null);
			currtDeal.setPrev(null);
			
			currtDeal = next;
			
			--size;
		}

		this.tailNode = this.headNode;
		
		
		this.tailNode = this.headNode;
	}
	/**
	 * 双向链表节点
	 * @author Kor_Zhang
	 *
	 * @param <E>	节点储存数据泛型
	 */
	static class Node<E> {
		private E e;//数据域
		private Node<E> next;//后继
		private Node<E> prev;//前驱
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
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> l = new DoubleLinkedList<Integer>();
		try {
			/*long s = System.currentTimeMillis();
			for(int i = 0;i<20000;i++){
				l.add(i);
			}
			l.clear();
			for(int i = 0;i<20000;i++){
				l.removeElement(i);
			}
			System.out.println("用时:"+(System.currentTimeMillis() -s));
			*/
			/*for(int i = 0;i<20000;i++){
				l.add(i);
			}
			for (int i = 0; i < 20000; i++) {
				System.err.println(l.get(i));
			}*/
//			l.add(11);
//			l.add(121);
//			l.add(1211);
//			l.removeElement(11);
//			l.removeElement(3);
			System.out.println(l.toString());
			
//			l.print();
			//System.out.println(l.indexOf(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
