package base.datastruct.graph;
/**
 * 顶点类
* @author qizy
*
*/
public class Vertex {
	public String name;
	public int weight;//权重
	// 是否被访问过
	public boolean isVisable;

	public Vertex(String data) {
		this.name = data;
	}
}
