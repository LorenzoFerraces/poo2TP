package test.naviera.circuitoMaritimo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

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
	private Tramo tramo3;
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	private TerminalPortuaria terminal4;

	@BeforeEach
	void setUp() throws Exception {
		this.terminal1 = new TerminalPortuaria(new Punto(5d,10d));
		this.terminal2 = new TerminalPortuaria(new Punto(10d,15d));
		this.terminal3 = new TerminalPortuaria(new Punto(15d,20d));
		this.terminal3 = new TerminalPortuaria(new Punto(20d,25d));
		
		this.tramo1 = new Tramo(terminal1,terminal2, 20d, 100d);
		this.tramo2 = new Tramo(terminal2,terminal3, 50d, 300d);
		this.tramo3 = new Tramo(terminal3,terminal4, 15d, 150d);

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
		assertEquals(70d, circuito.tiempoTotal());
	}

	@Test
	void precioTotal() throws Exception {
		circuito.agregarTramo(tramo1);
		circuito.agregarTramo(tramo2);
		assertEquals(400d, circuito.precioTotal());
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
}
