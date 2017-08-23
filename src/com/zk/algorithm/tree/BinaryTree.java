package com.zk.algorithm.tree;
/**
 * 二叉树
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class BinaryTree<E> implements BinaryTreeI<E> {
	private TreeNode root;//保存树的根节点
	
	private int elemIndex;//当前节点需要使用的值的索引
	
	@Override
	public void buildRootFirstTree(E[] elems) {
		this.root = new TreeNode(elems[0], null, null);//设置当前树的根节点值
		
		++elemIndex;
		
		recBuildTree(this.root, elems);//递归建立根以下的树
		
	}
	/**
	 * 根据根节点递归建立树
	 * @param tree
	 * @param elems
	 * @param index
	 */
	private void recBuildTree(TreeNode tree,E[] elems){
		if(elemIndex < elems.length){//如果还有待插入的数据
			//建立左孩子
			tree.lChild = new TreeNode(elems[elemIndex++], null, null);
			
			recBuildTree(tree.lChild, elems);
			
			
			
		}
		if(elemIndex < elems.length){
			//建立右孩子
			tree.rChild = new TreeNode(elems[elemIndex++], null, null);
			
			recBuildTree(tree.rChild, elems);
		}
	}
	@Override
	public String rootFisrtVisit() {
		
		
		return recRootFisrtVisit(this.root);
	} 
	/**
	 * 递归先序遍历
	 * @param treeNode
	 * @return
	 */
	private String recRootFisrtVisit(TreeNode treeNode){
		
		if(treeNode == null){//如果为空,表示没有节点,结束递归
			return null;
		}
		StringBuffer sb = new StringBuffer("");
		//获取根
		sb.append(treeNode.getE()+"  ");
		
		String t = null;
		//递归左子树
		t = recRootFisrtVisit(treeNode.lChild);
		if(t!=null){
			sb.append(t);
		}
		//递归右子树
		t = recRootFisrtVisit(treeNode.rChild);
		if(t!=null){
			sb.append(t);
		}
		
		return sb.toString();
	}
	
	public BinaryTree() {
		super();
	}


	/**
	 * 树的节点
	 * @author Kor_Zhang
	 *
	 */
	private class TreeNode{

		private E e;//数据域
		
		private BinaryTree<E>.TreeNode lChild;//指向左孩子
		
		private BinaryTree<E>.TreeNode rChild;//指向右孩子
		

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

		
	}



	
}
