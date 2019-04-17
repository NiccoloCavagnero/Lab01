package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco;
	double startTime;
	double stopTime;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private Button btnCanc;
    
    @FXML
    private TextArea txtTime;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	startTime = System.nanoTime();
    	
    	String s = txtParola.getText().trim();
    	
    	if ( s.length() != 0 ) 
           elenco.addParola(s);
    	
        txtParola.clear();
        txtResult.clear();
        txtTime.clear();

        for ( String st : elenco.getElenco() ) 
        	txtResult.appendText(st+"\n");
        
        stopTime = System.nanoTime();
        txtTime.setText(String.valueOf("Tempo di esecuzione: "+(stopTime-startTime)+"nanosecondi."));
        
    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	startTime = System.nanoTime();
    	
    	txtParola.clear();
    	txtResult.clear();
    	txtTime.clear();
    	elenco.reset();
    	
    	stopTime = System.nanoTime();
        txtTime.setText(String.valueOf("Tempo di esecuzione: "+(stopTime-startTime)+"nanosecondi."));
    }
    
    @FXML
    void doCanc(ActionEvent event) {
    	
    	startTime = System.nanoTime(); 
    	
    	String st = txtResult.getSelectedText();
    	
    	elenco.eliminate(st);
    	
    	txtTime.clear();
    	txtParola.clear();
    	txtResult.clear();
    	
    	for ( String s : elenco.getElenco() ) {
        	txtResult.appendText(s+"\n");
        }
    	
    	stopTime = System.nanoTime();
        txtTime.setText(String.valueOf("Tempo di esecuzione: "+(stopTime-startTime)+"nanosecondi."));
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        
    }
}
