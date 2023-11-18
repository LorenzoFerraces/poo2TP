package gps;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import punto.Punto;

class GPSTest {

	private GPS gps;
	private Punto p1;
	private Punto p2;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = mock(Punto.class);
		p2 = mock(Punto.class);
		gps = new GPS(p1);
	}

	@Test
	void testUnGPSConoceSuPosicion() {
		assertEquals(p1, gps.getPosicion());
	}

	@Test
	void testUnGPSPuedeCambiarSuPosicion() {
		gps.setPosicion(p2);
		assertEquals(p2, gps.getPosicion());
	}

}
