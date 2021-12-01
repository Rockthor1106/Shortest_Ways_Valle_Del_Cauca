package ui;

import java.beans.EventHandler;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import model.Route;

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
	    
	    private ToggleButton tb;
	    
	    public MainController() throws IOException {
	    	route = new Route();
	    	group = new Group();
	    }
	    
	    
	    @FXML
	    public void initialize() {
	    }

	    @FXML
	    void calculateRoute(ActionEvent event) {
	    	System.out.println(route.getVertexRoute("CALI", "FLORIDA"));
	    }

		public Group getGroup() {
			return group;
		}
}
