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

	public LocalDateTime getFechaDeFacturacion() {
		return fechaDeFacturacion;
	}

	public String facturaParaShipper() {
		StringBuilder factura = this.parteInicial();
		
		factura.append("Total a pagar: " + (montoTotalPorServicios()));
		return factura.toString().trim();
	}
	
	public String facturaParaConsignee() {
		StringBuilder factura = this.parteInicial();
		
		factura.append("Subtotal Viaje: " + montoTotalPorViaje() + "\n");
		
		factura.append("Total a pagar: " + (montoTotalPorServicios() + montoTotalPorViaje()));
		return factura.toString().trim();
	}
	
	// Auxiliares de factura
	
	public double montoTotalPorServicios() {
		return orden.getCarga().getServicios().stream()
			.mapToDouble(servicio -> servicio.costo())
			.sum();
	}
	
	public double montoTotalPorViaje() {
		return orden.getViajeElegido().getCircuito().precioTotal();
	}
	
	private List<IServicio> serviciosAFacturar() {
		return orden.getCarga().getServicios();
	}
	
	private StringBuilder encabezadoDeFactura() {
		StringBuilder encabezado = new StringBuilder(this.getClass().getSimpleName() + ": \n" +
				"Fecha de expedicion: " + fechaDeFacturacion.toString() + "\n" + 
				"Servicios brindados: " + "\n");
		return encabezado;
	}
	
	private StringBuilder parteInicial() {
		StringBuilder factura = new StringBuilder(this.encabezadoDeFactura());
		
		desgloseDeServicios(factura);

		return factura;
	}

	private void desgloseDeServicios(StringBuilder factura) {
		serviciosAFacturar().forEach(servicio -> 
			factura.append(servicio.getClass().getSimpleName() + ": " + servicio.costo() + "\n"));
		factura.append("\n");
		factura.append("Subtotal Servicios: " + montoTotalPorServicios() + "\n");
	}

}
