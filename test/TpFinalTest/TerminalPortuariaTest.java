package TpFinalTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;

class TerminalPortuariaTest {
	
	private TerminalPortuaria t1;
	private TerminalPortuaria t2;
	
	private Punto p1;
	private Punto p2;

	@BeforeEach
	void setUp() throws Exception {
		this.p1 = new Punto(5d,10d);
		this.p2 = new Punto(7d,12d);
		
		this.t1 = new TerminalPortuaria(p1);
		this.t2 = new TerminalPortuaria(p2);
	}

	@Test
	void testCoordenadas() {
		assertEquals(t1.getCoordenadas(), p1);
	}
	
	@Test
	void testCalcularDistancia() {
		assertEquals(t1.calcularDistancia(t2), Math.sqrt(8));
	}

}
