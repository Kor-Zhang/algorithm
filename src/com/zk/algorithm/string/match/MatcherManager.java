package com.zk.algorithm.string.match;

/**
 * 字符串的模式匹配采用的策略
 * 
 * @author Kor_Zhang
 *
 */
public class MatcherManager {
	/**
	 * 传入一个比较器和字符串,进行比较;
	 * @param t	主串
	 * @param p	子串
	 * @param m	比较器
	 * @return	子串所在主串中的位置
	 */
	public int match(String t, String p, Matcher m) {
		return m.match(t, p);
	}
	/**
	 * 传入一个比较器和字符串,进行比较;
	 * @param t	主串
	 * @param p	子串
	 * @param s	从主串的p处开始比较
	 * @param m	比较器
	 * @return	子串所在主串中的位置
	 */
	public int match(String t, String p, int s, Matcher m) {
		return m.match(t, p, s);
	}

}
