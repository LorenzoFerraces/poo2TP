package gps;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;

class GPSTest {

	private GPS gps;
	private Punto posicion;
	private TerminalPortuaria terminal;
	
	@BeforeEach
	void setUp() throws Exception {
		posicion = mock(Punto.class);
		gps = new GPS(posicion, terminal);
	}

	@Test
	void testUnGPSConoceSuPosicion() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPosicion() {
		fail("Not yet implemented");
	}

}
