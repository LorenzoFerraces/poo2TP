package test.naviera.circuitoMaritimo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalPortuaria;

class CircuitoMaritimoTest {

	private CircuitoMaritimo circuito;
	private Tramo tramo1;
	private Tramo tramo2; 
	private Tramo tramo3; 
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	private TerminalPortuaria terminal4;

	@BeforeEach
	void setUp() throws Exception {
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.terminal3 = mock(TerminalPortuaria.class);
		this.terminal4 = mock(TerminalPortuaria.class);
		
		this.tramo1 = mock(Tramo.class);
		this.tramo2 = mock(Tramo.class);
		this.tramo3 = mock(Tramo.class);
		
		when(tramo1.contieneTerminal(terminal1)).thenReturn(true);
		when(tramo1.contieneTerminal(terminal2)).thenReturn(true);
		when(tramo2.contieneTerminal(terminal2)).thenReturn(true);
		when(tramo2.contieneTerminal(terminal3)).thenReturn(true);
		when(tramo3.contieneTerminal(terminal3)).thenReturn(true);
		when(tramo3.contieneTerminal(terminal4)).thenReturn(true);

		when(tramo1.getOrigen()).thenReturn(terminal1);
		when(tramo1.getDestino()).thenReturn(terminal2);
		when(tramo2.getOrigen()).thenReturn(terminal2);
		when(tramo2.getDestino()).thenReturn(terminal3);
		when(tramo3.getOrigen()).thenReturn(terminal3);
		when(tramo3.getDestino()).thenReturn(terminal4);
		
		this.circuito = new CircuitoMaritimo();
	}

	@Test
	void agregarTramoACircuitoVacio() throws Exception {
		assertTrue(circuito.agregarTramo(tramo1));
	}

	@Test
	void agregarTramosInvalidos() throws Exception {
		circuito.agregarTramo(tramo1);
		assertThrows(Exception.class, () -> circuito.agregarTramo(tramo1));
	}
	
	@Test
	void verificarTramoValido() throws Exception {
		circuito.agregarTramo(tramo1);
		assertTrue(circuito.agregarTramo(tramo2));
	}
	
	@Test
	void contieneTerminal() throws Exception {
		circuito.agregarTramo(tramo1);
		
		assertTrue(circuito.contieneTerminal(terminal1));
	}
	
	@Test
	void noContieneTerminal() {
		assertFalse(circuito.contieneTerminal(terminal1));
	}
	
	@Test
	void tiempoTotal() throws Exception {
		when(tramo1.getTiempo()).thenReturn(100d);
		when(tramo2.getTiempo()).thenReturn(120d);
		when(tramo3.getTiempo()).thenReturn(80d);
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		circuito.agregarTramo(tramo3);
		assertEquals(300d, circuito.tiempoTotal());
	}

	@Test
	void precioTotal() throws Exception {
		when(tramo1.getPrecio()).thenReturn(50d);
		when(tramo2.getPrecio()).thenReturn(75d);
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertEquals(125d, circuito.precioTotal());
	}
	
	@Test
	void cantidadDeTramosCero() {
		assertEquals(0, circuito.cantidadTramos());
	}
	
	@Test
	void cantidadDeTramosNoCero() throws Exception { 
		circuito.agregarTramo(tramo1);
		assertEquals(1, circuito.cantidadTramos());
	}
	
	@Test
	void testContieneOrigenYDestino() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertTrue(circuito.contieneOrigenYDestino(terminal1, terminal3));
	}
	
	@Test
	void testTiempoEntreTerminales() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		circuito.agregarTramo(tramo3);
		
		when(tramo1.getTiempo()).thenReturn(100d);
		when(tramo2.getTiempo()).thenReturn(120d);
		when(tramo3.getTiempo()).thenReturn(80d);
		
		assertEquals(300d, circuito.getTiempoEntreTerminales(this.terminal1, this.terminal4));
		
	}
}
