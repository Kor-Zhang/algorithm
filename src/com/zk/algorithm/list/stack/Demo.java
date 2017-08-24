package com.zk.algorithm.list.stack;

public class Demo {

	public static void main(String[] args) {
		Stack<String> s = new LinkedStack<String>();
		s.push("3");
		s.push("2");
		s.push("1");
		s.push("0");
		s.pop();
		s.pop();
		System.out.println(s.size());
		System.out.println(s);
		System.out.println(s.maxSize());
		
		
	}

}
