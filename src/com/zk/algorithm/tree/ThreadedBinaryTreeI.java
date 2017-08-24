package com.zk.algorithm.tree;
/**
 * 线索二叉树接口;
 * @author Kor_Zhang
 *
 */
public interface ThreadedBinaryTreeI<E> {
	/**
	 * 根据先序遍历顺序建立线索二叉树;
	 * @param elems	先序遍历的结果;
	 */
	void createTree(E[] elems);
	
	E
}
