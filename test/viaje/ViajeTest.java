package viaje;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import naviera.viaje.Viaje;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

class ViajeTest {
	Viaje miViaje;
	CircuitoMaritimo circuito;
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;
	LocalDate fechaSalida;
	Buque bu;
	
	
	@BeforeEach
	void setUp() throws Exception {
		this.circuito = mock(CircuitoMaritimo.class);
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.bu = mock(Buque.class);
		this.fechaSalida = LocalDate.now();
		this.miViaje = new Viaje(this.circuito, bu, this.fechaSalida);
		when(circuito.tiempoTotal()).thenReturn(5d);
	}

	@Test
	void sePuedeObtenerElCircuitoQueVaASeguirElViaje() {
		assertEquals(miViaje.getCircuito(), this.circuito);
	}
	
	@Test
	void sePuedeObtenerLaFechaDeSalidaDelViaje() {
		assertEquals(miViaje.getFechaDeSalida(), this.fechaSalida);
	}
	
	
	@Test
	void sePuedeCalcularELTiempoDeViajeEntreDosTerminales() {
		double tiempo_esperado = 1200.0; //Valor expresado en minutos
		when(circuito.getTiempoEntreTerminales(terminal1, terminal2)).thenReturn(tiempo_esperado);
		
		assertEquals(this.miViaje.getTiempoEntreTerminales(terminal1, terminal2), tiempo_esperado);
		
		verify(circuito).getTiempoEntreTerminales(terminal1, terminal2); //Verifcar que se llame a la funcion de circuito
	}
	
	@Test
	void testContieneTerminal() {
		when(miViaje.contieneTerminal(terminal1)).thenReturn(true);
		
		assertTrue(this.miViaje.contieneTerminal(terminal1));
		
		verify(this.circuito).contieneTerminal(terminal1);
	}
	
	@Test
	void testNoContieneTerminal() {
		when(miViaje.contieneTerminal(terminal2)).thenReturn(false);
		
		assertFalse(this.miViaje.contieneTerminal(terminal2));
		
		verify(this.circuito).contieneTerminal(terminal2);
	}
	
	@Test
	void testFechaLlegada() {
		LocalDate esperado = LocalDate.now().plusDays((long)Math.ceil(5d));
		assertEquals(esperado, this.miViaje.getFechaLlegada());
	}
	
	@Test
	void testVieneDespuesDe() {
		when(this.circuito.vieneDespuesDe(terminal1, terminal2)).thenReturn(true);
		assertTrue(this.miViaje.vieneDespuesDe(terminal1, terminal2));
		
	}

}
