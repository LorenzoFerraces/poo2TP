package faseDeBuque;

public class FaseDeBuqueInbound extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnFaseInbound();
	}
}
