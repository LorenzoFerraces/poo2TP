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
	
	public OrdenExportacion(TerminalPortuaria terminalDeDestino, Viaje viajeElegido, Camion camionAsignado,
			Conductor conductorAsignado, Container carga, LocalDate fechaDeSalidaDesdeOrigen,
			LocalDate fechaDeLlegadaADestino, Shipper shipper) {
		super(terminalDeDestino, viajeElegido, camionAsignado, conductorAsignado, carga, fechaDeSalidaDesdeOrigen,
				fechaDeLlegadaADestino);
		this.shipper = shipper;
	}

	public Shipper getShipper() {
		return shipper;
	}
}
