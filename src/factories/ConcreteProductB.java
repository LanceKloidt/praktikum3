package factories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Buergeramt;

public class ConcreteProductB extends Product {
	String filetype;
	BufferedWriter aus;
	ConcreteProductB(){
		
		try {
			aus = new BufferedWriter(new FileWriter("Buergeraemter.txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void fuegeInDateiHinzu(Object object) throws IOException{
		Buergeramt ba =  (Buergeramt) object;
		aus.write(ba.gibBuergeramtZurueck(';'));
			
		
	}
	public void schliesseDatei() throws IOException{
		aus.close();
	}
}
