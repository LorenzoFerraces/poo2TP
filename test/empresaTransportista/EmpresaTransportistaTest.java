package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EmpresaTransportistaTest {

	private EmpresaTransportista unaEmpresaTransportista;
	private Camion unCamion;
	private Conductor unConductor;
	
	@BeforeEach
	void setUp() throws Exception {
		unaEmpresaTransportista = new EmpresaTransportista();
		unCamion = mock(Camion.class);
		unConductor = mock(Conductor.class);
	}

	@Test
	void testUnaEmpresaTransportistaRecienCreadaNoTieneCamionesNiConductores() {
		assertEquals(0, unaEmpresaTransportista.getCamiones().size());
		assertEquals(0, unaEmpresaTransportista.getConductores().size());
	}

	@Test
	void testAgregarCamion() {
		unaEmpresaTransportista.agregarCamion(unCamion);
		assertEquals(1, unaEmpresaTransportista.getCamiones().size());
	}
	
	@Test
	void testAgregarConductor() {
		unaEmpresaTransportista.agregarConductor(unConductor);
		assertEquals(1, unaEmpresaTransportista.getConductores().size());
	}

}
