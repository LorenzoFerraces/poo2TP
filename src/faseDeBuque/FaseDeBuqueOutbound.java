package faseDeBuque;

import TpFinal.TerminalPortuaria;
import buque.Buque;

public class FaseDeBuqueOutbound implements FaseDeBuque{

	@Override
	public void accionar(Buque unBuque, TerminalPortuaria unaTerminal) {
		// TODO Auto-generated method stub
		
	}

	// Retorna la fase 2 de 5
	@Override
	public FaseDeBuque siguienteFase() {
		return new FaseDeBuqueInbound();
	}
}
