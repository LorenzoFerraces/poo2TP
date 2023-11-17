package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ConductorTest {

	private Conductor unConductor;
	private Camion unCamion;
	
	@BeforeEach
	void setUp() throws Exception {
		unCamion = mock(Camion.class);
		unConductor = new Conductor(unCamion);
	}

	@Test
	void testUnConductorConoceSuCamion() {
		assertEquals(unCamion, unConductor.getCamion());
	}

}
