package faseDeBuque;

public class FaseDeBuqueDeparting extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnFaseDeparting();
	}
}
