package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueInbound extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaPorArribarALaTerminal();
	}
}
