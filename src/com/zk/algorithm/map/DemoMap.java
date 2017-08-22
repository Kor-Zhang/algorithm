package com.zk.algorithm.map;

import java.util.HashMap;
import java.util.Map;

public class DemoMap {
	public static void main(String[] args) {
		long s;

		int n = 10000;
		/**
		 * 测试map
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		s = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {

			map.put("" + i, i);
		}
		// dic.put("0", 11);
		//
		// dic.remove("2");
//		for (int i = 0; i < n; i++) {
//
//			map.remove(i + "");
//		}
		// System.out.println(dic.toString());
		System.out.println((System.currentTimeMillis()) - s);
		/*int num = 1;
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));
		
		num = (num<<31);
		System.out.println(num);
		System.out.println(Integer.toBinaryString(num));*/
		
		Integer[] i = new Integer[11];
		System.out.println(i[0]);
	}
	
	
}
