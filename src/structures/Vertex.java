package structures;

import java.util.ArrayList;
import java.util.List;


public class Vertex<T> {

	private int position;
	
	private String name;
	private T weight;
	
	private Vertex<T> prev;
	
	private List<Vertex<T>> neighbors;
	private List<T> distances;
	
	public Vertex(String n, T w, int p) {
		name = n;
		weight = w;
		position = p;
		prev = null;
		neighbors = new ArrayList<>();
		distances = new ArrayList<>();
	}
	public Vertex(String n, int p) {
		name = n;
		weight = null;
		position = p;
		prev = null;
		neighbors = new ArrayList<>();
		distances = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String newN) {
		name = newN;
	}
	
	public T getWeight() {
		return weight;
	}
	public void setWeight(T newW) {
		weight = newW;
	}
	
	public int getPosition() {
		return position;
	}
	
	public Vertex<T> getPrev(){
		return prev;
	}
	public void setPrev(Vertex<T> newPrev) {
		prev = newPrev;
	}
	
	public List<Vertex<T>> getNeighbors(){
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
	public List<T> getDistances(){
		return distances;
	}
	public T getDistance(int index) {
		for(int i = 0; i<distances.size(); i++) {
			if(neighbors.get(i).getPosition() == index) {
				return distances.get(i);
			}
		}
		return null;
	}
	public void addNeighbor(Vertex<T> neigh, T distance) {
		neighbors.add(neigh);
		distances.add(distance);
	}
}
