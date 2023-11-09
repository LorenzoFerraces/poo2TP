package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueArrived extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnLaTerminal();
	}
}
