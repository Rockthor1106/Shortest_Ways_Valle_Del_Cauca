package ui;

import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Route;
import structures.*;

public class Main extends Application {
	
	private MainController mainController;

	public static void main(String[] args) {
		launch(args);
		
//		int[][] matrix = {{0,4,2,0,0,0}
//		 ,{4,0,1,5,0,0}
//		 ,{2,1,0,8,10,0}
//		 ,{0,5,8,0,2,6}
//		 ,{0,0,10,2,0,3}
//		 ,{0,0,0,6,3,0}};
//		String[] names = {"Node1","Node2","Node3","Node4","Node5","Node6"};
//		Graph<String> grafo = new Graph<>(matrix);
//		for(int i = 0; i<names.length; i++) {
//			grafo.addVertex(names[i]);
//		}
//		for(int i = 0; i<matrix.length; i++) {
//			for(int j = 0; j<matrix.length; j++) {
//				grafo.addNeighbor(i, j, matrix[i][j]);
//			}
//		}
//		Dijkstra(grafo);
//		//FloydWarshall(grafo);
//		}
//	public static void Dijkstra(Graph<String> grafo) {
//		grafo.Dijkstra(0);
//		List<Vertex<String>> road = grafo.getRoadDijkstra(5);
//		for(int i = 0; i<road.size(); i++) {
//			System.out.println(road.get(i).getName());
//		}
//	}
//	
//	public static void FloydWarshall(Graph grafo) {
//		List<String> road = grafo.getRouteByFW("Node1", "Node6");
//		for(int i = 0; i<road.size(); i++) {
//			System.out.println(road.get(i));
//		}
//	}

	}
	
/*
	public static void main(String[] args) throws IOException {
		/*
		Route r = new Route();
		
		System.out.println(r.getGraph().getTxtMatrix());
		
		int[][] m = r.getGraph().FloydWarshall();
		
		/*
		Graph<String> g = new Graph<String>();
		
		g.addVertex("CANDELARIA");
		g.addVertex("FLORIDA");
		g.addVertex("PRADERA");
		g.addVertex("CALI");
		
		g.addEdge("CANDELARIA", "FLORIDA", 22);
		g.addEdge("CANDELARIA", "PRADERA", 8);
		g.addEdge("CALI", "CANDELARIA", 31);
		g.addEdge("CALI","PRADERA", 1);
		
		System.out.println(g.getTxtMatrix());
		System.out.println(g.getRouteByFW("CALI", "CANDELARIA"));
		int[][] m = g.FloydWarshall();
		
		String c = "";
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				c += " [" + m[i][j] + "] ";
			}
			c += "\n";
		}
		System.out.println(c);
		System.out.println(r.getVertexRoute("CALI", "FLORIDA"));
		
	}
*/
	public Main() throws IOException {
		mainController = new MainController(); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
		
		fxmlLoader.setController(mainController);
		
		Parent root = fxmlLoader.load();
		
		Group group = new Group();
		group.getChildren().add(root);
		group.getChildren().add(mainController.getGroup());
		
		Scene scene = new Scene(group);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ICESI Travels");
		primaryStage.setResizable(true);
		primaryStage.show();
	}
}
