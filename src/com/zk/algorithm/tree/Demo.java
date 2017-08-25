package com.zk.algorithm.tree;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.zk.algorithm.list.DoubleLinkedList;

public class Demo {

	public static void main(String[] args) {
		
		//输入例如ABC##DE#G##F###
		String[] elems = new String[]{"A","B","C",null,null,"D","E",null,"G",null,null,"F",null,null,null};
		BinaryTree<String> tree = new SimpleBinaryTree<String>();
		 
		//建立树
		tree.buildTree(elems);
		
		System.out.println("visit binary tree");
		//先序遍历
		System.out.println(Arrays.toString(tree.rootFisrtVisit()));
		//中序遍历
		System.out.println(Arrays.toString(tree.rootMiddleVisit()));
		//后序遍历
		System.out.println(Arrays.toString(tree.rootLastVisit()));
		
		

		System.out.println("------------Huffman tree----------");
		HuffmanTree ht = new HuffmanTree();
		
		Character[] cs = new Character[]{'i','i','i','a','a','m',' ','z','k'};
		ht.buildTree(cs);
		
		
		
	}

}
