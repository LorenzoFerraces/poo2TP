package empresaTransportista;

import java.util.ArrayList;
import java.util.List;

import TpFinal.TerminalPortuaria;

public class EmpresaTransportista {

	private List<Camion> camiones;
	private List<Conductor> conductores;
	
	public EmpresaTransportista() {
		this.camiones = new ArrayList<Camion>();
		this.conductores = new ArrayList<Conductor>();
	}
	
	public void agregarConductor(Conductor unConductor) {
		this.conductores.add(unConductor);
	}
	
	public void enviarCamionATerminal(Camion unCamion, TerminalPortuaria unaTerminal) {
		unCamion.irATerminal(unaTerminal);
		this.camiones.remove(unCamion);
	}
}
