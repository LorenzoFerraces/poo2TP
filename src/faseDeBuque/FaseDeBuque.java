package faseDeBuque;

import java.util.Arrays;
import java.util.List;

import buque.Buque;

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
	
	// public abstract void accionar(TerminalPortuaria unaTerminal);
	
	public FaseDeBuque siguienteFasePara(Buque unBuque) {
		return fases().stream().
				filter(fase -> fase.esLaFaseCorrespondienteA(unBuque)).
				findFirst().
				get();
	}
}
