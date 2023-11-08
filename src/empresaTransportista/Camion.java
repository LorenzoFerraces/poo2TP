package empresaTransportista;

import TpFinal.TerminalPortuaria;
import containers.Container;

public class Camion {

	private Container carga;
	private Conductor conductor;

	public Camion(Container unaCarga, Conductor unConductor) {
		this.carga = unaCarga;
		this.conductor = unConductor;
	}
	
	public void irATerminal(TerminalPortuaria unaTerminal) {
		// unaTerminal.validarIngresoDeCamion(this);
	}
	
	public Container getCarga() {
		return this.carga;
	}
	
	public Conductor getConductor() {
		return this.conductor;
	}
	
}
