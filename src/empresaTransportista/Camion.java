package empresaTransportista;


public class Camion {

	private Conductor conductor;

	public Camion(Conductor unConductor) {
		this.conductor = unConductor;
	}
	
	public Conductor getConductor() {
		return this.conductor;
	}
	
}
