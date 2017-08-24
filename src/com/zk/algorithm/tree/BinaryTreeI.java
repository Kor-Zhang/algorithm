package com.zk.algorithm.tree;

/**
 * 二叉树接口;
 * 
 * @author Kor_Zhang
 *
 */
public interface BinaryTreeI<E> {
	/**
	 * 按先序遍历建立树结构
	 * 
	 * @param elems
	 *            elems提供的是一颗满二叉树的先序遍历的各个节点的值,null代表空节点;
	 */
	void buildRootFirstTree(E[] elems);

	/**
	 * 先序遍历访问树
	 * 
	 * @return 储存遍历结果的集合
	 */
	Object[] rootFisrtVisit();

	/**
	 * 中序遍历访问树
	 * 
	 * @return 储存遍历结果的集合
	 */
	Object[] rootMiddleVisit();

	/**
	 * 后序遍历访问子树
	 * 
	 * @return 储存遍历结果的集合
	 */
	Object[] rootLastVisit();
}
