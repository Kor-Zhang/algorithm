package com.zk.algorithm.tree;
/**
 * 线索二叉树接口;
 * @author Kor_Zhang
 *
 */
public interface ThreadedBinaryTreeI<E> {
	/**
	 * 根据先序遍历顺序建立线索二叉树;<br/>
	 * 如果节点为空,元素请用null表示;
	 * @param elems	先序遍历的结果;
	 */
	void createTree(E[] elems);
	
	/**
	 * 先序遍历树;
	 * @return	储存先序遍历结果的的集合
	 */
	Object[] rootFirstVisit();
}
