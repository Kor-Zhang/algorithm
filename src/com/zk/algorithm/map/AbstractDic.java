package com.zk.algorithm.map;

import com.zk.algorithm.list.List;

/**
 * 实现基础功能;
 * @author Kor_Zhang
 * @param <K>
 *
 */
public class AbstractDic<K, V> implements Dictionary<K, V> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5913687080199328648L;

	@Override
	public void put(K key, V value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V get(K key, V defaultVal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contain(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("{\"content\":\"");
		for (int i = 0; i < this.keys().size(); i++) {
			K key = this.keys().get(i);
			if(i != this.keys().size() -1){
				sb.append(key+":"+this.get(key)+",");
				
			}else{

				sb.append(key+":"+this.get(key));
			}
		}
		sb.append("\",\"size\":\""+this.size()+"\"}");
		return sb.toString();
	}


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		
	}
	
	

}
