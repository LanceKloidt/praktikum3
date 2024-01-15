package guiStaedtischeEinrichtungen;
   
import business.BuergeraemterModel;
import business.Buergeramt;
import business.SporthallenModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;
import business.Sporthalle;

public class StaedtischeEinrichtungenView {
	
	// Hier ergaenzen
	private BuergeraemterModel buergeraemterModel;
	private SporthallenModel sporthallenModel;
	private StaedtischeEinrichtungenControl seControl;
	
    	//---Anfang Attribute der grafischen Oberflaeche---
    	private Pane pane = new  Pane();
    	private Label lblAnzeigeBuergeraemter     
 		= new Label("Anzeige Bürgerämter");
    	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
    	private TextArea txtAnzeigeBuergeraemter  = new TextArea();
    	private TextArea txtAnzeigeSporthallen = new TextArea();
    	private Button btnAnzeigeSporthallen = new Button("Importieren/Anzeigen");
    	private Button btnAnzeigeBuergeraemter = new Button("Anzeige");
    	//-------Ende Attribute der grafischen Oberflaeche-------
    
    	public StaedtischeEinrichtungenView(/* Hier ergaenzen … */Stage primaryStage, BuergeraemterModel buergeraemterModel, SporthallenModel shModel, StaedtischeEinrichtungenControl seControl){
    		Scene scene = new Scene(this.pane, 560, 340);
    		primaryStage.setScene(scene);
    		primaryStage.setTitle("Anzeige von städtischen " 
 			+ "Einrichtungen");
    		primaryStage.show();
    		// Hier ergaenzen
    		this.buergeraemterModel = buergeraemterModel;
    		this.sporthallenModel = shModel;
    		this.seControl = seControl;
    		

		this.initKomponenten();
		this.initListener();
    	}
private void initKomponentenBuergeramt() {
	// Label
		Font font = new Font("Arial", 20);
   	lblAnzeigeBuergeraemter.setLayoutX(310);
		lblAnzeigeBuergeraemter.setLayoutY(40);
		lblAnzeigeBuergeraemter.setFont(font);
		lblAnzeigeBuergeraemter.setStyle("-fx-font-weight: bold;"); 
   	pane.getChildren().add(lblAnzeigeBuergeraemter);
   	
 // Textbereich	
	txtAnzeigeBuergeraemter.setEditable(false);
		txtAnzeigeBuergeraemter.setLayoutX(310);
	txtAnzeigeBuergeraemter.setLayoutY(90);
		txtAnzeigeBuergeraemter.setPrefWidth(220);
	txtAnzeigeBuergeraemter.setPrefHeight(185);
	pane.getChildren().add(txtAnzeigeBuergeraemter);        	
	// Button
  	btnAnzeigeBuergeraemter.setLayoutX(310);
	btnAnzeigeBuergeraemter.setLayoutY(290);
	pane.getChildren().add(btnAnzeigeBuergeraemter); 
}
private void initKomponentenSporthalle() {
	//Label
	Font font = new Font("Arial", 20);
   	lblAnzeigeSporthallen.setLayoutX(30);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;"); 
   	pane.getChildren().add(lblAnzeigeSporthallen);   
    	



    	//Textbereich
    	
    	txtAnzeigeSporthallen.setEditable(false);
 		txtAnzeigeSporthallen.setLayoutX(30);
		txtAnzeigeSporthallen.setLayoutY(90);
 		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
   	pane.getChildren().add(txtAnzeigeSporthallen);        	
    	// Button
      	btnAnzeigeSporthallen.setLayoutX(30);
    	btnAnzeigeSporthallen.setLayoutY(290);
    	pane.getChildren().add(btnAnzeigeSporthallen); 
}
    	private void initKomponenten(){
    initKomponentenBuergeramt();
    initKomponentenSporthalle();
       	
   }
   
   private void initListener() {
	    btnAnzeigeBuergeraemter.setOnAction(
 			new EventHandler<ActionEvent>() {
	    		@Override
	        	public void handle(ActionEvent e) {
	            	zeigeBuergeraemterAn();
	        	} 
   	    });
	    
	    btnAnzeigeSporthallen.setOnAction(e->{
	    	seControl.SporthallenCsvImportieren();
	    	if(sporthallenModel.getSporthallen().size()>0){
    			
    			StringBuffer text = new StringBuffer();
    			
    			for(Sporthalle s : sporthallenModel.getSporthallen()) {
    				text.append(s.gibSporthalleZurueck(' '));
    			}
    			txtAnzeigeSporthallen.setText(
    				text.toString());
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde keine Sporthalle aufgenommen!");
    		}
	    });
    }
   
    public void zeigeBuergeraemterAn(){
    	
    		if(buergeraemterModel.getBuergeraemter().size()>0){
    			
    			StringBuffer text = new StringBuffer();
    			for(Buergeramt b : buergeraemterModel.getBuergeraemter()) {
    				text.append(b.gibBuergeramtZurueck(' '));
    			}
    			txtAnzeigeBuergeraemter.setText(
    				text.toString());
    		}
    		else{
    			zeigeInformationsfensterAn(
 				"Bisher wurde kein Bürgeramt aufgenommen!");
    		}
    }	
   
    private void zeigeInformationsfensterAn(String meldung){
    	  	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
               	"Information", meldung).zeigeMeldungsfensterAn();
    }	
    
}

