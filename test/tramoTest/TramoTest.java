package tramoTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
	void testDistancia() {
		fail("Not yet implemented");
	}

}
