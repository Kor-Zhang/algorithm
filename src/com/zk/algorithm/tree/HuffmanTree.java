package com.zk.algorithm.tree;

/**
 * huffman树接口;
 * 
 * @author Kor_Zhang
 *
 */
public interface HuffmanTree<E> {
	/**
	 * 通过提供的样本数据建立树huffman树
	 * 
	 * @param elems
	 *            建立树所需要的样本数据
	 * 
	 */
	void buildTree(E[] elems);

	/**
	 * 对数据进行编码
	 * 
	 * @param elems
	 *            待编码的数据
	 * @return 返回编码
	 */
	String encode(E[] elems);

	/**
	 * 对huffman编码进行解码
	 * 
	 * @param huffmanCodes
	 *            待解码的huffman编码
	 * @return 返回解码后的数据
	 */
	E[] decode(String huffmanCodes);
}
