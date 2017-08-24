package com.zk.algorithm.map;

import java.lang.reflect.Array;

import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;

/**
 * 利用hash实现的字典;
 * @author Kor_Zhang
 *
 * @param <K>	键类型;
 * @param <V>	值类型;
 */
public class HashDic<K, V> extends AbstractDic<K, V> {
	/**
	 * hashtable的长度
	 */
	private final static int TABLE_SIZE = 16;
	/**
	 * 储存数据的hashtable
	 */
	private DoubleLinkedList<Node<K, V>>[] hashTable = null;
	/**
	 * 储存数据的数量
	 */
	private int size;
	/**
	 * 临时节点储存
	 */
	private Node<K,V> tNode;
	/**
	 * 所有的键的集合,用于{@link this#keys()}临时存储并返回
	 */
	private List<K> keys = null;
	/**
	 * 所有的值的集合,用于{@link this#values()}临时存储并返回
	 */
	private List<V> values = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7155117279196549692L;

	/**
	 * 初始化
	 */
	public HashDic() {
		super();
		
		this.hashTable = (DoubleLinkedList<Node<K, V>>[]) Array.newInstance(DoubleLinkedList.class, TABLE_SIZE);
		
		this.size = 0;
		
		keys = new DoubleLinkedList<K>();
		
		values = new DoubleLinkedList<V>();
		
	}
	
	/**
	 * 通过key获取不大于TABLE_SIZE的hashcode;<br/>
	 * @param key	键
	 */
	private int hash(K key){
		
		return (key.hashCode()%TABLE_SIZE);
	}
	/**
	 * 计算key的hashcode,<br/>
	 * 然后在hashtable中寻找其应该存放的位置,<br/>
	 * 取出该位置的链表;
	 * @param key	键
	 */
	private DoubleLinkedList<Node<K, V>> indexHouse(K key) {
		int h = hash(key);
		if(hashTable[h] == null){//初始化链表
			hashTable[h] = new DoubleLinkedList<Node<K,V>>();
		}
		return hashTable[h];
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean contain(K key) {

		DoubleLinkedList<Node<K, V>> house = indexHouse(key);
		
		tNode = new Node<K,V>(key, null);
		
		return house.indexOf(tNode)>0?true:false;
	}
	
	@Override
	public V get(K key, V defaultVal) {
		
		DoubleLinkedList<Node<K, V>> house = indexHouse(key);

		tNode = new Node<K,V>(key, null);
		
		int pos = house.indexOf(tNode);
		
		if(pos < 0){
			return null;
		}
		
		return house.get(pos).getValue();
	}
	@Override
	public V get(K key) {
		return this.get(key, null);
	}
	@Override
	public void put(K key, V value) {

		super.put(key, value);
		
		DoubleLinkedList<Node<K, V>> house = indexHouse(key);
		
		Node<K, V> newMember = new Node<K, V>(key, value);
		
		//判断是否已存在key相同的节点
		int res = house.indexOf(newMember);
		
		if(res < 0){
			house.add(newMember);
		}else{
			house.get(res).setKey(key);
			house.get(res).setValue(value);
		}
		
		++size;
	}
	

	@Override
	public void remove(K key) {
		super.remove(key);


		DoubleLinkedList<Node<K, V>> house = indexHouse(key);
		
		tNode = new Node<K,V>(key, null);
		
		house.removeElement(tNode);
		
		--size;
	}
	@Override
	public List<K> keys() {
		
		keys.clear();
		for (int i = 0; i < hashTable.length; i++) {
			DoubleLinkedList<Node<K, V>> house = hashTable[i];
			if(house!=null){
				for (int j = 0; j < house.size(); j++) {
					this.keys.add(house.get(j).getKey());
				}
			}
			
		}
		return this.keys;
	}
	@Override
	public List<V> values() {
		values.clear();
		for (int i = 0; i < hashTable.length; i++) {
			DoubleLinkedList<Node<K, V>> house = hashTable[i];
			if(house!=null){
				for (int j = 0; j < house.size(); j++) {
					this.values.add(house.get(j).getValue());
				}
			}
			
		}
		
		return this.values;
	}
	
	/**
	 * 储存于hashtable的节点;<br/>
	 * 
	 * <pre>
	 * 包含两大信息:
	 * 	*.key 键
	 * 	*.value	值
	 * </pre>
	 * 
	 * @author Kor_Zhang
	 *
	 */
	private static class Node<K,V> {

		/**
		 * 键
		 */
		private K key;
		/**
		 * 值
		 */
		private V value;

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		

		public Node(K key, V value) {
			super();
			this.key = key;
			this.value = value;
		}

		public Node() {
			super();
		}

		/**
		 * 定义Node对象相等的标准
		 */
		@Override
		public boolean equals(Object obj) {
			return this.key.equals(((Node<K,V>) obj).getKey());
		}

	}
	
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {

		long s;

		int n = 20000;

		/**
		 * 测试dic
		 */
		Dictionary<String, Integer> dic = new HashDic<String, Integer>();
		s = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {

			dic.put("" + i, i);
		}
//		 dic.put("0", 11);
//		
//		dic.remove("2");
//		for (int i = 0; i < n; i++) {
//
//			dic.remove(i + "");
//		}
//		 System.out.println(dic.toString());
		System.out.println((System.currentTimeMillis()) - s);

	}
	
}
