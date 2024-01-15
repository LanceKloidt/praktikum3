package factories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteProduct extends Product {
	String filetype;
	BufferedWriter aus;
	ConcreteProduct(){
		try {
		aus = new BufferedWriter(new FileWriter("Buergeraemter.csv", true));
		}catch(Exception e){}
	}
	public void fuegeInDateiHinzu(Object object) throws IOException{
		Buergeramt ba =  (Buergeramt) object;
		aus.write(ba.gibBuergeramtZurueck(';'));
	}
	public void schliesseDatei() throws IOException{
		aus.close();
	}
}
