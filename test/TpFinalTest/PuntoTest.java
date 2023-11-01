package TpFinalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.Punto;

class PuntoTest {
	
	Punto p;

	@BeforeEach
	void setUp() throws Exception {
		this.p = new Punto(5d,10d);
	}

	@Test
	void testFirst() {
		assertEquals(p.getFirst(), 5d);
	}

	@Test
	void testSecond() {
		assertEquals(p.getSecond(), 10d);
	}
	
	@Test
	void testCalcularDistancia() {
		Punto p2 = new Punto(7d,12d);
		assertEquals(p.calcularDistancia(p2), Math.sqrt(8));
	}
}
