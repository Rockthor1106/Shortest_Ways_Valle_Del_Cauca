package structures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph<V> implements GraphInterface<V>{
	
	private List <Vertex> vertexes;
	
	private Double[][] distanceMatrix;
	
	private Hashtable<V, Integer> vertexIndex;
	private int index;
	
	public Graph() {
		vertexes = new ArrayList<Vertex>();
		vertexIndex = new Hashtable<>();
		index = 0;
	}
	
	@Override
	public boolean add(V v) {
		boolean isRepeated = false;
		Vertex<V> newVertex = new Vertex<V>(v);
		
		for(int i = 0; i < vertexes.size(); i++) {
			if(vertexes != v) {
				isRepeated = true;
			}
		}
		if(!isRepeated) {
			vertexes.add(newVertex);
			vertexIndex.put(v, index);
		}
		return !isRepeated;
	}

	@Override
	public boolean addEdge(V v, V v2, Double l) {
		boolean added = false;
		distanceMatrix = new Double[vertexes.size()][vertexes.size()];
		
		if(vertexIndex.get(v) != null && vertexIndex.get(v2) != null) {
			distanceMatrix[vertexIndex.get(v)][vertexIndex.get(v2)] = l;
			distanceMatrix[vertexIndex.get(v2)][vertexIndex.get(v)] = l;
		}
		
		return added;
	}
	
	@Override
	public List<V> getRouteByDK() {
		
	}
	
	public int[][] fw() {
		Double[][] cost = new Double [distanceMatrix.length][distanceMatrix[0].length];
		int[][] al = new int [distanceMatrix.length][distanceMatrix[0].length]; 
		
		
		for (int i = 0; i < distanceMatrix.length; i++)
		{
			for (int j = 0; j < distanceMatrix.length; j++)
			{
				cost[i][j] = distanceMatrix[i][j];
				al[i][j] = j;
			}
			
		}
		
		for (int i = 0; i < cost.length; i++)
		{
			for (int j = 0; j < cost.length; j++)
			{
				for (int k = 0;k < cost.length; k++)
				{
					double aux = cost[i][j]+cost[k][i];
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
	public List<V> getRoouteByFW() {
		// TODO Auto-generated method stub
		return null;
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
	
	
	
}
