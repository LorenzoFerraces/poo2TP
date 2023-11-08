package empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.TerminalPortuaria;

class EmpresaTransportistaTest {

	private EmpresaTransportista unaEmpresaTransportista;
	private Camion unCamion;
	private Conductor unConductor;
	private TerminalPortuaria unaTerminal;
	
	@BeforeEach
	void setUp() throws Exception {
		unaEmpresaTransportista = new EmpresaTransportista();
		unCamion = mock(Camion.class);
		unConductor = mock(Conductor.class);
		unaTerminal = mock(TerminalPortuaria.class);
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

	@Test
	void testSeEnviaUnCamionALaTerminalPorLoQueLaEmpresaLoPierde() {
		unaEmpresaTransportista.agregarCamion(unCamion);
		unaEmpresaTransportista.enviarCamionATerminal(unCamion, unaTerminal);
		assertEquals(0, unaEmpresaTransportista.getCamiones().size());
	}

}
