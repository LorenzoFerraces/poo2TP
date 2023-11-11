package faseDeBuque;

import TpFinal.TerminalPortuaria;
import buque.Buque;

public interface FaseDeBuque {
	
	public void accionar(Buque unBuque, TerminalPortuaria unaTerminal);
	
	public FaseDeBuque siguienteFase();
}
