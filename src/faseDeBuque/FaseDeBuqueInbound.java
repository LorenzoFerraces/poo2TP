package faseDeBuque;

import TpFinal.Punto;
import buque.Buque;

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
		// unBuque.getTerminal().notificarConsigneesSobreLlegadaDeBuque(unBuque);
		unBuque.cambiarFase();
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
