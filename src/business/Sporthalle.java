package business;

public class Sporthalle {
private String name, bodenbelag;
private float quadratmeter;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBodenbelag() {
	return bodenbelag;
}
public void setBodenbelag(String bodenbelag) {
	this.bodenbelag = bodenbelag;
}
public float getQuadratmeter() {
	return quadratmeter;
}
public void setQuadratmeter(float quadratmeter) {
	this.quadratmeter = quadratmeter;
}


public Sporthalle(String name, String qm, String belag) {
	this.name = name;
	this.quadratmeter = Float.parseFloat(qm);
	this.bodenbelag = belag;
}
public String gibSporthalleZurueck(char trenner) {
	return name+trenner+quadratmeter+trenner+bodenbelag+"\n";
}
}
