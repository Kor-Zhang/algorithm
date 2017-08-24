package com.zk.algorithm.tree;
/**
 * 线索二叉树的接口定义
 * @author Kor_Zhang
 */
public class ThreadedBinaryTree<E> implements ThreadedBinaryTreeI<E> {
	
	private TreeNode root;//保存根节点
	
	
	
	
	/**
	 * 树的节点
	 * @author Kor_Zhang
	 *
	 */
	private class TreeNode{
		private E e;
		private ThreadedBinaryTree<E> lchild;
		private ThreadedBinaryTree<E> rchild;
		private int ltag;
		private int rtag;
		public E getE() {
			return e;
		}
		public void setE(E e) {
			this.e = e;
		}
		public ThreadedBinaryTree<E> getLchild() {
			return lchild;
		}
		public void setLchild(ThreadedBinaryTree<E> lchild) {
			this.lchild = lchild;
		}
		public ThreadedBinaryTree<E> getRchild() {
			return rchild;
		}
		public void setRchild(ThreadedBinaryTree<E> rchild) {
			this.rchild = rchild;
		}
		public int getLtag() {
			return ltag;
		}
		public void setLtag(int ltag) {
			this.ltag = ltag;
		}
		public int getRtag() {
			return rtag;
		}
		public void setRtag(int rtag) {
			this.rtag = rtag;
		}
		public TreeNode() {
			super();
		}
		public TreeNode(E e, ThreadedBinaryTree<E> lchild, ThreadedBinaryTree<E> rchild, int ltag, int rtag) {
			super();
			this.e = e;
			this.lchild = lchild;
			this.rchild = rchild;
			this.ltag = ltag;
			this.rtag = rtag;
		}
		@Override
		public String toString() {
			return "TreeNode [e=" + e + ", lchild=" + lchild + ", rchild=" + rchild + ", ltag=" + ltag + ", rtag="
					+ rtag + "]";
		}
		
		
	}
}
