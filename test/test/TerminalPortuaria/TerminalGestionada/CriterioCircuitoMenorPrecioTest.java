package test.TerminalPortuaria.TerminalGestionada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clientes.Consignee;
import clientes.Shipper;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import empresaTransportista.EmpresaTransportista;
import naviera.Naviera;
import naviera.viaje.Viaje;
import punto.Punto;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuito;


class TerminalGestionadaTest {
	
	private TerminalGestionada terminalGest;
	
	private Naviera nav1;
	private Naviera nav2;
	private Naviera nav3;
	
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	private Viaje viaje4;
	private Viaje viaje5;
	private Viaje viaje6;
	
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	private TerminalPortuaria terminal4;
	
	private Consignee cons1;
	private Consignee cons2;
	
	private Shipper ship1;
	private Shipper ship2;
	
	private EmpresaTransportista trans1;
	private EmpresaTransportista trans2;
	
	private Conductor conductor1;
	private Conductor conductor2;
	
	private Camion camion1;
	private Camion camion2;

	@BeforeEach
	void setUp() throws Exception {
		
		CriterioCircuito criterio = mock(CriterioCircuito.class);
		Punto punto = mock(Punto.class);
		
		this.terminalGest = new TerminalGestionada(punto, criterio);

		this.nav1 = mock(Naviera.class);
		this.nav2 = mock(Naviera.class);
		this.nav3 = mock(Naviera.class);
	
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		this.viaje4 = mock(Viaje.class);
		this.viaje5 = mock(Viaje.class);
		this.viaje6 = mock(Viaje.class);
		
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.terminal3 = mock(TerminalPortuaria.class);
		this.terminal4 = mock(TerminalPortuaria.class);
		
		this.cons1 = mock(Consignee.class);
		this.cons2 = mock(Consignee.class);
		
		this.ship1 = mock(Shipper.class);
		this.ship2 = mock(Shipper.class);
		
		this.trans1 = mock(EmpresaTransportista.class);
		this.trans2 = mock(EmpresaTransportista.class);
		
		this.conductor1 = mock(Conductor.class);
		this.conductor2 = mock(Conductor.class);
		
		this.camion1 = mock(Camion.class);
		this.camion2 = mock(Camion.class);
		
		when(nav1.getViajes()).thenReturn(List.of(viaje1,viaje2));
		when(nav2.getViajes()).thenReturn(List.of(viaje3,viaje4));
		when(nav3.getViajes()).thenReturn(List.of(viaje5,viaje6));
		
		terminalGest.add(nav1);
		terminalGest.add(nav2);
	}

	@Test
	void testAddNaviera() {
		assertTrue(this.terminalGest.add(nav3));
	}
	
	@Test
	void testAddShipper() {
		assertTrue(this.terminalGest.add(ship1));
	}
	@Test
	void testAddConsignee() {
		assertTrue(this.terminalGest.add(cons1));}
	
	@Test
	void testAddEmpresa() {
		assertTrue(this.terminalGest.add(trans1));
		}
	
	@Test
	void testAddConductor() {
		assertTrue(this.terminalGest.add(conductor1));
		}
	
	@Test
	void testAddCamion() {
		assertTrue(this.terminalGest.add(camion1));
		}
	
	@Test
	void testAddOrdenImport() {}
	
	@Test
	void testAddOrdenExport() {}
	
	@Test
	void testSetCriterio() {}
	
	@Test
	void testCalcularMejorCircuito() {}
	
	@Test
	void testViajesConCirtuito() {}
	
	@Test
	void testExportar() {}
	
	@Test
	void testImportar() {}
	
	@Test
	void testproximaSalidaBuque() {
		when(viaje1.contieneTerminal(terminal1)).thenReturn(true);
		when(viaje2.contieneTerminal(terminal1)).thenReturn(false);
		when(viaje3.contieneTerminal(terminal1)).thenReturn(true);
		when(viaje4.contieneTerminal(terminal1)).thenReturn(false);
		
		when(viaje1.getFechaDeSalida()).thenReturn(LocalDate.now());
		when(viaje3.getFechaDeSalida()).thenReturn(LocalDate.now().plusDays(5l));
	
		assertEquals(LocalDate.now(), this.terminalGest.proximaSalidaBuque(terminal1));
	}
	
	@Test
	void testfiltrarViajes() {}

	@Test
	void testCuandoTardaEnLlegar() {
		when(viaje1.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(20d);
		when(viaje2.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(30d);
		when(viaje3.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(70d);
		when(viaje4.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(80d);
		
		assertEquals(20d, terminalGest.cuantoTardaEnLlegar(nav1, terminal1));
	}
}