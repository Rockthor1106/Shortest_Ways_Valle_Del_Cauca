package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import model.Route;
import structures.Graph;
import structures.Vertex;

public class MainController {
		
		@FXML
	    private BorderPane borderpane;
	
		@FXML
	    private RadioButton BUENAVENTURA;

	    @FXML
	    private ToggleGroup c;

	    @FXML
	    private RadioButton CALI;

	    @FXML
	    private RadioButton JAMUNDI;

	    @FXML
	    private RadioButton CANDELARIA;

	    @FXML
	    private RadioButton FLORIDA;

	    @FXML
	    private RadioButton PRADERA;

	    @FXML
	    private RadioButton PALMIRA;

	    @FXML
	    private RadioButton YUMBO;

	    @FXML
	    private RadioButton DAGUA;

	    @FXML
	    private RadioButton CUMBRE;

	    @FXML
	    private RadioButton VIJES;

	    @FXML
	    private RadioButton CERRITO;

	    @FXML
	    private RadioButton GINEBRA;

	    @FXML
	    private RadioButton GUACARI;

	    @FXML
	    private RadioButton RESTREPO;

	    @FXML
	    private RadioButton DARIEN;

	    @FXML
	    private RadioButton YOTOCO;

	    @FXML
	    private RadioButton BUGA;

	    @FXML
	    private RadioButton TULUA;

	    @FXML
	    private RadioButton PEDRO;

	    @FXML
	    private RadioButton RIOFRIO;

	    @FXML
	    private RadioButton TRUJILLO;

	    @FXML
	    private RadioButton ANDALUCIA;

	    @FXML
	    private RadioButton SEVILLA;

	    @FXML
	    private RadioButton BUGALAGRANDE;

	    @FXML
	    private RadioButton BOLIVAR;

	    @FXML
	    private RadioButton ZARZAL;

	    @FXML
	    private RadioButton CAICEDONIA;

	    @FXML
	    private RadioButton VICTORIA;

	    @FXML
	    private RadioButton ROLDANILLO;

	    @FXML
	    private RadioButton DOVIO;

	    @FXML
	    private RadioButton VERSALLES;

	    @FXML
	    private RadioButton UNION;

	    @FXML
	    private RadioButton OBANDO;

	    @FXML
	    private RadioButton TORO;

	    @FXML
	    private RadioButton ARGELIA;

	    @FXML
	    private RadioButton CAIRO;

	    @FXML
	    private RadioButton AGUILA;

	    @FXML
	    private RadioButton ANSERMANUEVO;

	    @FXML
	    private RadioButton CARTAGO;

	    @FXML
	    private RadioButton ULLOA;

	    @FXML
	    private RadioButton ALCALA;
	    
	    private Route route;
	    
	    private Group group;
	    
	    private List<RadioButton> vertexes;
	    
	    public MainController() throws IOException {
	    	route = new Route();
	    	group = new Group();
	    	vertexes = new ArrayList<RadioButton>();
	    }
	    
	    
	    @FXML
	    public void initialize() {
	    	borderpane.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
	    	    public void handle(ActionEvent event) {
	    	    	RadioButton nodo = (RadioButton)c.getSelectedToggle();
	    	    	vertexes.add(nodo);
	    	    }
	    	});
	    }

	    @FXML
	    public void calculateRoute(ActionEvent event) {
	    	List<String> vt;
	    	
	    	if(vertexes.get(1) != null && vertexes.get(0) != null) {
	    		System.out.println(vertexes.get(0).getId() + " " + vertexes.get(1).getId());
	    		vt = route.getVertexRoute(vertexes.get(0).getId(), vertexes.get(1).getId());
	    		System.out.println(vt);
	    		ObservableList<Toggle> nodos = c.getToggles();
	    		
	    		double ax = 0, ay = 0, bx = 0, by = 0;
	    				
	    		int aux = 0;
	    		for(int i = 0; i < vt.size(); i++) {
	    			for(int j = 0; j < nodos.size(); j++) {
	    				RadioButton temp = (RadioButton) nodos.get(j);
	    				if (vt.get(i).equals(temp.getId()) && aux == 0) {
	    					ax = temp.getLayoutX() + 210;
	    					ay = temp.getLayoutY() + 116;
	    					aux++;
	    				} else if(vt.get(i).equals(temp.getId()) && aux == 1){
	    					bx = temp.getLayoutX() + 210;
	    					by = temp.getLayoutY() + 116;
	    					
	    					Line line = new Line();
	    		    	    line.setStartX(ax); 
	    		    	    line.setStartY(ay); 
	    		    	  	line.setEndX(bx); 
	    		    	    line.setEndY(by); 
	    		    	    group.getChildren().add(line);
	    		    	    
	    		    	    ax = bx;
	    		    	    ay = by;
	    				}
	    			}
	    		}
	    	}
	    }

		public Group getGroup() {
			return group;
		}
}
