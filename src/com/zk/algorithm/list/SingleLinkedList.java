package com.zk.algorithm.list;

/**
 * 单链表:SingleLinkedList
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class SingleLinkedList<E>  extends AbstractList<E>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1319214402897356585L;
	/**
	 * 头结点
	 */
	private Node<E> headNode;
	/**
	 * 集合大小
	 */
	private int size;
	
	
	
	/**
	 * 初始化
	 */
	public SingleLinkedList() {
		super();
		
		//初始化头结点
		headNode = new Node<E>(null,null);
		
		size = 0;
	}
	/**
	 * 获取指定位置的节点
	 * @param index		[0,n]
	 * @return
	 */
	private Node<E> getNode(int index){
		
		//头结点开始
		int curIndex = -1;//-1表示头结点
		Node<E> node = this.headNode;
		//-1      1
		while(node !=null && curIndex < index){//遍历节点
			node = node.getNext();
			++curIndex;
		}
		//获取到指定位置的节点,返回;
		return node;
	}
	
	
	@Override
	public void add(E e)  {
		//获取最后一个节点
		Node<E> tailNode = getNode(size-1);
		
		//建立链接
		Node<E> refresh = new Node<E>(e,null);
		
		tailNode.setNext(refresh);
		
		++size;
	}
	@Override
	public E get(Integer index)  {
		//获取指定节点
		Node<E> targetNode = getNode(index);
		if(null == targetNode){
			return null;
		}
		return targetNode.getE();
	}
	@Override
	public Integer indexOf(E e)  {
		//首元结点开始
		int curIndex = 0;
		Node<E> node = this.headNode.getNext();
		while(node != null){
			if(node.getE().equals(e)){//判断节点
				return curIndex;
			}
			
			++curIndex;
			node = this.headNode.getNext();
		}
		return -1;
	}
	@Override
	public Integer size()  {
		return size;
	}
	@Override
	public void remove(int index) {
		//获取待删除节点的父节点
		Node<E> tagertNodeParent = getNode(index-1);
		
		//重建链接
		tagertNodeParent.setNext(tagertNodeParent.next.next);
		
		--size;
	}
	@Override
	public void removeElement(E e) {
		Node<E> parentNode = this.headNode;//记录上一节点
		Node<E> targetNode = parentNode.getNext();
		
		
		while(targetNode != null){//获取待删除节点的父节点
			
			if(targetNode.getE().equals(e)){//找到待删除节点
			
				parentNode.setNext(targetNode.getNext());
				
				--size;
			}
			
			
			parentNode = targetNode;
			targetNode = parentNode.getNext();
		}
	}
	/**
	 * 单向链表节点
	 * @author Kor_Zhang
	 *
	 * @param <E>	节点储存数据泛型
	 */
	static class Node<E> {
		private E e;//数据域
		private Node<E> next;//后继
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
		public Node() {
			super();
		}
		public Node(E e, Node<E> next) {
			super();
			this.e = e;
			this.next = next;
		}
		
		
	}
	
	@Override
	public void clear() {
		super.clear();
		Node<E> cNode = this.headNode.getNext();//当前链表
		Node<E> nNode = null;//下一链表
		for (; cNode != null;) {
			nNode = cNode.getNext();
			//置空
			cNode.setNext(null);
			cNode.setE(null);
			cNode = null;
			--size;
			cNode = nNode;
			
		}
		
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> l = new SingleLinkedList<Integer>();
		try {
//			l.add(11);
//			l.add(3);
//			l.add(2);
//			
//			l.remove(0);
//			l.removeElement(2);
//			l.removeElement(3);
			
			long s = System.currentTimeMillis();
			for(int i = 0;i<200;i++){
				l.add(i);
			}
			/*for(int i = 0;i<20000;i++){
				l.removeElement(i);
			}*/

			l.clear();
			
			System.out.println("用时:"+(System.currentTimeMillis() -s));
			System.out.println(l.toString());
			//System.out.println(l.indexOf(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
