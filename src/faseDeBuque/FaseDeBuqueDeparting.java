package faseDeBuque;

import TpFinal.TerminalPortuaria;
import buque.Buque;

public class FaseDeBuqueDeparting implements FaseDeBuque{

	@Override
	public void accionar(Buque unBuque, TerminalPortuaria unaTerminal) {
		// TODO Auto-generated method stub
		
	}

	// Retorna la primera fase, ya que this es la última
	@Override
	public FaseDeBuque siguienteFase() {
		return new FaseDeBuqueOutbound();
	}

	
}
