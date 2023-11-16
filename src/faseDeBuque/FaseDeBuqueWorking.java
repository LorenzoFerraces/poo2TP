package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueWorking implements FaseDeBuque{


	// Retorna la fase 5 de 5
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		return new FaseDeBuqueDeparting();
	}

	@Override
	public void avisarArriboATerminal(Buque unBuque) {
		// Implementado en la fase Inbound
	}

	@Override
	public void realizarCargaYDescarga(Buque unBuque) {
		// Implementado en la fase Arrived
	}

	@Override
	public void depart(Buque unBuque) {
		unBuque.cambiarFase();
	}
	
	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

	// No realiza nada, pues el buque esta realizando la carga y descarga
	@Override
	public void navegar(Buque unBuque) {
		// Se queda en su posicion
	}

	
}
