package faseDeBuque;

public class FaseDeBuqueOutbound extends FaseDeBuque{
	
	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaLejosDeLaTerminal();
	}
}
