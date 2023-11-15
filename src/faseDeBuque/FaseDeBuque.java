package faseDeBuque;

import TpFinal.TerminalPortuaria;
import buque.Buque;

public interface FaseDeBuque {

	public FaseDeBuque siguienteFase(Buque unBuque);
	
	public void avisarArriboATerminal(Buque unBuque);
	
	public void realizarCargaYDescarga(Buque unBuque);
	
	public void depart(Buque unBuque);
	
	public void avisarPartidaATerminal(Buque unBuque);

}
