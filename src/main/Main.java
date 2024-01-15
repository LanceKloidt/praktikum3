package main;


import guiStaedtischeEinrichtungen.StaedtischeEinrichtungenControl;
import javafx.application.Application;
import javafx.stage.Stage;
import ownUtil.BuergeraemterControl;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new BuergeraemterControl(primaryStage);
		Stage fensterStaedtischeEinrichtungen = new Stage();
		new StaedtischeEinrichtungenControl(fensterStaedtischeEinrichtungen);
		fensterStaedtischeEinrichtungen.show();
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
