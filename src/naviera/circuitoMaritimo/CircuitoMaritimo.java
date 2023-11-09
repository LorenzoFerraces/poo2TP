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
	
	private CircuitoMaritimo subCircuito(TerminalPortuaria inicio, TerminalPortuaria fin) {
//		Prop: describe el CircuitoMaritimo con 'inicio' como terminal de origen, y 'fin' como terminal de fin
//			  En caso de no existir alguna de las terminales, retorna un circuito vacio			  
		try {
			return new CircuitoMaritimo(tramos.subList(0, 0));
		} catch (Exception e) {
			return new CircuitoMaritimo();
		}
	}
	
	public boolean contieneTerminal(TerminalPortuaria t) {
//		Prop: indica si el circuito contiene la terminal como origen o destino en alguno de sus tramos
		return tramos.parallelStream().map(tramo -> tramo.contieneTerminal(t)).anyMatch(bool -> bool);
	}
	
	public Double tiempoTotal() {
//		Prop: describe el tiempo total de recorrido de los tramos
		return this.mapReduceToDouble(Tramo::getTiempo);
	}
	
	public Double precioTotal() {
//		Prop: describe el total del costo de los tramos
		return this.mapReduceToDouble(Tramo::getPrecio);
	}
	
	private Double mapReduceToDouble(ToDoubleFunction<Tramo> f) {
		return tramos.stream().mapToDouble(f).sum();
	}
	
	private int posicionDe(TerminalPortuaria t){
		
		
		for(Tramo tramo : tramos) {
			
		}
		return 
	}
	
	
	

}
