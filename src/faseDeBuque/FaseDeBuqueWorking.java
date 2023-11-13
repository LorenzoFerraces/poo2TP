package faseDeBuque;

import TpFinal.TerminalPortuaria;

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
		unBuque.cambiarFase(this.siguienteFase());
	}
	
	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

	
}
