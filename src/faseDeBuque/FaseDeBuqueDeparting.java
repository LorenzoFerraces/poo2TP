package faseDeBuque;

import TpFinal.TerminalPortuaria;

public class FaseDeBuqueDeparting implements FaseDeBuque{


	// Retorna la primera fase, ya que this es la última
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		if (unBuque.calcularDistanciaATerminal() > 1.0) {
			return new FaseDeBuqueOutbound(); 
		}
		return this;
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
	public void avisarPartidaATerminal(Buque unBuque) {
		unBuque.getTerminal().notificarShippersSobrePartidaDeBuque(unBuque);
	}

	
}
