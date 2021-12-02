package structures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph<S> implements GraphInterface<S>{
	
	private static final int SIZE = 6;
	private int index = 0;
	private int aux;
	
	private Double[][] distanceMatrix;
	
	private Hashtable<S, Integer> vertexIndex;
	
	private List<Vertex<S>> vertexes;
	
	public Graph(Double[][] matrix) {
		vertexes = new ArrayList<>();
		vertexIndex = new Hashtable<>();
		distanceMatrix = matrix;
	}
	public Graph() {
		vertexes = new ArrayList<>();
		vertexIndex = new Hashtable<>();
	}
	
	@Override
	public void addVertex(S name) {
		vertexes.add(new Vertex<S>(name, index));
		vertexIndex.put(name, index);
		index++;
	}
	
	@Override
	public void addNeighbor(int posVertex1, int posVertex2, int distance) {
		vertexes.get(posVertex1).addNeighbor(vertexes.get(posVertex2), distance);
	}
	
	@Override
	public void Dijkstra(int source) {
		boolean[] vertexChecked = new boolean[SIZE];
		for(int i = 0; i<SIZE; i++) {
			vertexes.get(i).setWeight(Integer.MAX_VALUE);
			vertexChecked[i] = false;
		}
		vertexes.get(source).setWeight(0);
		
		for(int i = 0; i<SIZE-1; i++) {
			int pos = minDistance(vertexChecked);
			vertexChecked[pos] = true;
			for(Vertex<S> v : vertexes.get(pos).getNeighbors()) {
				long alt = vertexes.get(pos).getWeight() + vertexes.get(pos).getDistance(v.getPosition());
				if(!vertexChecked[v.getPosition()] && vertexes.get(pos).getDistance(v.getPosition()) > 0 && vertexes.get(pos).getWeight() != Integer.MAX_VALUE){
					vertexes.get(v.getPosition()).setWeight((int)alt);
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
	public List<Vertex<S>> getRoadDijkstra(int destiny) {
		List<Vertex<S>> road = new ArrayList<>();
		Vertex<S> actual = vertexes.get(destiny);
		while(actual.getPrev() != null) {
			road.add(0, vertexes.get(actual.getPosition()));
			actual = vertexes.get(actual.getPrev().getPosition());
		}
		return road;
	}
	
	public boolean addEdge(String v, String v2, int l) {
		boolean added = false;
		if(distanceMatrix == null) {
			
			distanceMatrix = new Double[vertexes.size()][vertexes.size()];
			initilizesMatrix();
			
		}
		if(vertexIndex.get(v) == null) {
			System.out.println(v);
		}else if(vertexIndex.get(v2) == null) {
			System.out.println(v2);
		}
		if(vertexIndex.get(v) != null && vertexIndex.get(v2) != null) {
			distanceMatrix[vertexIndex.get(v)][vertexIndex.get(v2)] = (double) l;
			
			distanceMatrix[vertexIndex.get(v2)][vertexIndex.get(v)] = (double) l;
			added = true;
		}
		
		return added;
	}
	
	public void initilizesMatrix() {
		for(int i = 0; i < distanceMatrix.length; i++) {
			for(int j = 0; j < distanceMatrix[0].length; j++) {
				if(i != j) {
					distanceMatrix[i][j] = (double) Integer.MAX_VALUE;
				} else {
					distanceMatrix[i][j] = (double) 0;
				}
			}
		}
	}
	
	@Override
	public List<S> getRouteByFW(S v1, S v2) {
		int[][] m  = FloydWarshall();
		
		int start = vertexIndex.get(v1);
		int end = vertexIndex.get(v2);
		
		List<S> a = new ArrayList<>();
		boolean finished = false;
		
		int c = m[start][end];
		
		a.add(vertexes.get(start).getName());
		
		while (!finished) {
			if (start == end) {
				finished = true;
			} else 	{
				if (c == end) {
					a.add(vertexes.get(end).getName());
					finished = true;
				}else {
					a.add(vertexes.get(c).getName());
					c = m[c][end];
				}
			}
		}
		return a;
	}
	@Override
	public int[][] FloydWarshall() {
		Double[][] cost = new Double[vertexes.size()][vertexes.size()];
		int[][] al = new int [vertexes.size()][vertexes.size()]; 
		for (int i = 0; i < distanceMatrix.length; i++) {
			for (int j = 0; j < distanceMatrix.length; j++) {
				cost[i][j] = distanceMatrix[i][j];
				
				if(cost[i][j] == Integer.MAX_VALUE) {
					al[i][j] = -1;
				} else {
					al[i][j] = j;
				}
			}
		}
		for (int i = 0; i < cost.length; i++) {
			for (int j = 0; j < cost.length; j++) {
				for (int k = 0;k < cost.length; k++) {
					Double aux = cost[i][j]+cost[k][i];
					if (aux < cost[k][j]) {
						cost[k][j] = aux;
						cost[j][k] = aux;
						al[k][j] = i;
						al[j][k] = i;
					} else {
						
					}
				}
			}
		}
		
		return al;
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
	
	public String getTxtmt() {
		int[][] mt = FloydWarshall();
		String txt = "";
		for(int i = 0; i < mt.length; i++) {
			for(int j = 0; j < mt[0].length; j++) {
				txt += "[" + mt[i][j] + "] ";
			}
			
			txt += "\n";
		}
		
		return txt;
	}

	public int getNumEdges() {
		return aux;
	}
	
	public Double[][] getDistanceMatrix() {
		return distanceMatrix;
	}
	public void setDistanceMatrix(Double[][] distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public List<Vertex<S>> getVertexes() {
		return vertexes;
	}
	public void setVertexes(List<Vertex<S>> vertexes) {
		this.vertexes = vertexes;
	}
	public Hashtable<S, Integer> getVertexIndex() {
		return vertexIndex;
	}
	
	
}
	