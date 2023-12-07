package buque.faseDeBuque;

import buque.Buque;

public class FaseDeBuqueInbound implements FaseDeBuque {


	// Retorna la fase 3 de 5 cuando las coordenadas del buque y la terminal coinciden
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		if (unBuque.calcularDistanciaATerminal() == 0.0) {
			return new FaseDeBuqueArrived();
		}
		return this;
	}

	@Override
	public void avisarInminenteArriboATerminal(Buque unBuque) {
		unBuque.getTerminal().notificarConsigneesSobreInminenteLlegadaDeBuque(unBuque);
		unBuque.cambiarFase();
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
		// Implementado en la fase Departing
	}

}
