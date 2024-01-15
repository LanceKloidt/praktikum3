package business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuergeramtTest {
	Buergeramt ba;
	@Test
	void konstruktorNameTest() {
		String[] dl = {"Hauptwohnsitz", "Nebenwohnsitz"};
		ba = new Buergeramt("Bürgerbüro Querenburg", 9, 17, "Querenburger Höhe 256",dl); 
		assertTrue(ba.getName().equals("Bürgerbüro Querenburg"));
	}

	@Test
	void fehlerhafteDienstleistungHandlingTest() {
		assertThrows(IllegalArgumentException.class, ()->{
			
			ba = new Buergeramt("Bürgerbüro Querenburg", 9, 17, "Querenburger Höhe 256",null); 
		});
	}
}
