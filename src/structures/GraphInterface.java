package structures;

import java.util.List;

public interface GraphInterface <V>{
	
	public boolean add(V v);

	public boolean addEdge(V v, V v2, Double l);
	
	public List<V> getRouteByDK();
	
	public List<V> getRoouteByFW();
	
}
