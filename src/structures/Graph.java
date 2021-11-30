package structures;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Graph<V> implements GraphInterface<V>{
	
	private List <Vertex<V>> vertexes;
	
	private Double[][] distanceMatrix;
	
	private Hashtable<V, Integer> vertexIndex;
	private int index,aux;
	
	public Graph() {
		vertexes = new ArrayList<Vertex<V>>();
		vertexIndex = new Hashtable<>();
		index = 0;
	}
	
	@Override
	public boolean add(V v) {
		boolean isRepeated = false;
		Vertex<V> newVertex = new Vertex<V>(v);
		for(int i = 0; i < vertexes.size(); i++) {
			if(vertexes.get(i).getValue() == v) {
				isRepeated = true;
			}
		}
		
		if(!isRepeated) {
			vertexes.add(newVertex);
			vertexIndex.put(v, index);
			index++;
		}
		return !isRepeated;
	}

	@Override
	public boolean addEdge(V v, V v2, Double l) {
		boolean added = false;
		if(distanceMatrix == null) {
			
			distanceMatrix = new Double[vertexes.size()][vertexes.size()];
			initilizesMatrix();
			
		}
		if(vertexIndex.get(v) != null && vertexIndex.get(v2) != null) {
			distanceMatrix[vertexIndex.get(v)][vertexIndex.get(v2)] = l;
			
			distanceMatrix[vertexIndex.get(v2)][vertexIndex.get(v)] = l;
		}
		
		if(vertexes.get(vertexIndex.get(v)).getValue() == "EL CERRITO") {
			index++;
		} else if(vertexes.get(vertexIndex.get(v2)).getValue() == "EL CERRITO") {
			index++;
		}
		return added;
	}
	
	public void initilizesMatrix() {
		for(int i = 0; i < distanceMatrix.length; i++) {
			for(int j = 0; j < distanceMatrix[0].length; j++) {
				if(i != j) {
					distanceMatrix[i][j] = Double.MAX_VALUE;
				} else {
					distanceMatrix[i][j] = (double) 0;
				}
			}
		}
	}
	
	@Override
	public List<V> getRouteByFW(V v1, V v2) {
		int[][] m  = fw();
		
		int start = vertexIndex.get(v1);
		int end = vertexIndex.get(v2);
		
		List<V> a = new ArrayList<>();
		boolean finished = false;
		
		int c = m[start][end];
		
		a.add(vertexes.get(start).getValue());
		
		while (!finished) {
			if (start == end) {
				finished = true;
			} else 	{
				if (c == end) {
					a.add(vertexes.get(end).getValue());
					finished = true;
				}else {
					a.add(vertexes.get(c).getValue());
					c = m[c][end];
				}
			}
		}
		return a;
	}
	
	public int[][] fw() {
		Double[][] cost = new Double [distanceMatrix.length][distanceMatrix[0].length];
		int[][] al = new int [distanceMatrix.length][distanceMatrix[0].length]; 
		
		
		for (int i = 0; i < distanceMatrix.length; i++)
		{
			for (int j = 0; j < distanceMatrix.length; j++)
			{
				cost[i][j] = distanceMatrix[i][j];
				
				if(cost[i][j] == Double.MAX_VALUE) {
					al[i][j] = -1;
				} else {
					al[i][j] = j;
				}
			}
			
		}
		
		for (int i = 0; i < cost.length; i++) {
			
			for (int j = 0; j < cost.length; j++) {
				
				for (int k = 0;k < cost.length; k++) {
					
					double aux = cost[i][j] + cost[k][i];
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
	public List<V> getRouteByDK(V v1, V v2) {
		// TODO Auto-generated method stub
		return null;
	}
	
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

	public List<Vertex<V>> getVertexes() {
		return vertexes;
	}

	public void setVertexes(List<Vertex<V>> vertexes) {
		this.vertexes = vertexes;
	}
}
