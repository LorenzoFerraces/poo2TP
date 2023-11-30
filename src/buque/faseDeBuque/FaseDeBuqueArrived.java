package buque.faseDeBuque;

import buque.Buque;

public class FaseDeBuqueArrived implements FaseDeBuque {


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
		// No contemplado en el trabajo
		unBuque.cambiarFase();
	}
	
	@Override
	public void depart(Buque unBuque) {
		// Implementado en la fase Working
	}
	
	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

}
