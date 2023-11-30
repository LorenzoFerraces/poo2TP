package faseDeBuque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueDeparting;
import buque.faseDeBuque.FaseDeBuqueOutbound;

class FaseDeBuqueDepartingTest {
	
	private FaseDeBuqueDeparting faseDeparting;
	private Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		faseDeparting = new FaseDeBuqueDeparting();
		buque = mock(Buque.class);
	}

	@Test
	void testLaSiguienteFaseEsOutbound() {
		assertEquals(FaseDeBuqueOutbound.class, faseDeparting.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseDepartingNoAvisaALaTerminalSobreLaLlegada() {
		// Responsabilidad de la fase Inbound
		faseDeparting.avisarArriboATerminal(buque);
		
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
		when(buque.calcularDistanciaATerminal()).thenReturn(1.02);
		
		faseDeparting.avisarPartidaATerminal(buque);
		
		verify(buque).cambiarFase();
	}
}
