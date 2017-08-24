package com.zk.algorithm.tree;
/**
 * 双亲孩子表示法储存树;
 * @author Kor_Zhang
 *
 */
public class ParentChildTree<E>{
	
	private TreeNode<E>[] treeNodes;//树的所有节点
	
	private int root;//根节点位置
	
	private int length;//树的节点数
	
	
	
	/**
	 * 树节点,存放在数组
	 * @author Kor_Zhang
	 *
	 */
	public static class TreeNode<E>{
		int parent;//父节点的下标
		E e;//储存的元素
		ChildNode firstChild;//指向第一个孩子节点
	} 
	
	/**
	 * 储存孩子下标的节点,存放在树节点的链表中
	 * @author Kor_Zhang
	 *
	 */
	public static class ChildNode{
		int child;//当前孩子的下标
		ChildNode next;//指向下一个下一个孩子
		public int getChild() {
			return child;
		}
		public void setChild(int child) {
			this.child = child;
		}
		public ChildNode getNext() {
			return next;
		}
		public void setNext(ChildNode next) {
			this.next = next;
		}
		public ChildNode(int child, ChildNode next) {
			super();
			this.child = child;
			this.next = next;
		}
		public ChildNode() {
			super();
		}
		
	}

}
