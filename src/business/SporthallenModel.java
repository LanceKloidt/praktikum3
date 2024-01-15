package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SporthallenModel {
 private static SporthallenModel instanz;
 private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	private SporthallenModel() {
	 
 }
	
 public static SporthallenModel getInstance() {
	if(instanz==null) {
		instanz = new SporthallenModel();
		
	}
	return instanz;
 }
 
 public void leseSporthalleAusCsvDatei() 
	 throws IOException {
	 BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
	 ArrayList<Sporthalle> ergebnis = new ArrayList<>();
	 String zeileStr = ein.readLine();
	 while(zeileStr !=null) {
		 String[] zeile = zeileStr.split(";");
		 ergebnis.add(new Sporthalle(zeile[0],zeile[1],zeile[2]));
		 zeileStr = ein.readLine();
	 }
	 ein.close();
	 this.sporthallen =ergebnis;
 }
 
 public ArrayList<Sporthalle> getSporthallen(){
	 return this.sporthallen;
 }
}
