package faseDeBuque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueInbound;
import buque.faseDeBuque.FaseDeBuqueOutbound;

class FaseDeBuqueOutboundTest {

	private FaseDeBuqueOutbound faseOutbound;
	private Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		faseOutbound = new FaseDeBuqueOutbound();
		buque = mock(Buque.class);
	}

	@Test
	void testElBuqueEstaCercaDeLaTerminalPorLoQueLaSiguienteFaseEsInbound() {
		when(buque.calcularDistanciaATerminal()).thenReturn(49.00);
		
		assertEquals(new FaseDeBuqueInbound().getClass(), faseOutbound.siguienteFase(buque).getClass());
	}

	@Test
	void testElBuqueEstaLejosDeLaTerminalPorLoQueLaSiguienteFaseEsLaActual() {
		when(buque.calcularDistanciaATerminal()).thenReturn(51.00);
		
		assertEquals(faseOutbound.getClass(), faseOutbound.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseOutboundNoAvisaALaTerminalSobreLaLlegada() {
		// Responsabilidad de la fase Inbound
		faseOutbound.avisarInminenteArriboATerminal(buque);
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseOutboundNoRealizaLaCargaYDescarga() {
		// Responsabilidad de la fase Arrived
		faseOutbound.realizarCargaYDescarga(buque);
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseOutboundNoHaceNadaCuandoRecibeElMensajeDepart() {
		// Responsabilidad de la fase Working
		faseOutbound.depart(buque);
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseOutboundNoAvisaALaTerminalSobreSuPartida() {
		// Responsabilidad de la fase Depart
		faseOutbound.avisarPartidaATerminal(buque);
		verifyNoInteractions(buque);
	}

}
