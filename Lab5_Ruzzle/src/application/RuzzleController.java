package application;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.ruzzle.model.Posizione;
import it.polito.tdp.ruzzle.model.Ruzzle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.control.ListView;

public class RuzzleController {

	Ruzzle model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnGenera;

    @FXML
    private ListView<String> listResult;
    
    @FXML
    private GridPane grid;
    
    @FXML
    private Button btnClear;

    void setModel(Ruzzle model){
    	this.model=model;
    }
    
    @FXML
    void doClear(ActionEvent event) {

    	listResult.getItems().clear();
    	grid.getChildren().clear();
    	//dimenticati scacchiera precedente
    	
    }

    @FXML
    void doGenera(ActionEvent event) {
    	
    	model.cercaParole();
    	Font f = new Font("TimesRoman",35);
    	
    	for(Posizione p : model.sc.getPos()){
    		Label l = new Label(p.getValore()+"");
    		l.setFont(f);
    		grid.add(l, p.getColonna(), p.getRiga());
    		
    	}
    	for(String s : model.paroleTrovate()){
    		//Text l = new Text(s);
    		listResult.getItems().add(s);
    		//listResult.getChildrenUnmodifiable().add(l);
    	}

    }

    @FXML
    void initialize() {
    	assert listResult != null : "fx:id=\"listResult\" was not injected: check your FXML file 'Ruzzle.fxml'.";
    	assert grid != null : "fx:id=\"grid\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'Ruzzle.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Ruzzle.fxml'.";

    }
}