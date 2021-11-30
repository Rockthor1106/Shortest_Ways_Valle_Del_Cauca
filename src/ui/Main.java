package ui;

import java.util.List;

import structures.*;

public class Main {
	
	public static void main(String[] args) {
		/*
		Graph<String> a = new Graph<String>();
		a.add("Candelaria");
		a.add("Pradera");
		a.add("Cali");
		
		a.addEdge("Candelaria", "Cali", (double) 26);
		a.addEdge("Cali", "Pradera", (double)52);
		a.addEdge("Candelaria", "Pradera", (double)32);
		System.out.println(a.getTxtMatrix());
		*/
		int[][] matrix = {{0,4,2,0,0,0}
		 ,{4,0,1,5,0,0}
		 ,{2,1,0,8,10,0}
		 ,{0,5,8,0,2,6}
		 ,{0,0,10,2,0,3}
		 ,{0,0,0,6,3,0}};
		String[] names = {"Node1","Node2","Node3","Node4","Node5","Node6"};
		Graph grafo = new Graph(matrix);
		for(int i = 0; i<names.length; i++) {
			grafo.addVertex(names[i], 0);
		}
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix.length; j++) {
				grafo.addNeighbor(i, j, matrix[i][j]);
			}
		}
		Dijkstra(grafo);
		//FloydWarshall(grafo);
		}
	public static void Dijkstra(Graph grafo) {
		grafo.Dijkstra(0);
		List<Vertex<Long>> road = grafo.getRoadDijkstra(5);
		for(int i = 0; i<road.size(); i++) {
			System.out.println(road.get(i).getName());
		}
	}
	
	public static void FloydWarshall(Graph grafo) {
		List<Vertex<Long>> road = grafo.getRoadFloydWarshall("Node1", "Node6");
		for(int i = 0; i<road.size(); i++) {
			System.out.println(road.get(i).getName());
		}
	}
}
