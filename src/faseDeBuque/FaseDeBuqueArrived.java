package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueArrived implements FaseDeBuque{

	@Override
	public void accionar(Buque unBuque) {
		// TODO Auto-generated method stub
		
	}

	// Retorna la fase 4 de 5
	@Override
	public FaseDeBuque siguienteFase() {
		return new FaseDeBuqueWorking();
	}

	
}
