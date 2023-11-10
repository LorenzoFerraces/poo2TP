package test.naviera.circuitoMaritimo.tramo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalPortuaria;

class TramoTest {

	private Tramo tramo;
	private TerminalPortuaria t1;
	private TerminalPortuaria t2;
	@BeforeEach
	void setUp() throws Exception {
		this.t1 = mock(TerminalPortuaria.class);
		this.t2 = mock(TerminalPortuaria.class);
		this.tramo = new Tramo(t1, t2, 360d, 800d);
	}

	@Test
	void testCalcularDistanciaTramo() {
		tramo.distancia();
		verify(tramo.getOrigen()).calcularDistancia(tramo.getDestino().getCoordenadas());
	}
	
	@Test
	void testContieneTerminalOrigen() {
		assertTrue(tramo.contieneTerminal(t1));
	}
	
	@Test
	void testContieneTerminalDestino() {
		assertTrue(tramo.contieneTerminal(t2));
	}

//	Me parece innecesario testear getters y setters para subir el porcentaje de cobertura
}
