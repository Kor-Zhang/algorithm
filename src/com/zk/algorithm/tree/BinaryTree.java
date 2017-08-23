package com.zk.algorithm.tree;

/**
 * 二叉树
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 *            树储存的数据类型
 */
public class BinaryTree<E> implements BinaryTreeI<E> {
	private TreeNode root;// 保存树的根节点

	private int currtElemIndex;// 当前节点值的索引

	private E[] elems;// 节点数据

	public BinaryTree() {
		super();
	}

	@Override
	public void buildRootFirstTree(E[] elems) {
		if (elems.length <= 0) {
			return;
		}

		this.elems = elems;

		this.currtElemIndex = 0;

		this.root = createATreeNode();// 设置当前树的根节点值

		recBuildTree(this.root);// 递归建立根以下的树

	}

	/**
	 * 根据值建立树节点,节点建立后指向下一个值
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
	 * 根据根节点递归建立树 如:ABC##DE#G##F###
	 * 
	 * @param parent
	 *            父节点
	 */
	private void recBuildTree(TreeNode parent) {
		if (parent == null) {
			return;
		}

		if (currtElemIndex < elems.length) {// 如果还有待插入的数据
			// 建立左孩子
			parent.lChild = createATreeNode();

			recBuildTree(parent.lChild);

		}
		if (currtElemIndex < elems.length) {
			// 建立左孩子
			parent.rChild = createATreeNode();
			// 建立右子树
			recBuildTree(parent.rChild);

		}
	}

	@Override
	public String rootFisrtVisit() {

		return recRootFisrtVisit(this.root);
	}

	/**
	 * 递归先序遍历
	 * 
	 * @param parent
	 *            父节点
	 * @return 返回当前结点及其子节点的值域信息
	 */
	private String recRootFisrtVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			return "#";
		}
		StringBuffer sb = new StringBuffer("");
		// 获取根
		sb.append(parent.getE());

		// 递归左子树
		sb.append(recRootFisrtVisit(parent.lChild));
		// 递归右子树
		sb.append(recRootFisrtVisit(parent.rChild));

		return sb.toString();
	}

	@Override
	public String rootMiddleVisit() {

		return recRootMiddleVisit(this.root);
	}

	/**
	 * 递归中序遍历
	 * 
	 * @param parent
	 *            父节点
	 * @return 返回当前结点及其子节点的值域信息
	 */
	private String recRootMiddleVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			return "#";
		}
		StringBuffer sb = new StringBuffer("");
		// 递归左子树
		sb.append(recRootMiddleVisit(parent.lChild));
		// 获取节点信息
		sb.append(parent.getE());
		// 递归右子树
		sb.append(recRootMiddleVisit(parent.rChild));

		return sb.toString();
	}

	@Override
	public String rootLastVisit() {

		return recRootLastVisit(this.root);
	}

	/**
	 * 递归中序遍历
	 * 
	 * @param parent
	 * @return
	 */
	private String recRootLastVisit(TreeNode parent) {

		if (parent == null) {// 如果为空,表示没有节点,结束递归
			return "#";
		}
		StringBuffer sb = new StringBuffer("");
		// 递归左子树
		sb.append(recRootLastVisit(parent.lChild));
		// 递归右子树
		sb.append(recRootLastVisit(parent.rChild));
		// 获取节点信息
		sb.append(parent.getE());

		return sb.toString();
	}

	/**
	 * 树的节点
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private class TreeNode {

		private E e;// 数据域

		private BinaryTree<E>.TreeNode lChild;// 指向左孩子

		private BinaryTree<E>.TreeNode rChild;// 指向右孩子

		public E getE() {
			return e;
		}

		public void setE(E e) {
			this.e = e;
		}

		public BinaryTree<E>.TreeNode getlChild() {
			return lChild;
		}

		public void setlChild(BinaryTree<E>.TreeNode lChild) {
			this.lChild = lChild;
		}

		public BinaryTree<E>.TreeNode getrChild() {
			return rChild;
		}

		public void setrChild(BinaryTree<E>.TreeNode rChild) {
			this.rChild = rChild;
		}

		public TreeNode(E e, BinaryTree<E>.TreeNode lChild, BinaryTree<E>.TreeNode rChild) {
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
			return "TreeNode [e=" + e + ", lChild=" + lChild + ", rChild=" + rChild + "]";
		}

	}

}
