package factura;

import java.time.LocalDateTime;
import java.util.List;

import ordenes.Orden;
import services.IServicio;

public class Factura {

	private Orden orden;
	private LocalDateTime fechaDeFacturacion;
	
	public Factura(Orden unaOrden, LocalDateTime fechaDeFacturacion) {
		this.orden = unaOrden;
		this.fechaDeFacturacion = fechaDeFacturacion;
	}

	public String imprimirFactura() {
		List<IServicio> serviciosBrindados = this.orden.getCarga().getServicios();
		double montoTotalPorServicios = serviciosBrindados.stream().
				mapToDouble(servicio -> servicio.costo()).sum();
		double montoTotalPorViaje = this.orden.getViajeElegido().getCircuito().precioTotal();
		
		// Encabezado de factura
		StringBuilder factura = new StringBuilder(this.getClass().getSimpleName() + ": \n" +
			"Fecha de expedicion: " + fechaDeFacturacion.toString() + "\n" + 
			"Servicios brindados: " + "\n");
		
		// Desglose de servicios
		serviciosBrindados.forEach(servicio -> 
			factura.append(servicio.getClass().getSimpleName() + ": " + servicio.costo() + "\n"));
		factura.append("\n");
		
		factura.append("Subtotal Servicios: " + montoTotalPorServicios + "\n");
		factura.append("Subtotal Viaje: " + montoTotalPorViaje + "\n\n");
		
		factura.append("Total a pagar: " + (montoTotalPorServicios + montoTotalPorViaje));
		
		return factura.toString().trim();
	}

	public LocalDateTime getFechaDeFacturacion() {
		return fechaDeFacturacion;
	}
}
