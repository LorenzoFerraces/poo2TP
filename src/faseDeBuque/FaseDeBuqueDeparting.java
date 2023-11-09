package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueDeparting extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaSaliendoDeLaTerminal();
	}
}
