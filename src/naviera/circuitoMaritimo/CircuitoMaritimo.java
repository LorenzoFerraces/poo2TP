package naviera.circuitoMaritimo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalPortuaria;

public class CircuitoMaritimo {

	private List<Tramo> tramos;

	public CircuitoMaritimo() {
		super();
		this.tramos = new ArrayList<Tramo>();
	}

	public CircuitoMaritimo(List<Tramo> list) throws Exception {
		super();
		this.tramos = new ArrayList<Tramo>();
		tramos.forEach(t -> {
			try {
				this.agregarTramo(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		}

	public boolean agregarTramo(Tramo t) throws Exception {
//		Prop: agrega un tramo al final del recorrido
//		Prec: el origen del tramo t coincide con el destino del ultimo tramo en tramos
		if (!tramos.isEmpty()) {
			verificarTramo(t);
		}
		return tramos.add(t);
	}

	private void verificarTramo(Tramo t) throws Exception {
//		Prop verifica que el origen del tramo a agregar corresponda con el destino del tramo previo
		Tramo ultimoTramo = tramos.get(tramos.size() - 1);
		if (!(t.getOrigen().equals(ultimoTramo.getDestino()))) {
			throw new Exception(
					"el origen de " + t.toString() + " no coincide con el destino de " + ultimoTramo.toString());
		}
	}
	
	public Integer cantidadTramos() {
		return this.tramos.size();
	}
	public boolean contieneTerminal(TerminalPortuaria t) {
//		Prop: indica si el circuito contiene la terminal como origen o destino en alguno de sus tramos
		return tramos.stream().map(tramo -> tramo.contieneTerminal(t)).anyMatch(bool -> bool);
	}

	public Double tiempoTotal() {
//		Prop: describe el tiempo total de recorrido de los tramos
		return this.mapToDoubleSum(Tramo::getTiempo);
	}

	public Double precioTotal() {
//		Prop: describe el total del costo de los tramos
		return this.mapToDoubleSum(Tramo::getPrecio);
	}

	public boolean contieneOrigenYDestino(TerminalPortuaria origen, TerminalPortuaria destino) {
		int indexOrigen = this.posicionComoOrigen(origen);
		int indexDestino = this.posicionComoDestino(destino);
		return ((indexOrigen <= indexDestino) && 
				(indexOrigen != (-1)) && (indexDestino != (-1))); 
		
	}
	
	private Double mapToDoubleSum(ToDoubleFunction<Tramo> f) {
//		Prop: toma una funcion de Tramo a Double, y mapea los tramos para despues devolver la suma de ese mapeo
		return tramos.stream().mapToDouble(f).sum();
	}

	private int posicionComoOrigen(TerminalPortuaria t) {
//		Prop: describe el index del tramo en tramos que tiene a la terminal t como origen
		return tramos.stream().map(Tramo::getOrigen).collect(Collectors.toList()).indexOf(t);
	}

	private int posicionComoDestino(TerminalPortuaria t) {
//		Prop: describe el index del tramo en tramos que tiene a la terminal t como destino
		return tramos.stream().map(Tramo::getDestino).collect(Collectors.toList()).indexOf(t);
	}

	public double getTiempoEntreTerminales(TerminalPortuaria inicio, TerminalPortuaria fin) {
		return this.tramos.subList(this.posicionComoOrigen(inicio), this.posicionComoDestino(fin) +1)
				.stream().mapToDouble(Tramo::getTiempo).sum()
		;
	}

}
