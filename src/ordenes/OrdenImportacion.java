package ordenes;

import java.time.LocalDate;

import clientes.Consignee;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class OrdenImportacion extends Orden {

	private Consignee consignee;
	
	public OrdenImportacion(TerminalPortuaria terminalDeDestino, Viaje viajeElegido, Camion camionAsignado,
			Conductor conductorAsignado, Container carga, LocalDate fechaDeSalidaDesdeOrigen,
			LocalDate fechaDeLlegadaADestino, Consignee consignee) {
		super(terminalDeDestino, viajeElegido, camionAsignado, conductorAsignado, carga, fechaDeSalidaDesdeOrigen,
				fechaDeLlegadaADestino);
		this.consignee = consignee;
	}

	public Consignee getConsignee() {
		return consignee;
	}
	
}
