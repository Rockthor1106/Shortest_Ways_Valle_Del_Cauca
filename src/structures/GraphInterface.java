package structures;

import java.util.List;

public interface GraphInterface {

	boolean addVertex(String name, long weight);

	void addNeighbor(int posVertex1, int posVertex2, long distance);

	void Dijkstra(int source);

	List<Vertex<Long>> getRoadDijkstra(int destiny);

	List<Vertex<Long>> getRoadFloydWarshall(String v1, String v2);

	int[][] FloydWarshall();

	String getTxtMatrix();
	
}
