package com.zk.algorithm.string.match;
/**
 * 模式匹配算法接口
 * @author Kor_Zhang
 *
 */
public interface Matcher {
	/**
	 * 模式匹配
	 * @param t	目标串=>主串
	 * @param p	模式串=>子串
	 * @return	子串在主串中的位置:[0,n]
	 */
	int match(String t,String p);

	/**
	 * 
	 * 模式匹配
	 * @param t	目标串=>主串
	 * @param p	模式串=>子串
	 * @param s	子串从p出开始匹配
	 * @return	子串在主串中的位置:[0,n]
	 */
	int match(String t,String p,int s);
}
