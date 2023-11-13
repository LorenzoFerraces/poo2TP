package faseDeBuque;

import TpFinal.TerminalPortuaria;

public interface FaseDeBuque {

	public FaseDeBuque siguienteFase();
	
	public void avisarArriboATerminal(Buque unBuque);
	
	public void realizarCargaYDescarga(Buque unBuque);
	
	public void depart(Buque unBuque);
	
	public void avisarPartidaATerminal(Buque unBuque);

}
