package com.zk.algorithm.tree;
/**
 * 二叉树
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class BinaryTree<E> implements Tree<E> {
	private E e;//数据域
	private BinaryTree<E> lChild;//指向左孩子
	private BinaryTree<E> rChild;//指向右孩子
}
