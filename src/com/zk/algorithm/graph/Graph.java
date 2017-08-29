package com.zk.algorithm.graph;

import com.zk.algorithm.graph.Dijkstra.DijkstraNode;
import com.zk.algorithm.graph.Kruskal.KruskalEdge;
import com.zk.algorithm.list.List;

/**
 * 图结构接口
 * 
 * @author Kor_Zhang
 *
 */
public interface Graph {
	/**
	 * 表示邻接矩阵中两节点之间没有路径
	 */
	public final static Integer NOWEIGHT = -1;

	/**
	 * 克鲁斯卡尔实现最小生成树;<br/>
	 * 使用边表对边进行选择,更多关注的是边,而不是顶端;<br/>
	 */
	List<KruskalEdge> kruskal();

	/**
	 * 
	 * dijstra算法求单源最短路径;<br/>
	 * 即startV到所有顶点的最短路径;
	 * 
	 * @param startV
	 *            开始顶点
	 * @return startV到各顶点的最短路径信息
	 */
	List<DijkstraNode> dijkstra(Integer startV);

	/**
	 * 传入邻接矩阵,保存之;
	 * 
	 * @param adjacentMatrix
	 *            邻接矩阵
	 */
	void buildAdjacentMatrix(Integer[][] adjacentMatrix);

	/**
	 * 图的深度优先搜索
	 * 
	 * @param startV
	 *            开始遍历的节点
	 * @return 返回搜索后的顶点序列的代号
	 */
	List<Integer> DFS(Integer startV);

	/**
	 * 图的广度优先搜索
	 * 
	 * @param startV
	 *            开始遍历的节点
	 * @return 返回搜索后的顶点序列的代号
	 */
	List<Integer> WFS(Integer startV);

}
