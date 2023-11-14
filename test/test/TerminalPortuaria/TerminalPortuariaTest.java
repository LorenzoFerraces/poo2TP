package test.TerminalPortuaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import punto.Punto;
import terminalPortuaria.TerminalPortuaria;

class TerminalPortuariaTest {
	
	private TerminalPortuaria t1;
	
	private Punto p1;
	private Punto p2;

	@BeforeEach
	void setUp() throws Exception {
		this.p1 = mock(Punto.class);
//		this.p1 = new Punto(5d,10d);
		this.p2 = mock(Punto.class);
//		this.p2 = new Punto(7d,12d);;
		this.t1 = new TerminalPortuaria(p1);
	}

	@Test
	void testCoordenadas() {
		assertEquals(t1.getCoordenadas(), p1);
	}
	
	@Test
	void testCalcularDistanciaEntreTerminales() {
		t1.calcularDistancia(p2);
		verify(p1).calcularDistancia(p2);
	}

}
