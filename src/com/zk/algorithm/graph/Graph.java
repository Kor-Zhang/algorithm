package com.zk.algorithm.graph;

import com.zk.algorithm.list.List;

/**
 * 图结构接口
 * 
 * @author Kor_Zhang
 *
 */
public interface Graph {
	/**
	 * 
	 * dijstra算法求最短路径
	 * 
	 * @param startV
	 *            开始顶点
	 * @param endV
	 *            结束顶点
	 * @return 最短路径的顶点的代号
	 */
	List<Integer> dijstra(Integer startV, Integer endV);

	/**
	 * 传入邻接矩阵,保存之;
	 * 
	 * @param adjacentMatrix
	 *            邻接矩阵
	 */
	void buildAdjacentMatrix(Integer[][] adjacentMatrix);

	
	/**
	 * 图的深度优先搜索
	 * @param startV	开始遍历的节点
	 * @return	返回搜索后的顶点序列的代号
	 */
	List<Integer> DFS(Integer startV);

	
	/**
	 * 图的广度优先搜索
	 * @param startV	开始遍历的节点
	 * @return	返回搜索后的顶点序列的代号
	 */
	List<Integer> WFS(Integer startV);

}
