package ui;

import structures.*;

public class Main {
	
	public static void main(String[] args) {
		Graph<String> a = new Graph<String>();
		a.add("Candelaria");
		a.add("Pradera");
		a.add("Cali");
		
		a.addEdge("Candelaria", "Cali", (double) 26);
		a.addEdge("Cali", "Pradera", (double)52);
		a.addEdge("Candelaria", "Pradera", (double)32);
		System.out.println(a.getTxtMatrix());
	}
}
