package terminalPortuaria.TerminalGestionada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import clientes.Consignee;
import clientes.Shipper;
import container.Container;
import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import empresaTransportista.EmpresaTransportista;
import filtrosDeCircuitos.IFiltrable;
import naviera.Naviera;
import naviera.circuitoMaritimo.CircuitoMaritimo;
import ordenes.OrdenExportacion;
import ordenes.OrdenImportacion;
import punto.Punto;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuito;
import viaje.Viaje;

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
	
	public boolean add(OrdenImportacion orden) {
		return this.ordenesImportacion.add(orden);
	}
	
	public boolean add(OrdenExportacion orden) {
		return this.ordenesExportacion.add(orden);
	}
	
	public void setCriterio(CriterioCircuito crit) {
		this.criterio = crit;
	}
	
	public CircuitoMaritimo calcularMejorCircuito(TerminalPortuaria t) {
		return this.criterio.buscar(this.navieras.stream().map(Naviera::getCircuitos)
			.flatMap(List::stream)
			.filter(circ -> circ.contieneTerminal(t))
			.collect(Collectors.toList()))
			.get();
				
	}
	
	public List<Viaje> viajesConCircuito(CircuitoMaritimo circ) {
		return this.navieras.stream().map(nav -> nav.getViajes().stream()
					.filter(viaje -> viaje.getCircuito().equals(circ)))
				.flatMap(Function.identity())
				.collect(Collectors.toList());
	}
	
	public void exportar(TerminalPortuaria t, Viaje viaje, Camion camion, 
					Conductor conductor, Container carga, Shipper ship) {
		this.add(ship);
		this.add(conductor);
		this.add(camion);
		LocalDate fecha = viaje.getFechaDeSalida();
		OrdenExportacion orden = new OrdenExportacion(t, viaje, camion, conductor, 
								  carga, fecha, fecha.plusDays((long) viaje.getTiempoEntreTerminales(this, t)),
								  ship, fecha.minusDays(5l));
		this.add(orden);
	}
	
	public void importar(TerminalPortuaria t, Viaje viaje, Container carga, Consignee consig) {
		this.add(consig);
		LocalDate fecha = viaje.getFechaDeSalida();
		OrdenImportacion orden = new OrdenImportacion(t, viaje, carga, fecha, 
			fecha.plusDays((long) viaje.getTiempoEntreTerminales(this, t)), consig);
		this.add(orden);
}
	
	public LocalDate proximaSalidaBuque(TerminalPortuaria t) {
		return this.navieras.stream().map(nav -> nav.getViajes().stream()
					.filter(viaje -> viaje.contieneTerminal(t)))
				.flatMap(Function.identity())
				.map(Viaje::getFechaDeSalida)
				.min((f1, f2) -> f1.compareTo(f2))
				.get();
	}
	
	public List<Viaje> filtrarViajes(IFiltrable filtro){
		return filtro.filtrar(this.navieras.stream()
				.map(Naviera::getViajes)
				.flatMap(List::stream)
				.toList()
				);
				
	}
	
	public int cuantoTardaEnLlegar(Naviera nav, TerminalPortuaria t) {
		int result = (int) (!this.navieras.contains(nav) ? (-1) : 
			this.navieras.stream().map(Naviera::getViajes)
				.flatMap(List::stream)
				.map(viaje -> viaje.getTiempoEntreTerminales(this, t))
				.min((v1,v2) -> v1.compareTo(v2))
				.get());
		
		return result;
	}
	

}
