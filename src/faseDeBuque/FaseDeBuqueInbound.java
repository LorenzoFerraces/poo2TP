package faseDeBuque;

import TpFinal.TerminalPortuaria;

public class FaseDeBuqueInbound implements FaseDeBuque{


	// Retorna la fase 3 de 5 cuando las coordenadas del buque y la terminal coinciden
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		if (unBuque.calcularDistanciaATerminal() == 0.0) {
			return new FaseDeBuqueArrived();
		}
		return this;
	}

	@Override
	public void avisarArriboATerminal(Buque unBuque) {
		unBuque.getTerminal().notificarConsigneesSobreLlegadaDeBuque(unBuque);
	}

	@Override
	public void realizarCargaYDescarga(Buque unBuque) {
		// Implementado en la fase Arrived
	}

	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

	
}
