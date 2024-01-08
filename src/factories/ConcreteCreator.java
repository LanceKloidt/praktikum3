package factories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConcreteCreator extends Creator {

public Product factoryMethod(String str)  {
	
	
	if(str.equals("csv")) {
	
	
return new ConcreteProduct();
	
	}
	
	if(str.equals("txt")) {
		
	
	return new ConcreteProductB();
		
		}
	
	return null;
	
}
}
