package test.TerminalPortuaria.TerminalGestionada;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.Naviera;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;
import viaje.Viaje;


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

	@BeforeEach
	void setUp() throws Exception {
		
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
		
		when(nav1.getViajes()).thenReturn(List.of(viaje1,viaje2));
		when(nav2.getViajes()).thenReturn(List.of(viaje3,viaje4));
		when(nav3.getViajes()).thenReturn(List.of(viaje5,viaje6));
	}

	@Test
	void testAddNaviera() {}
	
	@Test
	void testAddShipper() {}
	
	@Test
	void testAddConsignee() {}
	
	@Test
	void testAddEmpresa() {}
	
	@Test
	void testAddConductor() {}
	
	@Test
	void testAddCamion() {}
	
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
	void testproximaSalidaBuque() {}
	
	@Test
	void testfiltrarViajes() {}

	@Test
	void testCuandoTardaEnLlegar() {
		when(viaje1.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(20d);
		when(viaje2.getTiempoEntreTerminales(terminalGest, terminal1)).thenReturn(30d);
		
		assertEquals(20d, terminalGest.cuantoTardaEnLlegar(nav1, terminal1));
	}
}