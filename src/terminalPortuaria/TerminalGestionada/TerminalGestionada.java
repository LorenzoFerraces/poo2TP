package terminalPortuaria.TerminalGestionada;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import empresaTransportista.Camion;
import empresaTransportista.Conductor;
import empresaTransportista.EmpresaTransportista;
import naviera.Naviera;
import naviera.circuitoMaritimo.CircuitoMaritimo;
import punto.Punto;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuito;

public class TerminalGestionada extends TerminalPortuaria {
	
	private List<Naviera> navieras;
	private List<Shipper> shippers;
	private List<Consignee> consignees;
	private List<EmpresaTransportista> empresasTransporte;
	private List<Conductor> conductores;
	private List<Camion> camiones;
	private List<OrdenImportacion> ordenesImportacion;
	private List<OrdenExportacion> ordenesExportacion;
	private CriterioCircuito criterio;

	public TerminalGestionada(Punto p, CriterioCircuito criterio) {
		super(p);
		this.navieras = new ArrayList<Naviera>();
		this.shippers = new ArrayList<Shipper>();
		this.consignees = new ArrayList<Consignee>();
		this.empresasTransporte = new ArrayList<EmpresaTransportista>();
		this.conductores = new ArrayList<Conductor>();
		this.camiones = new ArrayList<Camion>();
		this.ordenesImportacion = new ArrayList<OrdenImportacion>();
		this.ordenesExportacion = new ArrayList<OrdenExportacion>();
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
			.filter(circ -> circ.contieneTerminal(t)).collect(Collectors.toList()))
			.get();
				
	}
	
	

}
