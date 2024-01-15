package guiStaedtischeEinrichtungen;

import ownUtil.Observable;
import ownUtil.Observer;

import java.io.IOException;

import business.BuergeraemterModel;
import business.SporthallenModel;
import javafx.stage.Stage;

public class StaedtischeEinrichtungenControl implements Observer {
	StaedtischeEinrichtungenView seView;
	BuergeraemterModel baModel;
	SporthallenModel shModel;
	public StaedtischeEinrichtungenControl(Stage st) {
		baModel = BuergeraemterModel.getInstance();
		shModel = SporthallenModel.getInstance();
		seView = new StaedtischeEinrichtungenView(st, baModel,shModel, this);
		baModel.observerhinzufuegen(this);
		
		
	}
	
	public void SporthallenCsvImportieren() {
		try {
			shModel.leseSporthalleAusCsvDatei();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		seView.zeigeBuergeraemterAn();
	}
}
