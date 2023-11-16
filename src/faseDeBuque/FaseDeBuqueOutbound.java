package faseDeBuque;

import TpFinal.Punto;
import buque.Buque;

public class FaseDeBuqueOutbound implements FaseDeBuque{

	
	// Retorna la fase 2 de 5 si esta a menos de 50 km de la terminal
	@Override
	public FaseDeBuque siguienteFase(Buque unBuque) {
		if (unBuque.calcularDistanciaATerminal() < 50.0) {
			return new FaseDeBuqueInbound();
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
	public void depart(Buque unBuque) {
		// Implementado en la fase Working
	}
	
	@Override
	public void avisarPartidaATerminal(Buque unBuque) {
		// Implementado en la fase Departing
	}

	// Simula la navegación del buque hacia la terminal
	@Override
	public void navegar(Buque unBuque) {
		Punto posicionDeTerminal = unBuque.getTerminal().getCoordenadas();
		
		unBuque.getGPS().acercarseAPosicion(posicionDeTerminal);
	}
}
