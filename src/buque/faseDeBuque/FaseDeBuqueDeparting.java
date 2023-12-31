package buque.faseDeBuque;

import buque.Buque;

public class FaseDeBuqueDeparting implements FaseDeBuque {


	// Retorna la primera fase, ya que this es la última
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		return new FaseDeBuqueOutbound();
	}

	@Override
	public void avisarInminenteArriboATerminal(Buque unBuque) {
		// Implementado en la fase Inbound
	}

	@Override
	public void avisarArriboATerminal(Buque unBuque) {
		// Implementando en la fase Arrived
	}
	
	@Override
	public void realizarCargaYDescarga(Buque unBuque) {
		// Implementado en la fase Arrived
	}

	@Override
	public void depart(Buque unBuque) {
		// Implementado en la fase Working
	}
	
	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		if (unBuque.calcularDistanciaATerminal() > 1.0) {
			unBuque.getTerminal().notificarClientesSobrePartidaDeBuque(unBuque);
			unBuque.cambiarFase();
		}
	}

}
