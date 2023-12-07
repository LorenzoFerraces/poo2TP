package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CamionTest {

	private Camion unCamion;
	private Conductor unConductor;
	
	@BeforeEach
	void setUp() throws Exception {
		unConductor = mock(Conductor.class);
		unCamion = new Camion(unConductor);
	}

	@Test
	void testUnCamionConoceSuConductor() {
		assertEquals(unConductor, unCamion.getConductor());
	}

}
