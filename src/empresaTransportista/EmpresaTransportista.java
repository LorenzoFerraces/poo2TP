package empresaTransportista;

import java.util.ArrayList;
import java.util.List;


public class EmpresaTransportista {

	private List<Camion> camiones;
	private List<Conductor> conductores;
	
	public EmpresaTransportista() {
		this.camiones = new ArrayList<Camion>();
		this.conductores = new ArrayList<Conductor>();
	}
	
	public List<Conductor> getConductores() {
		return this.conductores;
	}

	public List<Camion> getCamiones() {
		return this.camiones;
	}
	
	public void agregarConductor(Conductor unConductor) {
		this.conductores.add(unConductor);
	}
	
	public void agregarCamion(Camion unCamion) {
		this.camiones.add(unCamion);
	}
	
}
