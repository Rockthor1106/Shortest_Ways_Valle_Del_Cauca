package ui;

import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
	/*
	public static void main(String[] args) throws IOException {
		
		Route r = new Route();
		
		System.out.println(r.getGraph().getNumEdges());
		
		System.out.println(r.getGraph().getTxtMatrix());
		
		int[][] m = r.getGraph().fw();
		
		String c = "";
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				c += " [" + m[i][j] + "] ";
			}
			c += "\n";
		}
		System.out.println(c);
	}
	*/
	}
	
	public Main() {
		mainController = new MainController(); 
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
		
		fxmlLoader.setController(mainController);
		
		Parent root = fxmlLoader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ICESI Travels");
		primaryStage.show();
	}
}
