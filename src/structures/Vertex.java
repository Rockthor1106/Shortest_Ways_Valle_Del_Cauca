package structures;

import java.util.ArrayList;
import java.util.List;


public class Vertex<S> {

	private S name;
	
	private int position;
	
	private int weight;
	
	private Vertex<S> prev;
	
	private List<Vertex<S>> neighbors;
	private List<Integer> distances;
	
	public Vertex(S n, int p) {
		name = n;
		position = p;
		
		prev = null;
		
		neighbors = new ArrayList<>();
		distances = new ArrayList<>();
	}
	
	public S getName() {
		return name;
	}
	public void setName(S newN) {
		name = newN;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int newW) {
		weight = newW;
	}
	
	public int getPosition() {
		return position;
	}
	
	public Vertex<S> getPrev(){
		return prev;
	}
	public void setPrev(Vertex<S> newPrev) {
		prev = newPrev;
	}
	
	public List<Vertex<S>> getNeighbors(){
		return neighbors;
	}
	public int getIndexNeighbor(String name) {
		int index = -1;
		for(int i = 0; i<neighbors.size(); i++) {
			if(neighbors.get(i).getName().equals(name)) {
				return i;
			}
		}
		return index;
	}
	public List<Integer> getDistances(){
		return distances;
	}
	public int getDistance(int index) {
		for(int i = 0; i<distances.size(); i++) {
			if(neighbors.get(i).getPosition() == index) {
				return distances.get(i);
			}
		}
		return 0;
	}
	public void addNeighbor(Vertex<S> neigh, int distance) {
		neighbors.add(neigh);
		distances.add(distance);
	}
}
