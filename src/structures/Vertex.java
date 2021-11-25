package structures;

public class Vertex<V> {
	private V value;
	
	public Vertex(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
}
