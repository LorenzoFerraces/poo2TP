package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;
import containers.Container;
import faseDeBuque.*;
import gps.GPS;

class BuqueTest {

	private Buque unBuque;
	private GPS gps;
	private List<Container> carga;
	private Container container;
	private TerminalPortuaria terminal;
	Punto puntoBuque;
	Punto puntoTerminal;
	
	@BeforeEach
	void setUp() throws Exception {
		gps = mock(GPS.class);
		container = mock(Container.class);
		carga = new ArrayList<Container>();
		carga.add(container);
		terminal = mock(TerminalPortuaria.class);
		unBuque = new Buque(carga, gps, terminal);
		
		puntoBuque = mock(Punto.class);
		puntoTerminal = mock(Punto.class);
	}

	@Test
	void testUnBuqueConoceSuCarga() {
		assertEquals(carga, unBuque.getCarga());
	}

	@Test
	void testUnBuqueConoceLaTerminal() {
		assertEquals(terminal, unBuque.getTerminal());
	}
	
	@Test
	void testUnBuqueRecienCreadoEstaEnFaseOutbound() {
		assertEquals(FaseDeBuqueOutbound.class, unBuque.getFase().getClass());
	}
	
	@Test
	void testUnBuquePuedeSaberSuPosicion() {
		Punto punto = mock(Punto.class);
		when(gps.getPosicion()).thenReturn(punto);
		
		assertEquals(punto, unBuque.posicion());
	}
	
	@Test
	void testUnBuquePuedeSaberLaDistanciaEnKilometrosALaTerminal() {
		Double distanciaEsperada = Double.valueOf(62.4);
		
		when(gps.getPosicion()).thenReturn(puntoBuque);
		when(terminal.getCoordenadas()).thenReturn(puntoTerminal);
		when(puntoBuque.calcularDistancia(puntoTerminal)).thenReturn(distanciaEsperada);
		
		assertEquals(distanciaEsperada, unBuque.calcularDistanciaATerminal());
	}

	@Test
	void testUnBuqueEnFaseOutboundPasaAFaseInboundSiPuede() {
		// Con menos de 50 kilometros puede pasar a fase inbound
		Double distancia = Double.valueOf(49.00);
		Punto puntoBuque = mock(Punto.class);
		Punto puntoTerminal = mock(Punto.class);
		/*
		when(gps.getPosicion()).thenReturn(puntoBuque);
		when(terminal.getCoordenadas()).thenReturn(puntoTerminal);
		when(puntoBuque.calcularDistancia(puntoTerminal)).thenReturn(distancia);
		*/
		when(unBuque.getFase().siguienteFase(unBuque)).thenReturn(new FaseDeBuqueInbound());
		
		unBuque.cambiarFase();
		
		assertEquals(FaseDeBuqueInbound.class, unBuque.getFase().getClass());
	}
	
	@Test
	void testUnBuqueEnFaseInboundPuedeAvisarALaTerminal() {
		fail("Not yet implemented");
	}

	@Test
	void testUnBuqueEnFaseInboundQueLlegaALaTerminalPasaAFaseArrived() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUnBuqueEnFaseArrivedPuedePasarAFaseWorking() {
		fail("Not yet implemented");
	}

	@Test
	void testUnBuqueEnFaseWorkingPuedePasarAFaseDeparting() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUnBuqueEnFaseDepartPasaAFaseOutboundCuandoSeAlejaDeLaTerminal() {
		// Necesita alejarse un kilometro para poder cambiar de fase
		fail("Not yet implemented");
	}
	
	@Test
	void testUnBuqueQueNoLlegoALaTerminalNavegaHaciaLaMisma() {
		fail("Not yet implemented");
	}
	
	@Test
	void testUnBuqueQueLlegoALaTerminalSeAlejaNavegando() {
		fail("Not yet implemented");
	}

}
