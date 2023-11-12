package faseDeBuque;

import TpFinal.TerminalPortuaria;

public class FaseDeBuqueArrived implements FaseDeBuque{


	// Retorna la fase 4 de 5
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		return new FaseDeBuqueWorking();
	}

	@Override
	public void avisarArriboATerminal(Buque unBuque) {
		// Implementado en la fase Inbound
	}

	@Override
	public void realizarCargaYDescarga(Buque unBuque) {
		unBuque.cambiarFase(this.siguienteFase());
	}

	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

	
}
