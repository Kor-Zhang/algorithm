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
	
	private TreeNode preNode;//刚才访问过的节点
	
	private List<E> visitRes = new DoubleLinkedList<E>();//保存遍历结果的集合
	
	/**
	 * 根据参数elems和currtElemIndex创建一个树节点并且返回;<br/>
	 * 错误的先序遍历数组将抛出{@link java.lang.ArrayIndexOutOfBoundsException}}异常;<br/>
	 * 该节点的左右子树为空,左右线索标志为false;
	 * @return	新建的树节点
	 */
	private TreeNode createATreeNode(){
		//不是通过elems下标来判断的
		try {
			if (elems[currtElemIndex] != null) {
				return new TreeNode(elems[currtElemIndex], null, null,false,false);
			} else {
				return null;

			}

		} finally {
			++currtElemIndex;
		}
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
		if(parent ==null){//如果当前节点为空,那么不会继续往下创建树
			return ;
		}
		//递归左子树
		parent.lchild = createATreeNode();
		
		recCreateTree(parent.lchild);
		
		//递归右子树
		parent.rchild = createATreeNode();
		
		recCreateTree(parent.rchild);
		
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

	@Override
	public void threadTree() {
		//通过中序遍历线索化树
	}
	/**
	 * 递归线索化树
	 * @param parent	父节点
	 */
	private void recThreadTree(TreeNode parent){
		if(parent == null ){
			return ;
		}
		//递归左子树
		recCreateTree(parent.lchild);
		
		/******线索化当前节点 statrt******/
		//前驱=>因为中序遍历中,左孩子先于根节点遍历,所以左孩子是前驱
		if((parent.leftIsThread = parent.lchild == null) == true){
			parent.lchild = preNode;
		}
		//后继=>因为无法确定当前节点的后继,所以我们选择确定上一个节点的后继
		if((preNode.rightIsThread = preNode.rchild == null) == true){
			preNode.rchild = parent;
		}
		//保存上一个节点
		preNode = parent;
		/******线索化当前节点 end******/
		
		//递归右子树
		recCreateTree(parent.rchild);
		
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
