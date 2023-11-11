package faseDeBuque;

import buque.Buque;

public interface FaseDeBuque {
	
	public void accionar(Buque unBuque);
	
	public FaseDeBuque siguienteFase();
}
