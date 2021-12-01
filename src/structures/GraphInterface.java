package structures;

import java.util.List;

public interface GraphInterface<S> {

	public void addVertex(S name);
	public void addNeighbor(int posVertex1, int posVertex2, int distance);
	public void Dijkstra(int source);
	public List<Vertex<S>> getRoadDijkstra(int destiny);
	public int[][] FloydWarshall();
	public String getTxtMatrix();
	List<S> getRouteByFW(S v1, S v2);
}
