package gps;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.Punto;

class GPSTest {

	private GPS gps;
	private Punto p1;
	private Punto p2;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Punto(0.0, 0.0);
		p2 = new Punto(3.0, 4.0);
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

	@Test
	void testUnGPSPuedeAcercarseAUnaPosicion() {
		// El GPS tiene un punto inicial de 0.0, 0.0
        // El punto a acercarse es 3.0, 4.0
        gps.acercarseAPosicion(p2);
        assertEquals(1, gps.getPosicion().getFirst());
        assertEquals(1, gps.getPosicion().getSecond());
	}
	
	@Test
	void testUnGPSPuedeAlejarseDeUnaPosicion() {
		// El GPS tiene un punto inicial de 0.0, 0.0
		// El punto a alejarse es 3.0, 4.0
		
		gps.alejarseDePosicion(p2);
        assertEquals(-1, gps.getPosicion().getFirst());
        assertEquals(-1, gps.getPosicion().getSecond());

	}
}
