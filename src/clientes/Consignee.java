package clientes;


import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import ordenes.OrdenImportacion;

public class Consignee extends Cliente {

	public Consignee() {
		super();
	}
	
	public void recibirAvisoPorImportacion(OrdenImportacion orden) {
		Conductor conductorElegido = new Conductor();
		orden.cargarDatosRetiroDeCarga(new Camion(conductorElegido), conductorElegido);
	}

}
