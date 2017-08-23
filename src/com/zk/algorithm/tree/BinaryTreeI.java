package com.zk.algorithm.tree;
/**
 * 二叉树接口树接口;
 * @author Kor_Zhang
 *
 */
public interface BinaryTreeI<E> {
	/**
	 * 按先序遍历建立树结构
	 * @param elems	树节点的值的数组,如果为null代表空节点
	 */
	void buildRootFirstTree(E[] elems);
	
	/**
	 * 先序遍历访问树
	 * @return
	 */
	String rootFisrtVisit();
}
