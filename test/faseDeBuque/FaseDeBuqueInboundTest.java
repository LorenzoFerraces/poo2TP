package faseDeBuque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueArrived;
import buque.faseDeBuque.FaseDeBuqueInbound;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

class FaseDeBuqueInboundTest {

	private FaseDeBuqueInbound faseInbound;
	private Buque buque;
	private TerminalGestionada terminal;
	
	@BeforeEach
	void setUp() throws Exception {
		faseInbound = new FaseDeBuqueInbound();
		buque = mock(Buque.class);
		terminal = mock(TerminalGestionada.class);
	}

	@Test
	void testElBuqueTieneLaMismaPosicionQueLaTerminalPorLoQueLaSiguienteFaseEsArrived() {
		when(buque.calcularDistanciaATerminal()).thenReturn(0.0);
		
		assertEquals(FaseDeBuqueArrived.class, faseInbound.siguienteFase(buque).getClass());
	}

	@Test
	void testElBuqueNoTieneLaMismaPosicionQueLaTerminalPorLoQueLaSiguienteFaseEsLaMisma() {
		when(buque.calcularDistanciaATerminal()).thenReturn(14.00);
		
		assertEquals(faseInbound.getClass(), faseInbound.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseInboundAvisaALaTerminalSobreLaLlegada() {
		when(buque.getTerminal()).thenReturn(terminal);
		
		faseInbound.avisarInminenteArriboATerminal(buque);
		
		verify(terminal).notificarConsigneesSobreLlegadaDeBuque(buque); // Verifica que se haya disparado el mensaje
		verify(buque).cambiarFase();
	}

	@Test
	void testLaFaseInboundNoRealizaLaCargaYDescarga() {
		// Responsabilidad de la fase Arrived
		faseInbound.realizarCargaYDescarga(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseInboundNoHaceNadaCuandoRecibeElMensajeDepart() {
		// Responsabilidad de la fase Working
		faseInbound.depart(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseInboundNoAvisaALaTerminalSobreSuPartida() {
		// Responsabilidad de la fase Departing
		faseInbound.avisarPartidaATerminal(buque);
		
		verifyNoInteractions(buque);
	}

}
