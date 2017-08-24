package com.zk.algorithm.map;

public class DemoDic {

	public static void main(String[] args) {

		long s;

		int n = 100000;

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
