package com.zk.algorithm.graph;

import com.zk.algorithm.graph.Dijkstra.DijkstraNode;
import com.zk.algorithm.graph.Kruskal.KruskalEdge;
import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;
import com.zk.algorithm.list.queue.LinkedQueue;
import com.zk.algorithm.list.queue.Queue;

/**
 * 无向带权图,即无向网
 * 
 * @author Kor_Zhang
 *
 */
public class UndirectedGraph implements Graph {
	
	// 邻接矩阵
	private Integer[][] adjacentMatrix;

	@Override
	public List<KruskalEdge> kruskal() {
		return new Kruskal().produce(adjacentMatrix);
	}
	

	@Override
	public List<DijkstraNode> dijkstra(Integer startV) {
		
		return new Dijkstra().produce(adjacentMatrix, startV);
	}

	@Override
	public void buildAdjacentMatrix(Integer[][] adjacentMatrix) {
		/*
		 * 这是一个邻接矩阵的例子;
		 * 邻接矩阵沿 f(x) = -x 对称;
		 * 该邻接矩阵显示出了权重还有节点代号;
		 * ++++++++++++++++++++++++++++++++++
		 * +   		+	v0	+	v1	+	v2	+
		 * ++++++++++++++++++++++++++++++++++
		 * +   v0	+	0	+	2	+	4	+
		 * ++++++++++++++++++++++++++++++++++
		 * +   v1	+	2	+	0	+   ∞	+
		 * ++++++++++++++++++++++++++++++++++
		 * +   v2	+	4	+   ∞   +	0	+
		 * ++++++++++++++++++++++++++++++++++
		 */
		
		// 赋值邻接矩阵
		this.adjacentMatrix = adjacentMatrix;

	}

	@Override
	public List<Integer> DFS(Integer startV) {
		// 保存已遍历的节点序列
		List<Integer> searchRes = new DoubleLinkedList<Integer>();
		
		//递归搜索
		recDFS(startV,searchRes);

		return searchRes;
	}

	/**
	 * 递归深度优先遍历
	 * 
	 * @param prevV
	 *            上一个节点
	 * @param searchRes
	 *            保存遍历结果的集合
	 */
	private void recDFS(Integer prevV, List<Integer> searchRes) {

		searchRes.add(prevV);// 添加节点到返回集合
		//遍历当前节点的度
		for (int i = 0; i < adjacentMatrix[prevV].length; i++) {
			Integer weight = adjacentMatrix[prevV][i];// 当前节点出度的权
			if (weight != 0 && weight != NOWEIGHT && !searchRes.contain(i)) {// 有出度且没有被遍历
				// 递归下一个顶点,左手原则
				recDFS(i, searchRes);
			}
		}
	}

	@Override
	public List<Integer> WFS(Integer startV) {
		/*
		 * 广度优先搜索;需要借助队列实现;
		 */

		// 保存已遍历的节点序列
		List<Integer> searchRes = new DoubleLinkedList<Integer>();
		// 保存未被访问其度的节点*
		Queue<Integer> unVisitODNode = new LinkedQueue<Integer>();

		// 先访问传入的节点*
		searchRes.add(startV);
		unVisitODNode.add(startV);

		// 遍历队列中未被访问其度的节点
		while (!unVisitODNode.isEmpty()) {
			Integer v = unVisitODNode.delete();
			// 访问其度
			for (int OD = 0; OD < adjacentMatrix[v].length; OD++) {

				Integer weight = adjacentMatrix[v][OD];// 本节点到出度的权重

				if (weight != 0 && weight != NOWEIGHT && !searchRes.contain(OD)) {// 如果该顶点未被访问过

					searchRes.add(OD);// 添加到已访问序列

					unVisitODNode.add(OD);// 添加到待访问其度队列
				}

			}
		}

		return searchRes;
	}
	
	
	/**
	 * dijstra算法中的节点
	 * @author Kor_Zhang
	 *
	 */
	private class DijstraNode{
		private Integer weightFromStartV;//当前节点到开始节点的权重
		
	}
}
