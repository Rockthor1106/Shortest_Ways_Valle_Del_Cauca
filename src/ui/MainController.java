package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import model.Route;
import structures.Vertex;

public class MainController {
	 @FXML
	    private RadioButton alcalá;

	    @FXML
	    private RadioButton andalucía;

	    @FXML
	    private RadioButton ansermanuevo;

	    @FXML
	    private RadioButton argelia;

	    @FXML
	    private RadioButton bolívar;

	    @FXML
	    private RadioButton buenaventura;

	    @FXML
	    private RadioButton buga;

	    @FXML
	    private RadioButton bugalagrande;

	    @FXML
	    private RadioButton caicedonia;

	    @FXML
	    private RadioButton cairo;

	    @FXML
	    private RadioButton cali;

	    @FXML
	    private RadioButton candelaria;

	    @FXML
	    private RadioButton cartago;

	    @FXML
	    private RadioButton cerrito;

	    @FXML
	    private RadioButton cumbre;

	    @FXML
	    private RadioButton dagua;

	    @FXML
	    private RadioButton darién;

	    @FXML
	    private RadioButton dovio;

	    @FXML
	    private RadioButton florida;

	    @FXML
	    private RadioButton ginebra;

	    @FXML
	    private RadioButton guacarí;

	    @FXML
	    private RadioButton jamundí;

	    @FXML
	    private RadioButton obando;

	    @FXML
	    private RadioButton palmira;

	    @FXML
	    private RadioButton pedro;

	    @FXML
	    private RadioButton pradera;

	    @FXML
	    private RadioButton restrepo;

	    @FXML
	    private RadioButton riofrío;

	    @FXML
	    private RadioButton roldanillo;

	    @FXML
	    private RadioButton sevilla;

	    @FXML
	    private RadioButton toro;

	    @FXML
	    private RadioButton trujillo;

	    @FXML
	    private RadioButton tuluá;

	    @FXML
	    private RadioButton ulloa;

	    @FXML
	    private RadioButton unión;

	    @FXML
	    private RadioButton versalles;

	    @FXML
	    private RadioButton victoria;

	    @FXML
	    private RadioButton vijes;

	    @FXML
	    private RadioButton yotoco;

	    @FXML
	    private RadioButton yumbo;

	    @FXML
	    private RadioButton zarzal;

	    @FXML
	    private RadioButton águila;
	    
	    @FXML
	    private ToggleGroup c;
	    
	    private Route route;
	    
	    private Group group;
	    
	    private ToggleGroup gp;
	    
	    ToggleButton g = new ToggleButton();
	    
	    private String initialPos;
	    private String finalPos;
	    
	    public MainController() throws IOException {
	    	route = new Route();
	    	gp = new ToggleGroup();
	    	group = new Group();
	    	initialPos = "";
	    	finalPos = "";
	    }
	    
	    
	    @FXML
	    public void initialize() {
	    	
			cali.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					initialPos = "CALI";
				}
				
			});
			
			florida.setOnMousePressed(new EventHandler<MouseEvent>() {

				@Override
				public void handle(MouseEvent event) {
					finalPos = "FLORIDA";
				}
				
			});
	    }

	    @FXML
	    void calculateRoute(ActionEvent event) {
	    	List<String> routeList = route.getVertexRoute(initialPos, finalPos);
	    	double ax, ay, bx, by;
	    	
	    	
	    	
	    	for (int i = 0; i < routeList.size(); i++) {
	    		if (initialPos.equals("")) {
					
				}
	    		else if(initialPos.equals("")) {
					
				}
	    		else if(initialPos.equals("")) {
					
				}
			}
	    	
//	    	Line line = new Line();
//            line.setStartX(vertexesRouteList.get(i).+8); 
//            line.setStartY(A.getLayoutY()+9); 
//            line.setEndX(B.getLayoutX()+8); 
//            line.setEndY(B.getLayoutY()+9); 
//            group = new Group(line);

	    }

		public Group getGroup() {
			return group;
		}
}
