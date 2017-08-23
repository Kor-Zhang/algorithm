package com.zk.algorithm.tree;

public class Demo {

	public static void main(String[] args) {
		//输入ABC##DE#G##F###
		String[] elems = new String[]{"A","B","C",null,null,"D","E",null,"G",null,null,"F",null,null,null};
		BinaryTreeI<String> tree = new BinaryTree<String>();
		//建立树
		tree.buildRootFirstTree(elems);
		//先序遍历
		System.out.println(tree.rootFisrtVisit());
		//中序遍历
		System.out.println(tree.rootMiddleVisit());
		//后序遍历
		System.out.println(tree.rootLastVisit());
	}

}
