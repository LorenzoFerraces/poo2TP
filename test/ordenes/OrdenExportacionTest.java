package ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clientes.Shipper;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

class OrdenExportacionTest {

	private OrdenExportacion ordenExportacion; // SUT
	// DOCs
	private TerminalPortuaria unaTerminalPortuaria;
	private Viaje unViaje;
	private Camion unCamion;
	private Conductor unConductor;
	private Container unaCarga;
	private LocalDate fechaDeSalidaDesdeOrigen;
	private LocalDate fechaDeLlegadaADestino;
	private Shipper unShipper;
	
	@BeforeEach
	void setUp() throws Exception {
		unaTerminalPortuaria = mock(TerminalPortuaria.class);
		unViaje = mock(Viaje.class);
		unCamion = mock(Camion.class);
		unaCarga = mock(Container.class);
		fechaDeSalidaDesdeOrigen = mock(LocalDate.class);
		fechaDeLlegadaADestino = mock(LocalDate.class);
		unShipper = mock(Shipper.class);
		
		ordenExportacion = new OrdenExportacion(unaTerminalPortuaria, unViaje, unCamion, 
				unConductor, unaCarga, fechaDeSalidaDesdeOrigen, 
				fechaDeLlegadaADestino, unShipper);
	}

	// Método de clase OrdenExportacion
	@Test
	void testUnaOrdenDeExportacionConoceSuShipper() {
		assertEquals(unShipper, ordenExportacion.getShipper());
	}

	// Métodos de superclase Orden
	@Test
	void testUnaOrdenConoceSuTerminalDeDestino() {
		assertEquals(unaTerminalPortuaria, ordenExportacion.getTerminalDeDestino());
	}

	@Test
	void testUnaOrdenConoceElViajeAlQueEstaAsociado() {
		assertEquals(unViaje, ordenExportacion.getViajeElegido());
	}

	@Test
	void testUnaOrdenConoceSuCamion() {
		assertEquals(unCamion, ordenExportacion.getCamionAsignado());
	}

	@Test
	void testUnaOrdenConoceSuConductor() {
		assertEquals(unConductor, ordenExportacion.getConductorAsignado());
	}

	@Test
	void testUnaOrdenConoceLaCargaComerciada() {
		assertEquals(unaCarga, ordenExportacion.getCarga());
	}

	@Test
	void testUnaOrdenSabeSuFechaDeSalida() {
		assertEquals(fechaDeSalidaDesdeOrigen, ordenExportacion.getFechaDeSalidaDesdeOrigen());
	}

	@Test
	void testUnaOrdenSabeSuFechaDeLlegada() {
		assertEquals(fechaDeLlegadaADestino, ordenExportacion.getFechaDeLlegadaADestino());
	}

}
