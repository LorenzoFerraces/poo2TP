package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import containers.Container;

class CamionTest {

	private Camion unCamion;
	private Container unaCarga;
	private Conductor unConductor;
	
	@BeforeEach
	void setUp() throws Exception {
		unaCarga = mock(Container.class);
		unConductor = mock(Conductor.class);
		unCamion = new Camion(unaCarga, unConductor);
	}

	@Test
	void testUnCamionConoceSuCarga() {
		assertEquals(unaCarga, unCamion.getCarga());
	}

	@Test
	void testUnCamionConoceSuConductor() {
		assertEquals(unConductor, unCamion.getConductor());
	}

}
