package empresaTransportista;

import container.Container;

public class Camion {

	private Container carga;
	private Conductor conductor;

	public Camion(Container unaCarga, Conductor unConductor) {
		this.carga = unaCarga;
		this.conductor = unConductor;
	}
	
	public Container getCarga() {
		return this.carga;
	}
	
	public Conductor getConductor() {
		return this.conductor;
	}
	
}
