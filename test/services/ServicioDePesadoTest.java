package services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ServicioDePesadoTest {

	@Test
	void debeDevolverUnCostoFijo() {
		IServicio myService = new ServicioDePesado();
		assertEquals(myService.costo(), 300);
	}

}
