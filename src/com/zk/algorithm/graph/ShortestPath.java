package com.zk.algorithm.graph;

import com.zk.algorithm.list.List;

/**
 * 最短路径接口;
 * @author Kor_Zhang
 * @param <R>算法返回结果类型
 * @see Dijkstra
 */
public interface ShortestPath<R> {
	/**
	 * 计算startV到图中其他顶点的最短路径;
	 * @param adjacentMatrix	图的邻接矩阵
	 * @return	返回计算结果
	 */
	List<R> produce(Integer[][] adjacentMatrix,Integer startV);
}
