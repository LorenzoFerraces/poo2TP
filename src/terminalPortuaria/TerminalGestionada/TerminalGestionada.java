package terminalPortuaria.TerminalGestionada;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import buque.Buque;
import clientes.Consignee;
import clientes.Shipper;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import empresaTransportista.EmpresaTransportista;
import factura.Factura;
import filtrosDeCircuitos.IFiltrable;
import naviera.Naviera;
import naviera.viaje.Viaje;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import ordenes.OrdenExportacion;
import ordenes.OrdenImportacion;
import punto.Punto;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuito;

public class TerminalGestionada extends TerminalPortuaria {
	
	private Set<Naviera> navieras;
	private Set<Shipper> shippers;
	private Set<Consignee> consignees;
	private Set<EmpresaTransportista> empresasTransporte;
	private Set<Conductor> conductores;
	private Set<Camion> camiones;
	private Set<OrdenImportacion> ordenesImportacion;
	private Set<OrdenExportacion> ordenesExportacion;
	private CriterioCircuito criterio;

	public TerminalGestionada(Punto p, CriterioCircuito criterio) {
		super(p);
		this.navieras = new HashSet<Naviera>();
		this.shippers = new HashSet<Shipper>();
		this.consignees = new HashSet<Consignee>();
		this.empresasTransporte = new HashSet<EmpresaTransportista>();
		this.conductores = new HashSet<Conductor>();
		this.camiones = new HashSet<Camion>();
		this.ordenesImportacion = new HashSet<OrdenImportacion>();
		this.ordenesExportacion = new HashSet<OrdenExportacion>();
		this.criterio = criterio;
	}
	
	public boolean add(Naviera nav) {
		return this.navieras.add(nav);
	}
	
	public boolean add(Shipper ship) {
		return this.shippers.add(ship);
	}
	
	public boolean add(Consignee cons) {
		return this.consignees.add(cons);
	}
	
	public boolean add(EmpresaTransportista empresa) {
		return this.empresasTransporte.add(empresa);
	}
	
	public boolean add(Conductor conductor) {
		return this.conductores.add(conductor);
	}
	
	public boolean add(Camion camion) {
		return this.camiones.add(camion);
	}
	
	private boolean add(OrdenImportacion orden) {
		return this.ordenesImportacion.add(orden);
	}
	
	private boolean add(OrdenExportacion orden) {
		return this.ordenesExportacion.add(orden);
	}
	
	public void setCriterio(CriterioCircuito crit) {
		this.criterio = crit;
	}
	
	public CircuitoMaritimo calcularMejorCircuito(TerminalPortuaria t) {
		return this.criterio.buscar(this.navieras.stream()
				.map(nav -> nav.circuitosConTerminal(t))
				.flatMap(List::stream)
				.toList())
				.get();
			
				
	}
	
	public List<Viaje> viajesConCircuito(CircuitoMaritimo circ) {
		return this.navieras.stream().map(nav -> nav.viajesConCircuito(circ))
						.flatMap(List::stream)
						.toList();
	}
	
	public boolean exportar(TerminalPortuaria t, Viaje viaje, Camion camion, 
					Conductor conductor, Container carga, Shipper ship) {
		this.add(ship);
		this.add(conductor);
		this.add(camion);
		LocalDate fecha = viaje.getFechaDeSalida();
		OrdenExportacion orden = new OrdenExportacion(t, viaje, camion, conductor, 
								  carga, fecha, fecha.plusDays((long) Math.ceil(viaje.getTiempoEntreTerminales(this, t))),
								  ship, fecha.minusDays(5l));
		return this.add(orden);
	}
	
	public boolean importar(TerminalPortuaria t, Viaje viaje, Container carga, Consignee consig) {
		this.add(consig);
		LocalDate fecha = viaje.getFechaDeSalida();
		OrdenImportacion orden = new OrdenImportacion(t, viaje, carga, fecha, 
			fecha.plusDays((long) Math.ceil(viaje.getTiempoEntreTerminales(this, t))), consig);
		return this.add(orden);
}
	
	
	
	public LocalDate proximaSalidaBuque(TerminalPortuaria t) {
		return this.navieras.stream()
				.map(nav -> nav.proximaSalidaBuque(t))
				.min((f1,f2) -> f1.compareTo(f2))
				.get();
				
	}
	
	public List<Viaje> filtrarViajes(IFiltrable filtro){
		return filtro.filtrar(this.navieras.stream()
				.map(Naviera::getViajes)
				.flatMap(List::stream)
				.toList()
				);
				
	}
	
	public Double cuantoTardaEnLlegar(Naviera nav, TerminalPortuaria t) {
		Double result = (!this.navieras.contains(nav) ? (-1d) : 
			nav.cuantoTardaEnLlegarA(this, t));
		
		return result;
	}
	
	public List<OrdenImportacion> getImportaciones(Consignee cons){
		return this.ordenesImportacion.stream().filter(orden -> orden.esConsignee(cons)).toList();
		}
	
	public List<OrdenExportacion> getExportaciones(Shipper ship){
		return this.ordenesExportacion.stream().filter(orden -> orden.esShipper(ship)).toList();
		
	}

	public void recibirNotificacionDeArriboDeBuque(Buque unBuque) {
		unBuque.realizarCargaYDescarga();
		
		unBuque.depart();
	}
	
	public void notificarConsigneesSobreInminenteLlegadaDeBuque(Buque unBuque) {
		ordenesDeImportacionAsociadasABuque(unBuque)
			.forEach(orden -> orden.getConsignee().recibirAvisoPorImportacion(orden));
	}

	public void notificarClientesSobrePartidaDeBuque(Buque unBuque) {
		notificarShippersSobrePartidaDeBuque(unBuque);
		notificarConsigneesSobrePartidaDeBuque(unBuque);
	}
	
	public void notificarConsigneesSobrePartidaDeBuque(Buque unBuque) {
		ordenesDeImportacionAsociadasABuque(unBuque).stream()
			.forEach(orden -> this.generarFacturaParaConsignee(orden));
	}

	public void generarFacturaParaConsignee(OrdenImportacion orden) {
		String factura = new Factura(orden, LocalDateTime.now()).facturaParaConsignee();
		orden.getConsignee().recibirFactura(factura);
	}

	public void notificarShippersSobrePartidaDeBuque(Buque unBuque) {
		ordenesDeExportacionAsociadasABuque(unBuque).stream()
			.forEach(orden -> this.generarFacturaParaShipper(orden));
	}

	public void generarFacturaParaShipper(OrdenExportacion orden) {
		String factura = new Factura(orden, LocalDateTime.now()).facturaParaShipper();
		orden.getShipper().recibirFactura(factura);
	}

	private List<OrdenImportacion> ordenesDeImportacionAsociadasABuque(Buque unBuque) {
		return this.ordenesImportacion.stream()
			.filter(orden -> orden.getViajeElegido().tieneBuque(unBuque))
			.toList();
	}

	private List<OrdenExportacion> ordenesDeExportacionAsociadasABuque(Buque unBuque) {
		return this.ordenesExportacion.stream()
			.filter(orden -> orden.getViajeElegido().tieneBuque(unBuque))
			.toList();
	}

}
