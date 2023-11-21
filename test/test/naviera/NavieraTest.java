package test.naviera;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import naviera.Naviera;
import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

class NavieraTest {
	
	private Naviera nav;
	private Buque buq;
	private Buque buq2;
	private CircuitoMaritimo circ;
	private CircuitoMaritimo circ2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.nav = new Naviera();	
		this.buq = mock(Buque.class);
		this.buq2 = mock(Buque.class);
		this.circ = mock(CircuitoMaritimo.class);
		this.circ2 = mock(CircuitoMaritimo.class);
	}
	
	@Test
	void testAddBuque() {
		assertTrue(nav.addBuque(this.buq));
	}
	
	@Test
	void testAddCircuitoMaritimo() {
		assertTrue(nav.addCircuito(this.circ));
	}
	
	@Test
	void testAddViajeConComponenetesConocidos() throws Exception {
		this.nav.addBuque(this.buq);
		this.nav.addCircuito(this.circ);
		assertTrue(nav.addViaje(this.circ, this.buq, LocalDate.now()));
	}
	
	@Test
	void testAddViajeSinComponenetesConocidos() {
		assertThrows(Exception.class, () -> this.nav.addViaje(this.circ, this.buq, LocalDate.now()));
	}
	
	@Test
	void testViajesQuePasanPor() throws Exception {
		TerminalPortuaria t1 = mock(TerminalPortuaria.class);
		TerminalPortuaria t2 = mock(TerminalPortuaria.class);

		when(circ.contieneOrigenYDestino(t1,t2)).thenReturn(true);
		when(circ2.contieneOrigenYDestino(t1,t2)).thenReturn(false);
		
		this.nav.addBuque(buq);
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addViaje(circ, buq, LocalDate.now());
		this.nav.addViaje(circ2, buq, LocalDate.now());
		
		assertEquals(1, this.nav.viajesQuePasanPor(t1, t2).size());
	}
	
	@Test
	void testCircuitosDisponibles() {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		List<CircuitoMaritimo> circuitos = this.nav.getCircuitos();
		assertAll(
			() -> assertTrue(circuitos.contains(circ)),
			() -> assertTrue(circuitos.contains(circ2)));
	}
	
	@Test
	void testBuquesDisponibles() {
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		List<Buque> buques = this.nav.getBuques();
		assertAll(
			() -> assertTrue(buques.contains(buq)),
			() -> assertTrue(buques.contains(buq2)));
	}
	
	@Test
	void testViajesDisponibles() throws Exception {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		
		this.nav.addViaje(circ, buq, LocalDate.now());
		this.nav.addViaje(circ2, buq2, LocalDate.now());
		List<Viaje> viajes = this.nav.getViajes();
		assertEquals(2, viajes.size());
	}
	
	


}
