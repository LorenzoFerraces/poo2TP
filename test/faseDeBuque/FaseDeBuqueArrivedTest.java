package faseDeBuque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueArrived;
import buque.faseDeBuque.FaseDeBuqueWorking;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

class FaseDeBuqueArrivedTest {
	
	private FaseDeBuqueArrived faseArrived;
	private Buque buque;
	private TerminalGestionada terminal;
	
	@BeforeEach
	void setUp() throws Exception {
		faseArrived = new FaseDeBuqueArrived();
		buque = mock(Buque.class);
		terminal = mock(TerminalGestionada.class);
	}

	@Test
	void testLaSiguienteFaseEsWorking() {
		assertEquals(FaseDeBuqueWorking.class, faseArrived.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseArrivedNoAvisaALaTerminalSobreLaInminenteLlegada() {
		// Responsabilidad de la fase Inbound
		faseArrived.avisarInminenteArriboATerminal(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseArrivedAvisaALaTerminalSobreLaLlegada() {
		when(buque.getTerminal()).thenReturn(terminal);
		
		faseArrived.avisarArriboATerminal(buque);
		
		verify(terminal).recibirNotificacionDeArriboDeBuque(buque);
	}
	
	@Test
	void testLaFaseArrivedRealizaLaCargaYDescarga() {
		faseArrived.realizarCargaYDescarga(buque);
		
		verify(buque).cambiarFase();
	}

	@Test
	void testLaFaseArrivedNoHaceNadaCuandoRecibeElMensajeDepart() {
		// Responsabilidad de la fase Working
		faseArrived.depart(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseArrivedNoAvisaALaTerminalSobreSuPartida() {
		// Responsabilidad de la fase Departing
		faseArrived.avisarPartidaATerminal(buque);
		
		verifyNoInteractions(buque);
	}
}
