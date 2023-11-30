package ordenes;

import java.time.LocalDate;

import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import naviera.viaje.Viaje;
import terminalPortuaria.TerminalPortuaria;

public abstract class Orden {
	
	private TerminalPortuaria terminalDeDestino;
	private Viaje viajeElegido;
	private Camion camionAsignado;
	private Conductor conductorAsignado;
	private Container carga;
	private LocalDate fechaDeSalidaDesdeOrigen;
	private LocalDate fechaDeLlegadaADestino;

	public Orden(TerminalPortuaria terminalDeDestino, Viaje viajeElegido,
			Container carga, LocalDate fechaDeSalidaDesdeOrigen,
			LocalDate fechaDeLlegadaADestino) {
		this.terminalDeDestino = terminalDeDestino;
		this.viajeElegido = viajeElegido;
		this.carga = carga;
		this.fechaDeSalidaDesdeOrigen = fechaDeSalidaDesdeOrigen;
		this.fechaDeLlegadaADestino = fechaDeLlegadaADestino;
	}

	public TerminalPortuaria getTerminalDeDestino() {
		return terminalDeDestino;
	}

	public Viaje getViajeElegido() {
		return viajeElegido;
	}

	public Camion getCamionAsignado() {
		return camionAsignado;
	}

	public Conductor getConductorAsignado() {
		return conductorAsignado;
	}

	public Container getCarga() {
		return carga;
	}
	
	public LocalDate getFechaDeSalidaDesdeOrigen() {
		return fechaDeSalidaDesdeOrigen;
	}

	public LocalDate getFechaDeLlegadaADestino() {
		return fechaDeLlegadaADestino;
	}
	
	protected void setCamion(Camion camion) {
		this.camionAsignado = camion;
	}
	
	protected void setConductor(Conductor conductor) {
		this.conductorAsignado = conductor;
	}
}
