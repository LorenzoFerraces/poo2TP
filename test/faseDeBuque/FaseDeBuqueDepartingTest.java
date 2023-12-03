package faseDeBuque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueDeparting;
import buque.faseDeBuque.FaseDeBuqueOutbound;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

class FaseDeBuqueDepartingTest {
	
	private FaseDeBuqueDeparting faseDeparting;
	private Buque buque;
	private TerminalGestionada terminal;
	
	@BeforeEach
	void setUp() throws Exception {
		faseDeparting = new FaseDeBuqueDeparting();
		buque = mock(Buque.class);
		terminal = mock(TerminalGestionada.class);
	}

	@Test
	void testLaSiguienteFaseEsOutbound() {
		assertEquals(FaseDeBuqueOutbound.class, faseDeparting.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseDepartingNoAvisaALaTerminalSobreLaLlegada() {
		// Responsabilidad de la fase Inbound
		faseDeparting.avisarInminenteArriboATerminal(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseDepartingnNoRealizaLaCargaYDescarga() {
		// Responsabilidad de la fase Arrived
		faseDeparting.realizarCargaYDescarga(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseDepartingNoHaceNadaCuandoRecibeElMensajeDepart() {
		// Responsabilidad de la fase Working
		faseDeparting.depart(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaDistanciaALaTerminalEsMayorA1KilometroPorLoQueSeNotificaLaPartidaDelBuque() {
		// Setup
		when(buque.getTerminal()).thenReturn(terminal);
		when(buque.calcularDistanciaATerminal()).thenReturn(1.02);
		
		// Exercise
		faseDeparting.avisarPartidaATerminal(buque);
		
		verify(terminal).notificarClientesSobrePartidaDeBuque(buque); // Verifica que se haya disparado el mensaje
		verify(buque).cambiarFase();
	}
	
	@Test
	void testNoSeNotificaLaPartidaDelBuquePorqueLaDistanciaALaTerminalEsMenorA1Kilometro() {
		// Setup
		when(buque.getTerminal()).thenReturn(terminal);
		when(buque.calcularDistanciaATerminal()).thenReturn(0.92);
		
		// Exercise
		faseDeparting.avisarPartidaATerminal(buque);
		
		verifyNoInteractions(terminal); // Verifica que no se haya disparado el mensaje
		verify(buque, times(0)).cambiarFase();; // Verifica que no haya intento de cambio de fase
	}
}
