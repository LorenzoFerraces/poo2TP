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
	@BeforeEach
	void setUp() throws Exception {
		TerminalPortuaria terminal1 = mock(TerminalPortuaria.class);
		TerminalPortuaria terminal2 = mock(TerminalPortuaria.class);
		this.tramo = new Tramo(terminal1, terminal2, 360d, 800d);
	}

	@Test
	void testCalcularDistanciaTramo() {
		tramo.distancia();
		verify(tramo.getOrigen()).calcularDistancia(tramo.getDestino().getCoordenadas());
	}
	
	@Test
	void testContieneTerminal() {
		fail("test no implementado");
	}

//	Me parece innecesario testear getters y setters para subir el porcentaje de cobertura
}
