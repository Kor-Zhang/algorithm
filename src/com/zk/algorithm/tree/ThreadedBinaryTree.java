package com.zk.algorithm.tree;

import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;

/**
 * 线索二叉树的接口定义
 * @author Kor_Zhang
 */
public class ThreadedBinaryTree<E> implements ThreadedBinaryTreeI<E> {
	
	private TreeNode root;//保存根节点
	
	private E[] elems;//树的元素
	
	private int currtElemIndex;//当前需要使用的元素的索引
	
	private List<E> visitRes = new DoubleLinkedList<E>();//保存遍历结果的集合
	
	/**
	 * 根据参数elems和currtElemIndex创建一个树节点并且返回;<br/>
	 * 该节点的左右子树为空,左右线索标志为false;
	 * @return	新建的树节点
	 */
	private TreeNode createATreeNode(){

		TreeNode node = null;
		if(currtElemIndex < elems.length){
			node = new TreeNode(elems[currtElemIndex++], null, null, false, false);
		}
		
		return node;
	}
	

	@Override
	public void createTree(E[] elems) {
		//初始化参数
		this.elems = elems;
		
		this.currtElemIndex = 0;

		//创建根节点
		this.root = createATreeNode();
		
		//递归实现树结构
		recCreateTree(this.root);
		
	}
	/**
	 * 递归建立一个以parent为根的线索二叉树;
	 * @param parent	父节点
	 */
	private void recCreateTree(TreeNode parent){
		
		if(parent != null){
			//递归左子树
			parent.lchild = createATreeNode();
			
			recCreateTree(parent.lchild);
			
			//递归右子树
			parent.rchild = createATreeNode();
			
			recCreateTree(parent.rchild);
		}
	}
	
	@Override
	public Object[] rootFirstVisit() {
		this.visitRes.clear();//清空集合

		recRootFirstVisit(this.root);//从根开始递归遍历
		
		return visitRes.toArray();//返回储存遍历结果的visitRes集合1
	}
	/**
	 * 递归先序遍历
	 * @param parent	父节点
	 */
	private void recRootFirstVisit(TreeNode parent) {
		
		if(parent == null){//如果当前节点为空,表示其是一个空节点;
			visitRes.add(null);
			return;
		}
		
		visitRes.add(parent.getE());//获取根
		
		recRootFirstVisit(parent.lchild);//递归左子树

		recRootFirstVisit(parent.rchild);//递归右子树
		
	}

	/**
	 * 树的节点;
	 * @author Kor_Zhang
	 *
	 */
	private class TreeNode{
		private E e;//值域
		private TreeNode lchild;//左子树指针
		private TreeNode rchild;//右子树指针
		//线索标志位
		private boolean leftIsThread = false;
		private boolean rightIsThread = false;
		public TreeNode() {
			super();
		}
		public TreeNode(E e, ThreadedBinaryTree<E>.TreeNode lchild, ThreadedBinaryTree<E>.TreeNode rchild,
				boolean leftIsThread, boolean rightIsThread) {
			super();
			this.e = e;
			this.lchild = lchild;
			this.rchild = rchild;
			this.leftIsThread = leftIsThread;
			this.rightIsThread = rightIsThread;
		}
		public E getE() {
			return e;
		}
		public void setE(E e) {
			this.e = e;
		}
		public TreeNode getLchild() {
			return lchild;
		}
		public void setLchild(TreeNode lchild) {
			this.lchild = lchild;
		}
		public TreeNode getRchild() {
			return rchild;
		}
		public void setRchild(TreeNode rchild) {
			this.rchild = rchild;
		}
		public boolean isLeftIsThread() {
			return leftIsThread;
		}
		public void setLeftIsThread(boolean leftIsThread) {
			this.leftIsThread = leftIsThread;
		}
		public boolean isRightIsThread() {
			return rightIsThread;
		}
		public void setRightIsThread(boolean rightIsThread) {
			this.rightIsThread = rightIsThread;
		}
		@Override
		public String toString() {
			return "TreeNode [e=" + e + ", lchild=" + lchild + ", rchild=" + rchild + ", leftIsThread=" + leftIsThread
					+ ", rightIsThread=" + rightIsThread + "]";
		}
		
		
		
		
	}


}
