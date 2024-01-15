package guiStaedtischeEinrichtungen;

import ownUtil.Observable;
import ownUtil.Observer;

import business.BuergeraemterModel;
import javafx.stage.Stage;

public class StaedtischeEinrichtungenControl implements Observer {
	StaedtischeEinrichtungenView seView;
	BuergeraemterModel baModel;
	public StaedtischeEinrichtungenControl(Stage st) {
		baModel = BuergeraemterModel.getInstance();
		seView = new StaedtischeEinrichtungenView(st, baModel, this);
		baModel.observerhinzufuegen(this);
		
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		seView.zeigeBuergeraemterAn();
	}
}
