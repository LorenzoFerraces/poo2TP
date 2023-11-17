package test.naviera.circuitoMaritimo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import naviera.circuitoMaritimo.tramo.Tramo;
import punto.Punto;
import terminalPortuaria.TerminalPortuaria;

class CircuitoMaritimoTest {

	private CircuitoMaritimo circuito;
	private Tramo tramo1;
	private Tramo tramo2;
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;

	@BeforeEach
	void setUp() throws Exception {
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.terminal3 = mock(TerminalPortuaria.class);
		
		this.tramo1 = mock(Tramo.class);
		this.tramo2 = mock(Tramo.class);
		
		when(tramo1.contieneTerminal(terminal1)).thenReturn(true);
		when(tramo1.contieneTerminal(terminal1)).thenReturn(true);

		when(tramo1.getOrigen()).thenReturn(terminal1);
		when(tramo1.getDestino()).thenReturn(terminal2);
		when(tramo2.getOrigen()).thenReturn(terminal2);
		when(tramo2.getDestino()).thenReturn(terminal3);

		when(tramo1.getPrecio()).thenReturn(50d);
		when(tramo2.getPrecio()).thenReturn(75d);

		when(tramo1.getTiempo()).thenReturn(100d);
		when(tramo2.getTiempo()).thenReturn(120d);
		
		
		
		
		
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
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertEquals(220d, circuito.tiempoTotal());
	}

	@Test
	void precioTotal() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertEquals(125d, circuito.precioTotal());
	}
	
	@Test
	void subCircuitoInvalido() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertFalse(circuito.subCircuito(terminal3, terminal1).contieneTerminal(terminal1));
	}
	
	@Test
	void subCircuitoValido() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertFalse(circuito.subCircuito(terminal1, terminal3).contieneTerminal(terminal1));
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
}
