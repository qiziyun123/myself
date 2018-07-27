package base.datastruct.graph;

import java.util.LinkedList;

/**
 * 邻接表表示法（无向图）
 * 
 * @author qizy
 *
 */
public class Graph {

	class EdgeNode {
		// 邻接点 顶点表中元素的下标;
		int adjvex;
		EdgeNode nextEdge;
	}

	class VexNode {
		String data;
		EdgeNode firstEdge;
		boolean isVisted;

		public boolean isVisted() {
			return isVisted;
		}

		public void setVisted(boolean isVisted) {
			this.isVisted = isVisted;
		}

	}

	VexNode[] vexsarray;
	boolean visited[] = new boolean[vexsarray.length];

	public int getPosition(String data) {
		for (int i = 0; i < vexsarray.length; i++) {
			if (data.equals(vexsarray[i].data)) {
				return i;
			}
		}
		return -1;
	}

	public Graph(String[] vexs, String[][] edges) {
		int vLen = vexs.length;
		int eLen = edges.length;
		vexsarray = new VexNode[vLen];

		for (int i = 0; i < vLen; i++) {
			vexsarray[i] = new VexNode();
			vexsarray[i].data = vexs[i];
			vexsarray[i].firstEdge = null;
		}

		for (int i = 0; i < eLen; i++) {
			String a = edges[i][0];
			String b = edges[i][1];

			int start = getPosition(a);
			int end = getPosition(b);
			EdgeNode edge = new EdgeNode();
			edge.adjvex = end;
			if (vexsarray[start].firstEdge == null) {
				vexsarray[start].firstEdge = edge;
			} else {
				EdgeNode point = vexsarray[start].firstEdge.nextEdge;
				while (point.nextEdge != null) {
					point = point.nextEdge;
				}
				point = edge;
			}

		}
	}

	

	/*
	 * 广度搜索
	 */
	public void BFS(String vex) {
		VexNode start = vexsarray[getPosition(vex)];
		LinkedList<VexNode> queue = new LinkedList<>();
		start.setVisted(true);
		queue.add(start);
		System.out.println(start.data);
		VexNode currVex;
		while (!queue.isEmpty()) {
			currVex = queue.remove(0);
			EdgeNode node = currVex.firstEdge;
			while (node != null) {
				if (vexsarray[node.adjvex].isVisted == false) {
					System.out.println(vexsarray[node.adjvex].data);
					vexsarray[node.adjvex].setVisted(true);
					queue.add(vexsarray[node.adjvex]);
				}
				node = node.nextEdge;
			}
		}
	}

}
