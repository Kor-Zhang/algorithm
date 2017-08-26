package com.zk.algorithm.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.zk.algorithm.list.queue.AbstractQueue;
import com.zk.algorithm.list.queue.Queue;

/**
 * 可以对ascii进行编码解码的huffman树;<br/>
 * 注意:待编码的数据只会出现在huffman树的叶子节点,即其左右子树为null
 * 
 * @author Kor_Zhang
 *
 * @param <E>
 */
public class AsciiHuffmanTree implements HuffmanTree<Character> {
	// 最小权重在前的队列
	private Queue<HTNode> queue = new MinWeightFirstQueue();
	// huffman树的根
	private HTNode root;
	// 临时缓存节点
	private HTNode cacheHTNode;
	// 储存每个ascii的huffman编码
	private Map<Integer, String> ascii2HuffmanCode = new HashMap<Integer, String>();
	// 储存每个huffman编码的ascii
	private Map<String, Integer> huffmanCode2Ascii = new HashMap<String, Integer>();

	@Override
	public void buildTree(Character[] elems) {

		root = null;

		// 统计字符数组中每个ascii码的权重
		int[] asciiWeight = countAsciiWeight(elems);
		// 添加到队列
		addToQueue(asciiWeight);
		// 生成huffman树,获取huffman树的根节点
		buildHuffmanTree();
		// 设置每个值节点的huffman编码,并且将节点的值加入到asciiHuffmanCode
		setNodeHuffmanCode();

	}

	/**
	 * 生成huffman树,返回根元素;<br/>
	 * 过程:取出queue中的最前面的两个元素,进行"合并",放回queue;当queue==1时表示建立哈夫曼树成功;
	 */
	private void buildHuffmanTree() {
		while (true) {// 循环获取huffman节点
			HTNode max = queue.delete();// 获取最小节点
			HTNode min = queue.delete();// 获取最小节点

			if (min.compareTo(max) == 1) {// 判断节点大小
				swap(max, min);
			}
			// 建立新的节点放入queue
			cacheHTNode = new HTNode(min, max, null, min.weight + max.weight);

			queue.add(cacheHTNode);// 添加新节点到huffman树

			if (queue.size() == 1) {// 判断是否树已经生成完毕
				root = queue.delete();
				break;
			}
		}
	}

	/**
	 * 建立huffman树中的每个值节点的huffman编码
	 */
	private void setNodeHuffmanCode() {
		// 递归树设置树节点的huffman编码
		recSetHuffmanNodeCode(root, "");
	}

	/**
	 * 递归遍历树获取ascii的编码
	 * 
	 * @param parent
	 *            父节点
	 * @param floorHuffmanCode
	 *            当前节点的huffman编码
	 */
	private void recSetHuffmanNodeCode(HTNode parent, String floorHuffmanCode) {
		if (parent.l == null && parent.r == null) {// 到达待编码的节点
			// 设置其编码
			parent.huffmanCode = floorHuffmanCode;

			ascii2HuffmanCode.put(parent.ascii, floorHuffmanCode);
			huffmanCode2Ascii.put(floorHuffmanCode, parent.ascii);
		}
		// 遍历左子树,左走加0
		if (parent.l != null) {
			// floorHuffmanCode = floorHuffmanCode + "0";错误的做法,将影响下面右子树的编码
			// 递归左子树
			recSetHuffmanNodeCode(parent.l, floorHuffmanCode + "0");
		}
		// 遍历右子树,右走加1
		if (parent.r != null) {

			// 递归右子树
			recSetHuffmanNodeCode(parent.r, floorHuffmanCode + "1");

		}
	}

	/**
	 * 交换两个元素
	 * 
	 * @param e0
	 * @param e1
	 */
	private <E> void swap(E e0, E e1) {
		E e = e0;
		e0 = e1;
		e1 = e;
	}

	/**
	 * 创建节点并且添加到队列
	 * 
	 * @param asciiWeight
	 *            ascii及其权重
	 */
	private void addToQueue(int[] asciiWeight) {
		for (int i = 0; i < asciiWeight.length; i++) {
			int count = asciiWeight[i];
			if (count > 0) {
				// 添加一个huffman树节点
				queue.add(new HTNode(null, null, i, count));
			}
		}
	}

	/**
	 * 统计字符数组中每个ascii码的权重(这里的权重即ascii码出现的次数)
	 * 
	 * @param elems
	 *            待统计的数据
	 * @return 统计结果
	 */
	private int[] countAsciiWeight(Character[] elems) {
		// 记录ascii码出现的次数
		int[] asciiCount = new int[256];

		// 统计elems字符数组中的字符次数
		for (int i = 0; i < elems.length; i++) {
			asciiCount[elems[i]]++;
		}
		return asciiCount;
	}

	/**
	 * 最小权重的树节点在前的队列
	 * 
	 * @author Kor_Zhang
	 * @param <E>
	 *            队列存放的数据类型
	 *
	 */
	private class MinWeightFirstQueue extends AbstractQueue<HTNode> {
		private QueueNode headNode;// 头结点
		private Integer size;// 队列大小
		private QueueNode cacheQueueNode;// 缓存节点

		public MinWeightFirstQueue() {
			super();
			headNode = new QueueNode(null, null);// 初始化头结点

			size = 0;// 初始化长度
		}

		/**
		 * 根据其权重插入节点,次序是从小到大
		 */
		@Override
		public boolean add(HTNode e) {
			cacheQueueNode = this.headNode;
			// 遍历找到合适插入位置
			while (cacheQueueNode.next != null
					&& e.compareTo(cacheQueueNode.next.getE()) == 1) {
				cacheQueueNode = cacheQueueNode.next;
			}
			// 插入队列合适位置
			QueueNode newNode = new QueueNode(e, cacheQueueNode.next);

			cacheQueueNode.next = newNode;

			++size;

			return true;
		}

		/**
		 * 获取权重最小的节点
		 */
		@Override
		public HTNode delete() {
			cacheQueueNode = this.headNode.next;

			this.headNode.next = this.headNode.next.next;

			--size;

			return cacheQueueNode.getE();
		}

		/**
		 * 返回size
		 */
		@Override
		public int size() {
			return this.size;
		}

	}

	@Override
	public String encode(Character[] elems) {
		String huffmanCode = "";
		for (int i = 0; i < elems.length; i++) {
			huffmanCode += ascii2HuffmanCode.get(((int) elems[i]));
		}
		return huffmanCode;
	}

	@Override
	public Character[] decode(String huffmanCodes) {
		String res = "";
		String currt = "";
		Set<String> keys = huffmanCode2Ascii.keySet();
		for (int i = 0; i < huffmanCodes.length(); i++) {
			currt += huffmanCodes.charAt(i);//记录当前编码
			for (String k : keys) {
				if(currt.equals(k)){
					String v = String.valueOf(((char)huffmanCode2Ascii.get(k).intValue()));
					res += v;
					currt = "";
				}
				
			}
		}
		
		Character[] chs = new Character[res.length()];
		for (int i = 0; i < chs.length; i++) {
			chs[i] = res.charAt(i);
		}
		return chs;
	}

	/**
	 * 权值小的节点在前的队列节点
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private class QueueNode {
		private HTNode e;// 队列节点的数据域
		private QueueNode next;// 队列节点的指针域

		public HTNode getE() {
			return e;
		}

		public void setE(HTNode e) {
			this.e = e;
		}

		public QueueNode getNext() {
			return next;
		}

		public void setNext(QueueNode next) {
			this.next = next;
		}

		public QueueNode(HTNode e, QueueNode next) {
			super();
			this.e = e;
			this.next = next;
		}

		public QueueNode() {
			super();
		}

	}

	/**
	 * huffman树节点
	 * 
	 * @author Kor_Zhang
	 * @param <E>
	 *
	 */
	private class HTNode implements Comparable<HTNode> {
		private HTNode l, r;// huffman树的左右节点

		private Integer ascii;// ascii码

		private Integer weight;// 该节点权重

		private String huffmanCode;// 该节点的huffman编码

		public HTNode(HTNode l, HTNode r, Integer ascii, Integer weight) {
			super();
			this.l = l;
			this.r = r;
			this.ascii = ascii;
			this.weight = weight;
			this.huffmanCode = null;
		}

		@Override
		public int compareTo(HTNode o) {
			return this.weight > o.weight ? 1 : (this.weight == o.weight ? 0
					: -1);
		}

		@Override
		public String toString() {
			return "HTNode [l=" + l + ", r=" + r + ", ascii="
					+ ((char) ascii.intValue()) + ", weight=" + weight
					+ ", huffmanCode=" + huffmanCode + "]";
		}

	}

	/**
	 * table
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private class HTTable {
		private HTNode first, last;

		public HTTable() {
			super();
			// TODO Auto-generated constructor stub
		}

		public HTTable(HTNode first, HTNode last) {
			super();
			this.first = first;
			this.last = last;
		}

		public HTNode getFirst() {
			return first;
		}

		public void setFirst(HTNode first) {
			this.first = first;
		}

		public HTNode getLast() {
			return last;
		}

		public void setLast(HTNode last) {
			this.last = last;
		}

	}

}
