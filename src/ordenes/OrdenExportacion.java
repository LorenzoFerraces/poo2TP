package ordenes;

import java.time.LocalDate;

import clientes.Shipper;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class OrdenExportacion extends Orden {

	private Shipper shipper;
	private LocalDate turnoAsignado;
	
	
	public OrdenExportacion(TerminalPortuaria terminalDeDestino, Viaje viajeElegido, Camion camionAsignado,
			Conductor conductorAsignado, Container carga, LocalDate fechaDeSalidaDesdeOrigen,
			LocalDate fechaDeLlegadaADestino, Shipper shipper, LocalDate turno) {
		super(terminalDeDestino, viajeElegido, carga, fechaDeSalidaDesdeOrigen,
				fechaDeLlegadaADestino);
		this.setCamion(camionAsignado);
		this.setConductor(conductorAsignado);
		this.shipper = shipper;
		this.turnoAsignado = turno;
	}

	public Shipper getShipper() {
		return this.shipper;
	}
	
	public LocalDate getTurno() {
		return this.turnoAsignado;
	}
}
