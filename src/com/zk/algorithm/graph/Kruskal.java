package com.zk.algorithm.graph;

import com.zk.algorithm.graph.Kruskal.KruskalEdge;
import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;
import com.zk.algorithm.list.queue.WeightQueue;

/**
 * kruskal算法实现最小生成树;<br/>
 * 注意:<br/>
 * 1.适用于无向网;<br/>
 * 2.kruskal算法核心是判断是否边的两顶点存在环,即需要理解方法{@link Kruskal#findRoot(Integer)};<br/>
 * 3.生成的边集只有原邻接矩阵的f(x)>-x部分,规律是startV>endV;<br/>
 * 4.总的思想是:将边按升序排列(即边集),选取其中不会形成环的顶点加入最小生成树;
 * @author Kor_Zhang
 *
 */
public class Kruskal implements MinTree<KruskalEdge> {

	private WeightQueue<KruskalEdge> kruskalEdgeQueue;// 克鲁斯卡尔的边集的节点队列,最小权重在前
	private Integer[] vRoot;// 记录下每个顶点所在的树的根位置;用于辅助判断顶点与顶点之间是否形成环

	@Override
	public List<KruskalEdge> produce(Integer[][] adjacentMatrix) {

		// 邻接矩阵转化为边集
		kruskalEdgeQueue = adjacentMatrix2EdgeCollection(adjacentMatrix);

		vRoot = new Integer[adjacentMatrix.length];// 默认元素引用为null

		// 实现最小生成树
		return buildTree();
	}

	/**
	 * 寻找顶点所在树的根节点
	 * 
	 * @param v
	 *            待查找顶点
	 * @return 最早祖先
	 */
	private Integer findRoot(Integer v) {
		while (vRoot[v] != null) {
			v = vRoot[v];
		}
		return v;
	}

	/**
	 * 实现最小生成树
	 * 
	 * @return 生成树
	 */
	private List<KruskalEdge> buildTree() {

		List<KruskalEdge> minTree = new DoubleLinkedList<KruskalEdge>();
		while (!kruskalEdgeQueue.isEmpty()) {// 如果所有节点都进入最小生成树,结束

			KruskalEdge edge = kruskalEdgeQueue.delete();// 去除当前权重最小的边

			if (edge.weight == Graph.NOWEIGHT) {// 去除无权重的边
				continue;
			}

			// 判断是否形成环
			int sR = findRoot(edge.startV);// 找到开始节点的根顶点
			int eR = findRoot(edge.endV);// 找到结束顶点的根顶点
			if (eR != sR) {// 存在权重 且 不存在环的可能性
				// 加入节点到最小生成树
				minTree.add(edge);
				// 将开始节点的根设置为结束节点的根**重点理解
				vRoot[eR] = sR;
			}

		}
		return minTree;

	}

	/**
	 * 邻接矩阵转化为边集,按边的权重重小到达排列,且只保留矩阵的右上部(不包括f(x) = -x);<br/>
	 * 
	 * @param adjacentMatrix
	 *            邻接矩阵
	 * @return 边集的队列
	 */
	private WeightQueue<KruskalEdge> adjacentMatrix2EdgeCollection(
			Integer[][] adjacentMatrix) {
		/*
		 * 边集例子:
		 * ++++++++++++++++++++++++++++++++++
		 * + index  + startV+  endV + weight+ 
		 * ++++++++++++++++++++++++++++++++++
		 * +	0	+	0	+	1	+	9	+	
		 * ++++++++++++++++++++++++++++++++++
		 * +	1	+	0	+	2	+	88	+	
		 * ++++++++++++++++++++++++++++++++++
		 * +	2	+	1	+	2	+	77	+	
		 * ++++++++++++++++++++++++++++++++++
		 * 注意:无向网只需要记录一条边(即记录矩阵右上角的数据)
		 */
		WeightQueue<KruskalEdge> kruskalVQ = new WeightQueue<Kruskal.KruskalEdge>(
				WeightQueue.ORDER_ASC);
		// 遍历转化j>i的邻接矩阵顶点及其边到边集
		for (int i = 0; i < adjacentMatrix.length; i++) {
			for (int j = 0; j < adjacentMatrix[i].length; j++) {
				if (j > i) {
					kruskalVQ.add(new KruskalEdge(i, j, adjacentMatrix[i][j]));
				}
			}
		}
		return kruskalVQ;
	}

	/**
	 * kruskal算法的边节点
	 * 
	 * @author Kor_Zhang
	 *
	 */
	public static class KruskalEdge implements Comparable<KruskalEdge> {
		private Integer startV;// 开始的边
		private Integer endV;// 结束的边
		private Integer weight;// 边上权重

		public KruskalEdge(Integer startV, Integer endV, Integer weight) {
			super();
			this.startV = startV;
			this.endV = endV;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "KruskalNode [startV=" + startV + ", endV=" + endV
					+ ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(KruskalEdge o) {
			return this.weight > o.weight ? 1 : (this.weight == o.weight ? 0
					: -1);
		}

	}

}
