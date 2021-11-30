package structures;

import java.util.List;

public interface GraphInterface {

	public void addVertex(String name, long weight);

	public void addNeighbor(int posVertex1, int posVertex2, long distance);

	public void Dijkstra(int source);

	public List<Vertex<Long>> getRoadDijkstra(int destiny);

	public List<Vertex<Long>> getRoadFloydWarshall(String v1, String v2);

	public int[][] FloydWarshall();

	public String getTxtMatrix();
	
}
