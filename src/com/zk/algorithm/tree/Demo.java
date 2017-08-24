package com.zk.algorithm.tree;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		//输入ABC##DE#G##F###
		String[] elems = new String[]{"A","B","C",null,null,"D","E",null,"G",null,null,"F",null,null,null};
		BinaryTreeI<String> tree = new BinaryTree<String>();
		
		//建立树
		tree.buildRootFirstTree(elems);
		
		System.out.println("visit binary tree");
		//先序遍历
		System.out.println(Arrays.toString(tree.rootFisrtVisit()));
		//中序遍历
		System.out.println(Arrays.toString(tree.rootMiddleVisit()));
		//后序遍历
		System.out.println(Arrays.toString(tree.rootLastVisit()));
		
		
	}

}
