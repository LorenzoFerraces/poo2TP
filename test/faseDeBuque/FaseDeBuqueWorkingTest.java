package faseDeBuque;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import buque.Buque;
import buque.faseDeBuque.FaseDeBuqueDeparting;
import buque.faseDeBuque.FaseDeBuqueWorking;

class FaseDeBuqueWorkingTest {

	private FaseDeBuqueWorking faseWorking;
	private Buque buque;
	
	@BeforeEach
	void setUp() throws Exception {
		faseWorking = new FaseDeBuqueWorking();
		buque = mock(Buque.class);
	}

	@Test
	void testLaSiguienteFaseEsDeparting() {
		assertEquals(FaseDeBuqueDeparting.class, faseWorking.siguienteFase(buque).getClass());
	}
	
	@Test
	void testLaFaseWorkingNoAvisaALaTerminalSobreLaLlegada() {
		// Responsabilidad de la fase Inbound
		faseWorking.avisarArriboATerminal(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseWorkingRealizaLaCargaYDescarga() {
		// Responsabilidad de la fase Arrived
		faseWorking.realizarCargaYDescarga(buque);
		
		verifyNoInteractions(buque);
	}

	@Test
	void testLaFaseWorkingHaceQueElBuqueCambieDeFaseCuandoRecibeElMensajeDepart() {
		faseWorking.depart(buque);
		
		verify(buque).cambiarFase();
	}

	@Test
	void testLaFaseWorkingNoAvisaALaTerminalSobreSuPartida() {
		// Responsabilidad de la fase Departing
		faseWorking.avisarPartidaATerminal(buque);
		
		verifyNoInteractions(buque);
	}

}
