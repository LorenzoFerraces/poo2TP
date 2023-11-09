package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueWorking extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnCargaYDescarga();
	}
}
