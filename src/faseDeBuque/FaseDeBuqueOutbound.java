package faseDeBuque;

import buque.Buque;

public class FaseDeBuqueOutbound extends FaseDeBuque{
	
	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaLejosDeLaTerminal();
	}
}
