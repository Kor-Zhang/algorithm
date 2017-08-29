package com.zk.algorithm.graph;

import java.util.Arrays;
import java.util.Iterator;

import com.zk.algorithm.graph.Kruskal.KruskalEdge;
import com.zk.algorithm.list.List;

public class Demo {
	/**
	 * 图测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// 初始化邻接矩阵
		Integer[][] adjacentMatrix = new Integer[7][7];
		for (int i = 0; i < adjacentMatrix.length; i++) {
			for (int j = 0; j < adjacentMatrix[i].length; j++) {
				if(i == j){
					adjacentMatrix[i][j] = 0;
					
				}else{
					adjacentMatrix[i][j] = UndirectedGraph.NOWEIGHT;
				}
				
			}
		}
		//数据填充
		adjacentMatrix[0][1] = 7;
		adjacentMatrix[0][3] = 5;
		adjacentMatrix[1][0] = 7;
		adjacentMatrix[1][2] = 8;
		adjacentMatrix[1][3] = 9;
		adjacentMatrix[1][4] = 7;
		adjacentMatrix[2][1] = 8;
		adjacentMatrix[2][4] = 5;
		adjacentMatrix[3][0] = 5;
		adjacentMatrix[3][1] = 9;
		adjacentMatrix[3][4] = 15;
		adjacentMatrix[3][5] = 6;
		adjacentMatrix[4][2] = 5;
		adjacentMatrix[4][1] = 7;
		adjacentMatrix[4][3] = 15;
		adjacentMatrix[4][5] = 8;
		adjacentMatrix[4][6] = 9;
		adjacentMatrix[5][3] = 6;
		adjacentMatrix[5][4] = 8;
		adjacentMatrix[5][6] = 11;
		adjacentMatrix[6][4] = 9;
		adjacentMatrix[6][5] = 11;


		Graph g = new UndirectedGraph();
		// 传入邻接矩阵
		g.buildAdjacentMatrix(adjacentMatrix);

		// 深度优先遍历
		System.out.println("深度优先遍历:");
		List<Integer> res = g.DFS(0);

		System.out.println(res);
		// 广度优先搜索
		System.out.println("广度优先遍历:");
		res = g.WFS(0);

		System.out.println(res);
		
		//克鲁斯卡尔实现最小生成树
		System.out.println("克鲁斯卡尔实现最小生成树:");
		List<KruskalEdge> r = g.kruskal();
		//输出最小生成树
		Iterator<KruskalEdge> it = r.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		//dijkstra算法寻找单源最短路径
		System.out.println("迪杰斯科特实现单源最短路径:");
		g.dijkstra(0);
	}

}
