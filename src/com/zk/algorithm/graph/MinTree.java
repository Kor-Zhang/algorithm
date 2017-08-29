package com.zk.algorithm.graph;

import com.zk.algorithm.graph.Kruskal.KruskalEdge;
import com.zk.algorithm.list.List;

/**
 * 最小生成树接口;
 * @author Kor_Zhang
 * @see Kruskal
 */
public interface MinTree<R> {

	/**
	 * 产生最小生成树
	 * @param adjacentMatrix	邻接矩阵
	 * @return	返回生成后的信息
	 */
	List<KruskalEdge> produce(Integer[][] adjacentMatrix);
}
