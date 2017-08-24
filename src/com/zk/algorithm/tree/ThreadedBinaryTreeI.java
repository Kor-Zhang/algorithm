package com.zk.algorithm.tree;

/**
 * 线索二叉树接口;
 * 
 * @author Kor_Zhang
 *
 */
public interface ThreadedBinaryTreeI<E> {
	/**
	 * 根据先序遍历顺序建立线索二叉树;<br/>
	 * 
	 * @param elems
	 *            elems提供的是一颗满二叉树的先序遍历的各个节点的值,null代表空节点;
	 */
	void createTree(E[] elems);

	/**
	 * 先序遍历树;
	 * 
	 * @return 储存先序遍历结果的的集合
	 */
	Object[] rootFirstVisit();
	
	/**
	 * 将树线索化
	 */
	void threadTree();
}
