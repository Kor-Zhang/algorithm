package com.zk.algorithm.tree;
/**
 * 哈夫曼树
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class HuffmanTree extends AbstractBinaryTree<Character> {
	@Override
	public void buildTree(Character[] elems) {
		super.buildTree(elems);
		
		//统计字符数组中每个ascii码出现的次数
		int[] asciiCount = countAscii(elems);
		
		
		
	}
	/**
	 * 统计字符数组中每个ascii码出现的次数
	 * @param elems	待统计的数据
	 * @return	统计结果
	 */
	private int[] countAscii(Character[] elems) {
		//记录ascii码出现的次数
		int[] asciiCount = new int[256];
		
		//统计elems字符数组中的字符次数
		for (int i = 0; i < elems.length; i++) {
			asciiCount[elems[i]] ++;
		}
		return asciiCount;
	}
	
	
}
