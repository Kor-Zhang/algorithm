package com.zk.algorithm.tree;

import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;

/**
 * 二叉树
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 *            树储存的数据类型
 */
public class SimpleBinaryTree<E> extends AbstractBinaryTree<E> {
	private TreeNode root;// 保存树的根节点

	private int currtElemIndex;// 当前节点值的索引

	private E[] elems;// 节点数据

	private List<E> visitRes = new DoubleLinkedList<E>();// 存储遍历结果

	public SimpleBinaryTree() {
		super();
	}

	/**
	 * 按先序遍历建立树结构
	 * 
	 * @param elems
	 *            elems提供的是一颗满二叉树的先序遍历的各个节点的值,null代表空节点;
	 */
	@Override
	public void buildTree(E[] elems) {
		if (elems.length <= 0) {
			return;
		}

		this.elems = elems;

		this.currtElemIndex = 0;

		this.root = createATreeNode();// 设置当前树的根节点值

		recBuildTree(this.root);// 递归建立根以下的树

	}

	/**
	 * 根据值建立树节点,节点建立后指向下一个值;<br/>
	 * 错误的先序遍历数组将抛出{@link java.lang.ArrayIndexOutOfBoundsException} 异常;
	 * 
	 * @param e
	 *            值域,如果值域为null,那么建立的节点=null
	 * @return 返回创建的节点
	 */
	private TreeNode createATreeNode() {
		try {
			if (elems[currtElemIndex] != null) {
				return new TreeNode(elems[currtElemIndex], null, null);
			} else {
				return null;

			}

		} finally {
			++currtElemIndex;
		}

	}

	/**
	 * 递归建立树 如:ABC##DE#G##F###
	 * 
	 * @param parent
	 *            父节点
	 */
	private void recBuildTree(TreeNode parent) {
		if (parent == null) {
			return;
		}

		// 建立左孩子
		parent.lChild = createATreeNode();

		recBuildTree(parent.lChild);

		// 建立左孩子
		parent.rChild = createATreeNode();
		// 建立右子树
		recBuildTree(parent.rChild);

	}

	@Override
	public Object[] rootFisrtVisit() {
		// 清空结果集
		this.visitRes.clear();
		// 遍历后将结果放入集合visitRes
		recRootFisrtVisit(this.root);
		return visitRes.toArray();
	}

	/**
	 * 递归先序遍历
	 * 
	 * @param parent
	 *            父节点
	 * @return 返回当前结点及其子节点的值域信息
	 */
	private void recRootFisrtVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			// 添加null表示无节点
			visitRes.add(null);
			return;
		}
		// 获取根
		visitRes.add(parent.getE());
		// 递归左子树
		recRootFisrtVisit(parent.lChild);
		// 递归右子树
		recRootFisrtVisit(parent.rChild);

	}

	@Override
	public Object[] rootMiddleVisit() {
		// 清空结果集
		this.visitRes.clear();
		// 遍历后将结果放入集合visitRes
		recRootMiddleVisit(this.root);
		return visitRes.toArray();
	}

	/**
	 * 递归中序遍历
	 * 
	 * @param parent
	 *            父节点
	 */
	private void recRootMiddleVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			// 添加null表示无节点
			visitRes.add(null);
			return;
		}
		// 递归左子树
		recRootMiddleVisit(parent.lChild);
		// 获取根
		visitRes.add(parent.getE());
		// 递归右子树
		recRootMiddleVisit(parent.rChild);
	}

	@Override
	public Object[] rootLastVisit() {
		// 清空结果集
		this.visitRes.clear();
		// 遍历后将结果放入集合visitRes
		recRootLastVisit(this.root);
		return visitRes.toArray();
	}

	/**
	 * 递归后序遍历
	 * 
	 * @param parent
	 */
	private void recRootLastVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			// 添加null表示无节点
			visitRes.add(null);
			return;
		}
		// 递归左子树
		recRootLastVisit(parent.lChild);
		// 递归右子树
		recRootLastVisit(parent.rChild);
		// 获取根
		visitRes.add(parent.getE());
	}

	/**
	 * 树的节点
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private class TreeNode {

		private E e;// 数据域

		private SimpleBinaryTree<E>.TreeNode lChild;// 指向左孩子

		private SimpleBinaryTree<E>.TreeNode rChild;// 指向右孩子

		public E getE() {
			return e;
		}

		public void setE(E e) {
			this.e = e;
		}

		public SimpleBinaryTree<E>.TreeNode getlChild() {
			return lChild;
		}

		public void setlChild(SimpleBinaryTree<E>.TreeNode lChild) {
			this.lChild = lChild;
		}

		public SimpleBinaryTree<E>.TreeNode getrChild() {
			return rChild;
		}

		public void setrChild(SimpleBinaryTree<E>.TreeNode rChild) {
			this.rChild = rChild;
		}

		public TreeNode(E e, SimpleBinaryTree<E>.TreeNode lChild,
				SimpleBinaryTree<E>.TreeNode rChild) {
			super();
			this.e = e;
			this.lChild = lChild;
			this.rChild = rChild;
		}

		public TreeNode() {
			super();
		}

		@Override
		public String toString() {
			return "TreeNode [e=" + e + ", lChild=" + lChild + ", rChild="
					+ rChild + "]";
		}

	}

}
