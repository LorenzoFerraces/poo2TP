package ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clientes.Consignee;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import naviera.viaje.Viaje;
import terminalPortuaria.TerminalPortuaria;

class OrdenImportacionTest {
	
	private OrdenImportacion ordenImportacion; // SUT
	// DOCs
	private TerminalPortuaria unaTerminalPortuaria;
	private Viaje unViaje;
	private Camion unCamion;
	private Conductor unConductor;
	private Container unaCarga;
	private LocalDate fechaDeSalidaDesdeOrigen;
	private LocalDate fechaDeLlegadaADestino;
	private Consignee unConsignee;
	
	@BeforeEach
	void setUp() throws Exception {
		unaTerminalPortuaria = mock(TerminalPortuaria.class);
		unViaje = mock(Viaje.class);
		unCamion = mock(Camion.class);
		unaCarga = mock(Container.class);
		fechaDeSalidaDesdeOrigen = mock(LocalDate.class);
		fechaDeLlegadaADestino = mock(LocalDate.class);
		unConsignee = mock(Consignee.class);
		
		ordenImportacion = new OrdenImportacion(unaTerminalPortuaria, unViaje, unaCarga, fechaDeSalidaDesdeOrigen, 
				fechaDeLlegadaADestino, unConsignee);
	}

	// Métodos de clase OrdenImportacion
	@Test
	void testUnaOrdenDeExportacionConoceSuConsignee() {
		assertEquals(unConsignee, ordenImportacion.getConsignee());
	}
	
	@Test
	void testSeLePuedenCargarLosDatosDeRetiroAUnaOrden() {
		ordenImportacion.cargarDatosRetiroDeCarga(unCamion, unConductor);
		assertEquals(unCamion, ordenImportacion.getCamionAsignado());
		assertEquals(unConductor, ordenImportacion.getConductorAsignado());
	}
	
	// Los métodos de la superclase están testeados en OrdenExportacionTest
}
