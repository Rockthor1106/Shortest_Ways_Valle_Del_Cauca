package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import structures.Graph;

public class Route {

	private Graph<String> graph;
	private int aux;
	
	public Route() throws IOException {
		graph = new Graph<>();
		loadData();
	}
	
	public void loadData() throws IOException {
		File file = new File("data/DistanceMunicipalyValley.csv");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		String line = bf.readLine();
		String[] temp;
		
		readVertexes();
		
		while(line != null) {
			temp = line.split(",");
			graph.addEdge(temp[0], temp[1], Integer.parseInt(temp[2]));
			line = bf.readLine();
		}
		System.out.println(aux);
		
		bf.close();
	}
	
	private void readVertexes() throws IOException {
		File file = new File("data/municipalities.csv");
		BufferedReader bf = new BufferedReader(new FileReader(file));
		
		String line = bf.readLine();
		while(line != null) {
			 graph.addVertex(line);
			 line = bf.readLine();
		}
		
		bf.close();
	}
	
	public List<String> getVertexRoute(String v1, String v2){
		return graph.getRouteByFW(v1, v2);
	}
	
	public Graph<String> getGraph() {
		return graph;
	}

	public void setGraph(Graph<String> graph) {
		this.graph = graph;
	}
}
