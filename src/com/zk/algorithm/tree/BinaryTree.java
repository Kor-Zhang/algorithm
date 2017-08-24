package com.zk.algorithm.tree;

/**
 * 二叉树接口;
 * 
 * @author Kor_Zhang
 *
 */
public interface BinaryTree<E> {
	/**
	 * 建立树结构
	 * 
	 * @param elems
	 *            建立树所需要的数据
	 * 
	 */
	void buildTree(E[] elems);

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
