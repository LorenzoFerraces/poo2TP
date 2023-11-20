package naviera.circuitoMaritimo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalPortuaria;

public class CircuitoMaritimo {
	
	private List<Tramo> tramos;
	
	public CircuitoMaritimo() {
		super();
		this.tramos = new ArrayList<Tramo>();
	}
	
	public CircuitoMaritimo(List<Tramo> list) throws Exception{
		super();
		this.tramos = new ArrayList<Tramo>();
		list.forEach((t -> {
			try {
				this.agregarTramo(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}));
	}
	
	public boolean agregarTramo(Tramo t) throws Exception{
//		agrega un tramo al final del recorrido
		if (! tramos.isEmpty()) {
			verificarTramo(t);
		}
		return tramos.add(t);
	}

	private void verificarTramo(Tramo t) throws Exception{
//		verifica que el origen del tramo a agregar corresponda con el destino del tramo previo
		Tramo ultimoTramo = tramos.get(tramos.size() - 1);
		if(!(t.getOrigen() == ultimoTramo.getDestino())){
			throw new Exception(
					"el origen de " + t.toString() + " no coincide con el destino de " + ultimoTramo.toString());
		}
		
	}
	
	public Tramo sacarUltimoTramo() throws Exception {
		return tramos.remove(tramos.size() - 1);
	}
	
	public TerminalPortuaria getTerminalDestino() {
		return tramos.get(tramos.size() - 1).getDestino();
	}
	
	public TerminalPortuaria getTerminalInicio() {
		return tramos.get(0).getOrigen();
	}
	
	private List<Tramo> subCircuito(TerminalPortuaria inicio, TerminalPortuaria fin) {
//		TODO: implementar buscador por terminal de origen y buscador por terminal de destino
		return new ArrayList<Tramo>();
	}
	
	public double getTiempoDeViajeEntreTerminales(TerminalPortuaria inicio, TerminalPortuaria fin) {
		return this.subCircuito(inicio, fin).stream().mapToDouble(tramo -> tramo.getTiempo()).sum();
	}
	
	public boolean contieneTerminal(TerminalPortuaria t) {
//		devuelve si un circuito contiene una terminal t, en cualquier parte del recorrido
		return tramos.parallelStream().map(tramo -> tramo.contieneTerminal(t)).anyMatch(bool -> bool);
	}
	
	public Double tiempoTotal() {
		return this.mapReduceToDouble(Tramo::getTiempo);
	}
	
	public Double precioTotal() {
		return this.mapReduceToDouble(Tramo::getPrecio);
	}
	
	private Double mapReduceToDouble(ToDoubleFunction<Tramo> f) {
		return tramos.stream().mapToDouble(f).sum();
	}
	
	
	

}
