package com.zk.algorithm.graph;

import com.zk.algorithm.graph.Dijkstra.DijkstraNode;
import com.zk.algorithm.list.DoubleLinkedList;
import com.zk.algorithm.list.List;

/**
 * dijkstra算法实现单源最短路径;<br/>
 * 即求的一个顶点到其他顶点的最短路径分别是多少;<br/>
 * <pre>
 * 重点理解:
 * 1.每个未访问顶点的权值是该顶点到起始顶点的总权值;
 * 2.当每次访问一个新的节点成功后,需要对访问节点更新.
 * 	具体的更新操作:
 * 		1.添加已访问成功的顶点的度到未访问序列;
 * 		2.为这些度+以访问顶点的权值;
 * 		3.如果未访问序列已经含有该度的索引,那么说明有多条路径可以到达该顶点,需要判断更新该顶点的权值为这些路径中的最小权值;
 * </pre>
 * @author Kor_Zhang
 * 
 */
public class Dijkstra implements ShortestPath<DijkstraNode> {
	
	//unVisited是当前顶点的未被访问的顶点的信息
	private List<DijkstraNode> unVisited = new DoubleLinkedList<DijkstraNode>();
	//visited是当前已经被访问了的顶点信息
	private List<DijkstraNode> visited = new DoubleLinkedList<DijkstraNode>();
		
	@Override
	public List<DijkstraNode> produce(
			Integer[][] adjacentMatrix, Integer startV) {
		//初始化以访问节点集合和为访问节点集合
		initParams(adjacentMatrix,startV);
		
		//遍历多次,直到"为访问序列为空"
		while (unVisited.size() != 0) {
			DijkstraNode minD = unVisited.get(0);//假设当前节点的度中的最小度问为第一个
			
			//选取当前节点的度的最小度
			for (int j = 1; j < unVisited.size(); j++) {
				if(unVisited.get(j).compareTo(minD) == -1){
					minD = unVisited.get(j);
				}
			}
			//加入具有最短权的度到"已访问"集合
			visited.add(minD);
			unVisited.removeElement(minD);
			
			//**重点**
			//将刚才新添加的顶点的度加入到未拜访序列,并且计算每个度的距离起点的新的权值
			for (int j = 0; j < adjacentMatrix[minD.vIndex].length; j++) {
				
				Integer wight = adjacentMatrix[minD.vIndex][j];//获取当前节点的度的权值
				if(wight == Graph.NOWEIGHT || wight ==0){
					continue;
				}
				
				DijkstraNode n0 = new DijkstraNode(adjacentMatrix[minD.vIndex][j] + minD.weight, j);
				if(!visited.contain(n0)){//如果没有被拜访过
					if(unVisited.contain(n0)){//**重点**如果未拜访序列包含该顶点,说明该顶点也是其他节点的度,那么比较这两条路径那个的权最小

						DijkstraNode n1 = unVisited.get(unVisited.indexOf(n0));
						if(n0.compareTo(n1) == -1){
							n1.weight = n0.weight;
						}
						
					}else{//没有多条路径可到达该顶点,直接添加
						unVisited.add(n0);
					}
				}
			}
			
			
		}
		
		
		return visited;
	}
	/**
	 * 初始化以访问节点集合和为访问节点集合
	 * @param adjacentMatrix	邻接矩阵
	 * @param startV	开始访问的节点
	 */
	private void initParams(Integer[][] adjacentMatrix,Integer startV) {
		//假设第一个节点已经被访问
		visited.add(new DijkstraNode(0, startV));
		//设置开始节点的度的权值
		for (int i = 1; i < adjacentMatrix.length; i++) {
			if(adjacentMatrix[startV][i] == Graph.NOWEIGHT){
				continue;
			}
			unVisited.add(new DijkstraNode(adjacentMatrix[startV][i], i));
		}
		
		
	}

	/**
	 * dijkstra节点
	 * @author Kor_Zhang
	 *
	 */
	public class DijkstraNode implements Comparable<DijkstraNode>{
		private Integer weight;//该顶点到起始点的总权值
		private Integer vIndex;//该顶点索引
		public DijkstraNode(Integer weight, Integer vIndex) {
			super();
			this.weight = weight;
			this.vIndex = vIndex;
		}
		
		@Override
		public boolean equals(Object obj) {
			return this.vIndex == ((DijkstraNode)obj).vIndex;
		}

		@Override
		public int compareTo(DijkstraNode o) {
			return this.weight>o.weight?1:(this.weight==o.weight?0:-1);
		}

		@Override
		public String toString() {
			return "DijkstraNode [weight=" + weight + ", vIndex=" + vIndex
					+ "]";
		}
		
	}
}
