package ordenes;

import java.time.LocalDate;

import clientes.Consignee;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import naviera.viaje.Viaje;
import terminalPortuaria.TerminalPortuaria;

public class OrdenImportacion extends Orden {

	private Consignee consignee;
	
	public OrdenImportacion(TerminalPortuaria terminalDeDestino, Viaje viajeElegido, 
			Container carga, LocalDate fechaDeSalidaDesdeOrigen,
			LocalDate fechaDeLlegadaADestino, Consignee consignee) {
		super(terminalDeDestino, viajeElegido, carga, fechaDeSalidaDesdeOrigen,
				fechaDeLlegadaADestino);
		this.consignee = consignee;
	}

	public Consignee getConsignee() {
		return consignee;
	}
	
	public void cargarDatosRetiroDeCarga(Camion camion, Conductor conductor) {
		this.setCamion(camion);
		this.setConductor(conductor);
	}

	public boolean esConsignee(Consignee cons) {
		return this.consignee.equals(cons);
	}
	
}
