package buque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.faseDeBuque.*;
import buque.gps.GPS;
import container.Container;
import punto.Punto;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

class BuqueTest {

	private Buque unBuque;
	private GPS gps;
	private List<Container> carga;
	private TerminalGestionada terminal;
	private Punto puntoBuque;
	private Punto puntoTerminal;
	private FaseDeBuqueOutbound faseOutbound;
	private FaseDeBuqueInbound faseInbound;
	private FaseDeBuqueArrived faseArrived;
	private FaseDeBuqueWorking faseWorking;
	private FaseDeBuqueDeparting faseDeparting;
	
	@BeforeEach
	void setUp() throws Exception {
		faseOutbound = mock(FaseDeBuqueOutbound.class);
		faseInbound = mock(FaseDeBuqueInbound.class);
		faseArrived = mock(FaseDeBuqueArrived.class);
		faseWorking = mock(FaseDeBuqueWorking.class);
		faseDeparting = mock(FaseDeBuqueDeparting.class);
		
		puntoBuque = mock(Punto.class);
		puntoTerminal = mock(Punto.class);
		
		gps = mock(GPS.class);
		when(gps.getPosicion()).thenReturn(puntoBuque); // gps.getPosicion() ejecutado en constructor de Buque
		
		carga = new ArrayList<Container>();
		terminal = mock(TerminalGestionada.class);
		unBuque = new Buque(carga, gps, terminal, faseOutbound);
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
	void testUnBuqueConoceSuGPS() {
		assertEquals(gps, unBuque.getGPS());
	}
	
	@Test
	void testUnBuqueRecienCreadoEstaEnFaseOutbound() {
		assertEquals(FaseDeBuqueOutbound.class, unBuque.getFase().getClass());
	}
	
	@Test
	void testUnBuquePuedeSaberSuPosicion() {
		assertEquals(puntoBuque, unBuque.getPosicion());
	}
	
	@Test
	void testUnBuqueActualizaSuPosicionPorLoQueIntentaCambiarDeFase() {
		// Setup
		Punto nuevaPosicion = mock(Punto.class);
		when(gps.getPosicion()).thenReturn(nuevaPosicion);
		
		// Exercise
		unBuque.actualizarPosicion();
		
		verify(gps, times(2)).getPosicion(); // Se invoca al inicializar el buque y en actualizarPosicion()
		assertEquals(nuevaPosicion, unBuque.getPosicion());
		verify(faseOutbound, times(1)).siguienteFase(unBuque); // Verifica que la fase haya recibido el mensaje para el cambio
	}
	
	@Test
	void testUnBuquePuedeSaberLaDistanciaEnKilometrosALaTerminal() {
		// Setup
		Double distanciaEsperada = Double.valueOf(62.4);
		when(terminal.getCoordenadas()).thenReturn(puntoTerminal);
		when(puntoBuque.calcularDistancia(puntoTerminal)).thenReturn(distanciaEsperada);
		
		// Exercise
		Double distanciaObtenida = unBuque.calcularDistanciaATerminal();
		
		assertEquals(distanciaEsperada, distanciaObtenida);
	}

	@Test
	void testUnBuqueEnFaseOutboundPasaAFaseInbound() {
		when(faseOutbound.siguienteFase(unBuque)).thenReturn(faseInbound);
		
		unBuque.cambiarFase();
		
		assertEquals(FaseDeBuqueInbound.class, unBuque.getFase().getClass());
	}
	
	@Test
	void testUnBuqueDelegaASuFaseElAvisoALaTerminal() {
		unBuque.avisarArriboATerminal();
		
		verify(unBuque.getFase()).avisarArriboATerminal(unBuque); // Verifica la delegacion a la fase
	}

	@Test
	void testUnBuqueEnFaseInboundQueLlegaALaTerminalPasaAFaseArrived() {
		// Setup
		when(faseOutbound.siguienteFase(unBuque)).thenReturn(faseInbound);
		when(faseInbound.siguienteFase(unBuque)).thenReturn(faseArrived);
		unBuque.cambiarFase(); // Pasa a fase Inbound
		
		// Exercise
		unBuque.cambiarFase(); // Pasa a fase Arrived
		
		assertEquals(FaseDeBuqueArrived.class, unBuque.getFase().getClass());
	}
	
	@Test
	void testUnBuqueDelegaLaCargaYDescargaASuFase() {
		unBuque.realizarCargaYDescarga();
		
		verify(unBuque.getFase()).realizarCargaYDescarga(unBuque); // Verifica la delegacion a la fase
	}

	@Test
	void testUnBuqueQueRecibeElMensajeDepartSeLoDelegaASuEstado() {
		unBuque.depart();
		
		verify(unBuque.getFase()).depart(unBuque); // Verifica la delegacion a la fase
	}
	
	@Test
	void testUnBuqueDelegaASuFaseElAvisoDePartidaALaTerminal() {
		unBuque.avisarPartidaATerminal();
		
		verify(unBuque.getFase()).avisarPartidaATerminal(unBuque); // Verifica la delegacion a la fase
	}
	
	@Test
	void testUnBuqueEnFaseDepartPasaAFaseOutboundCuandoSeAlejaDeLaTerminal() {
		// Setup
		when(faseOutbound.siguienteFase(unBuque)).thenReturn(faseInbound);
		when(faseInbound.siguienteFase(unBuque)).thenReturn(faseArrived);
		when(faseArrived.siguienteFase(unBuque)).thenReturn(faseWorking);
		when(faseWorking.siguienteFase(unBuque)).thenReturn(faseDeparting);
		when(faseWorking.siguienteFase(unBuque)).thenReturn(faseOutbound);
		unBuque.cambiarFase(); // Pasa a fase Inbound
		unBuque.cambiarFase(); // Pasa a fase Arrived
		unBuque.cambiarFase(); // Pasa a fase Working
		
		unBuque.cambiarFase();
		
		assertEquals(FaseDeBuqueOutbound.class, unBuque.getFase().getClass());
	}

}
