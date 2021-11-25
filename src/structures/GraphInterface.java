package structures;

import java.util.List;

public interface GraphInterface <V>{
	
	public boolean add(V v);

	public boolean addEdge(V v, V v2, Double l);
	
	public List<V> getRouteByDK(V v1, V v2);
	
	public List<V> getRouteByFW(V v1, V v2);

}
