package test.naviera.circuitoMaritimo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import naviera.circuitoMaritimo.tramo.Tramo;

class CircuitoMaritimoTest {
	
	private CircuitoMaritimo circuito;

	@BeforeEach
	void setUp() throws Exception {
		this.circuito = new CircuitoMaritimo();
		Tramo t1 = mock(Tramo.class);
		Tramo t2 = mock(Tramo.class);
		Tramo t3 = mock(Tramo.class);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
