package puntoTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import punto.Par;

class ParTest {
	
	Par<?,?> par;

	@BeforeEach
	void setUp() throws Exception {
		this.par = new Par<String, String>("first","second");
	}

	@Test
	void testFirst() {
		assertEquals(par.getFirst(), "first");
	}
	
	@Test
	void testSecond() {
		assertEquals(par.getSecond(), "second");
	}

}
