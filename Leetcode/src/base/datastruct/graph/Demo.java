package base.datastruct.graph;

public class Demo {

	public static void main(String[] args) {
		String[] vexs = {"aa","bb","cc","dd","ee"};
		String[][] edges = {
				{"aa","bb"},
				{"aa","dd"},
				{"bb","cc"},
				{"cc","dd"},
				{"cc","ee"},
				{"dd","ee"}
				
		};
		Graph graph1 = new Graph(vexs,edges);
		graph1.BFS("aa");

	}

}
