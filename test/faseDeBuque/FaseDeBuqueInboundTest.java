package faseDeBuque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;

class FaseDeBuqueInboundTest {

	private FaseDeBuqueInbound faseInbound;
	private Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		faseInbound = new FaseDeBuqueInbound();
		buque = mock(Buque.class);
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
		faseInbound.avisarArriboATerminal(buque);
		
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
