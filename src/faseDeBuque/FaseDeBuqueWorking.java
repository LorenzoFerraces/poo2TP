package faseDeBuque;

import TpFinal.TerminalPortuaria;
import buque.Buque;

public class FaseDeBuqueWorking implements FaseDeBuque{

	@Override
	public void accionar(Buque unBuque, TerminalPortuaria unaTerminal) {
		// TODO Auto-generated method stub
		
	}

	// Retorna la fase 5 de 5
	@Override
	public FaseDeBuque siguienteFase() {
		return new FaseDeBuqueDeparting();
	}

	
}
