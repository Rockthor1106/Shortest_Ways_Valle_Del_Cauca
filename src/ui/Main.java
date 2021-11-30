package ui;

import java.io.IOException;
import java.util.List;

import structures.*;
import model.*;

public class Main {
	
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
}
