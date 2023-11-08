package faseDeBuque;

public class FaseDeBuqueArrived extends FaseDeBuque{

	@Override
	public boolean esLaFaseCorrespondienteA(Buque unBuque) {
		return unBuque.estaEnFaseArrived();
	}
}
