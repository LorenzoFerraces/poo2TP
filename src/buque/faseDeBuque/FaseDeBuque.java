package buque.faseDeBuque;

import buque.Buque;

public interface FaseDeBuque {

	public FaseDeBuque siguienteFase(Buque unBuque);
	
	public void avisarInminenteArriboATerminal(Buque unBuque);
	
	public void realizarCargaYDescarga(Buque unBuque);
	
	public void depart(Buque unBuque);
	
	public void avisarPartidaATerminal(Buque unBuque);
	
}
