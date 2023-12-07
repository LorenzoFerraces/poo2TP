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
import naviera.viaje.Viaje;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

class NavieraTest {
	
	private Naviera nav;
	private Buque buq;
	private Buque buq2;
	private CircuitoMaritimo circ;
	private CircuitoMaritimo circ2;
	private CircuitoMaritimo circ3;
	private TerminalPortuaria t1;
	private TerminalPortuaria t2;
	
	@BeforeEach
	void setUp() throws Exception {
		this.nav = new Naviera();	
		this.buq = mock(Buque.class);
		this.buq2 = mock(Buque.class);
		this.circ = mock(CircuitoMaritimo.class);
		this.circ2 = mock(CircuitoMaritimo.class);
		this.circ3 = mock(CircuitoMaritimo.class);
		this.t1 = mock(TerminalPortuaria.class);
		this.t2 = mock(TerminalPortuaria.class);

		
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
	
	@Test
	void testViajesConCircuito() throws Exception {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		
		this.nav.addViaje(circ, buq, LocalDate.now());
		this.nav.addViaje(circ2, buq2, LocalDate.now());
		
		assertEquals(1, this.nav.viajesConCircuito(circ).size());
	}

	@Test
	void testCircuitosConTerminal() {
		this.nav.addCircuito(circ);;
		this.nav.addCircuito(circ2);
		this.nav.addCircuito(circ3);
		
		when(circ.contieneTerminal(t1)).thenReturn(true);
		when(circ2.contieneTerminal(t1)).thenReturn(true);
		when(circ3.contieneTerminal(t1)).thenReturn(false);
		assertEquals(2,this.nav.circuitosConTerminal(t1).size());
	}

	@Test
	void testViajesConTerminal() throws Exception {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		
		this.nav.addViaje(circ, buq, LocalDate.now());
		this.nav.addViaje(circ2, buq2, LocalDate.now());
		
		when(circ.contieneTerminal(t1)).thenReturn(false);
		when(circ2.contieneTerminal(t1)).thenReturn(true);
		assertEquals(1, this.nav.viajesConTerminal(t1).size()); 
	}
	
	@Test 
	void testCuantoTardaEnLlegarA() throws Exception {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		
		this.nav.addViaje(circ, buq, LocalDate.now());
		this.nav.addViaje(circ2, buq2, LocalDate.now());
		
		when(circ.tiempoEntre(t1, t2)).thenReturn(30d);
		when(circ2.tiempoEntre(t1, t2)).thenReturn(50d);
		
		assertEquals(30d, this.nav.cuantoTardaEnLlegarA(t1, t2));
	}

	@Test
	void testProximaSalidaBuque() throws Exception {
		this.nav.addCircuito(circ);
		this.nav.addCircuito(circ2);
		
		this.nav.addBuque(buq);
		this.nav.addBuque(buq2);
		
		this.nav.addViaje(circ, buq, LocalDate.now().minusDays(3l));
		this.nav.addViaje(circ2, buq2, LocalDate.now());
		
		when(circ.contieneTerminal(t1)).thenReturn(true);
		when(circ2.contieneTerminal(t1)).thenReturn(true);
		
		assertEquals(LocalDate.now().minusDays(3l), this.nav.proximaSalidaBuque(t1));
	}
	

}
