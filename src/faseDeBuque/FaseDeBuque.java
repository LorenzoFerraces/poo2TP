package faseDeBuque;

import java.util.Arrays;
import java.util.List;

public abstract class FaseDeBuque {
	
	public List<FaseDeBuque> fases() {
		return Arrays.asList(
				new FaseDeBuqueOutbound(), 
				new FaseDeBuqueInbound(), 
				new FaseDeBuqueArrived(), 
				new FaseDeBuqueWorking(), 
				new FaseDeBuqueDeparting());
	}
	
	public abstract boolean esLaFaseCorrespondienteA(Buque unBuque);
	
	public FaseDeBuque faseParaBuque(Buque unBuque) {
		return fases().stream().
				filter(fase -> fase.esLaFaseCorrespondienteA(unBuque)).
				findFirst().
				get();
	}
}
