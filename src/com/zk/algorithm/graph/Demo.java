package com.zk.algorithm.graph;

import com.zk.algorithm.list.List;

public class Demo {
	/**
	 * 图测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 初始化邻接矩阵
		Integer[][] adjacentMatrix = new Integer[3][3];
		for (int i = 0; i < adjacentMatrix.length; i++) {
			for (int j = 0; j < adjacentMatrix[i].length; j++) {
				adjacentMatrix[i][j] = 0;
			}
		}
		adjacentMatrix[0][1] = 2;
		adjacentMatrix[0][2] = 4;
		adjacentMatrix[1][0] = 2;
		adjacentMatrix[2][1] = 4;

		Graph g = new UndirectedGraph();
		// 传入邻接矩阵
		g.buildAdjacentMatrix(adjacentMatrix);

		// 深度优先遍历
		List<Integer> res = g.DFS(2);

		System.out.println(res);
		// 广度优先搜索
		res = g.WFS(2);

		System.out.println(res);

	}

}
