package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueInbound implements FaseDeBuque{

	@Override
	public void accionar(Buque unBuque) {
		// TODO Auto-generated method stub
		
	}

	// Retorna la fase 3 de 5
	@Override
	public FaseDeBuque siguienteFase() {
		return new FaseDeBuqueArrived();
	}

	
}
