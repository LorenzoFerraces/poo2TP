package faseDeBuque;

public class FaseDeBuqueWorking extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnFaseDeparting();
	}
}
