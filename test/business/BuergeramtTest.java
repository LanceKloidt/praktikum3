package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuergeramtTest {
	Buergeramt ba;
	@Test
	void konstruktorNameTest() {
		String[] dl = {"Hauptwohnsitz", "Nebenwohnsitz"};
		ba = new Buergeramt("B�rgerb�ro Querenburg", 9, 17, "Querenburger H�he 256",dl); 
		assertTrue(ba.getName().equals("B�rgerb�ro Querenburg"));
	}

	@Test
	void fehlerhafteDienstleistungHandlingTest() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			ba = new Buergeramt("B�rgerb�ro Querenburg", 9, 17, "Querenburger H�he 256",null); 
		});
	}
}
