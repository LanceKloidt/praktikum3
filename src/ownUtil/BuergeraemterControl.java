package ownUtil;
import javafx.stage.Stage;

import java.io.IOException;

import business.BuergeraemterModel;
import business.Buergeramt;
import guiBuergeraemter.BuergeraemterView;
import java.util.*;
public class BuergeraemterControl implements Observer{
	private BuergeraemterModel baModel;
	private BuergeraemterView baView;
	
	public BuergeraemterControl(Stage st)  {
		baModel = BuergeraemterModel.getInstance();
		baView = new BuergeraemterView(st, baModel, this);
		baModel.observerhinzufuegen(this);
	}
	
	
	
	public void schreibeBuergeraemterInDatei(String typ, ArrayList<Buergeramt> ba) {
		try {
			if("csv".equals(typ)) {
				baModel.schreibeBuergeraemterInCsvDatei(ba);
			} else {
				baModel.schreibeBuergeraemterInTxtDatei(ba);
			}
		}catch(IOException exc) {
			baView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
			
		}
		/*catch(Exception exc) {
			System.out.println(exc);
			baView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
			
		}*/
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		baView.zeigeBuergeraemterAn();
	}
}
