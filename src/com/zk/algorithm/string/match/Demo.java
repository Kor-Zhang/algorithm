package com.zk.algorithm.string.match;

public class Demo {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		Matcher m = new BF();
		
		MatcherManager mm = new MatcherManager();
		
		String src = "zhangke";
		String target = "zhang";
		
		mm.match(src, target, m);
		
	}

}
