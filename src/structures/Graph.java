package structures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph implements GraphInterface{
	private static final int SIZE = 6;
	private int count = 0;
	
	private int[][] distanceMatrix;
	
	private Hashtable<String, Integer> vertexIndex;
	
	private List<Vertex<Long>> vertexes;
	
	public Graph(int[][] matrix) {
		vertexes = new ArrayList<>();
		vertexIndex = new Hashtable<>();
		distanceMatrix = matrix;
	}
	@Override
	public void addVertex(String name, long weight) {
		vertexes.add(new Vertex<Long>(name, weight, count));
		vertexIndex.put(name, count);
		count++;
	}
	@Override
	public void addNeighbor(int posVertex1, int posVertex2, long distance) {
		vertexes.get(posVertex1).addNeighbor(vertexes.get(posVertex2), distance);
	}
	@Override
	public void Dijkstra(int source) {
		boolean[] vertexChecked = new boolean[SIZE];
		for(int i = 0; i<SIZE; i++) {
			vertexes.get(i).setWeight((long)Integer.MAX_VALUE);
			vertexChecked[i] = false;
		}
		vertexes.get(source).setWeight((long)0);
		
		for(int i = 0; i<SIZE-1; i++) {
			int pos = minDistance(vertexChecked);
			vertexChecked[pos] = true;
			for(Vertex<Long> v : vertexes.get(pos).getNeighbors()) {
				long alt = vertexes.get(pos).getWeight() + vertexes.get(pos).getDistance(v.getPosition());
				if(!vertexChecked[v.getPosition()] && vertexes.get(pos).getDistance(v.getPosition()) > 0 && vertexes.get(pos).getWeight() != Integer.MAX_VALUE){
					vertexes.get(v.getPosition()).setWeight(alt);
					vertexes.get(v.getPosition()).setPrev(vertexes.get(pos));
				}
			}
		}
	}
	private int minDistance(boolean[] vertexChecked) {
		long min = (long)Integer.MAX_VALUE;
		int min_index = 0;
		for(int i = 0; i<SIZE; i++) {
			if(vertexChecked[i] == false && vertexes.get(i).getWeight() <= min) {
				min = vertexes.get(i).getWeight();
				min_index = i;
			}
		}
		return min_index;
	}
	@Override
	public List<Vertex<Long>> getRoadDijkstra(int destiny) {
		List<Vertex<Long>> road = new ArrayList<>();
		Vertex<Long> actual = vertexes.get(destiny);
		while(actual.getPrev() != null) {
			road.add(0, vertexes.get(actual.getPosition()));
			actual = vertexes.get(actual.getPrev().getPosition());
		}
		return road;
	}
	@Override
	public int[][] FloydWarshall() {
		int[][] cost = new int[SIZE][SIZE];
		int[][] al = new int [SIZE][SIZE]; 
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				cost[i][j] = distanceMatrix[i][j];
				al[i][j] = j;
			}
		}
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				for (int k = 0;k < cost.length; k++) {
					int aux = cost[i][j]+cost[k][i];
					if (aux < cost[k][j]) {
						cost[k][j] = aux;
						cost[j][k] = aux;
						al[k][j] = i;
						al[j][k] = i;
					}
				}
			}
		}
		return al;
	}
	@Override
	public List<Vertex<Long>> getRoadFloydWarshall(String v1, String v2) {
		int[][] m  = FloydWarshall();
		int start = vertexIndex.get(v2);
		int end = vertexIndex.get(v2);
		
		List<Vertex<Long>> a = new ArrayList<>();
		boolean finished = false;
		int c = m[start][end];
				
		a.add(vertexes.get(start));
		while (!finished) {
			if (start == end) {
				finished = true;
			}else if (c == end){
				a.add(vertexes.get(c));
				finished = true;
			}else {
				a.add(vertexes.get(c));
				c = m[c][end];
			}
		}
		return a;
	}
	@Override
	public String getTxtMatrix() {
		String txt = "";
		for(int i = 0; i < distanceMatrix.length; i++) {
			for(int j = 0; j < distanceMatrix[0].length; j++) {
				txt += "[" + distanceMatrix[i][j] + "] ";
			}
			
			txt += "\n";
		}
		
		return txt;
	}
	
	public int[][] getDistanceMatrix() {
		return distanceMatrix;
	}

}
	