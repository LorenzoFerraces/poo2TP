package naviera.circuitoMaritimo.tramo;

import terminalPortuaria.TerminalPortuaria;

public class Tramo {
	private TerminalPortuaria origen;
	private TerminalPortuaria destino;
	public Double tiempoDeRecorrido;
	public Double precio;
	
	public Tramo(TerminalPortuaria t1, TerminalPortuaria t2, Double tiempo, Double precio) {
		super();
		this.origen = t1;
		this.destino = t2;
		this.tiempoDeRecorrido = tiempo;
		this.precio = precio;
	}
	
	public TerminalPortuaria getOrigen(){
		return this.origen;
	}
	
	public TerminalPortuaria getDestino(){
		return this.destino;
	}
	
	public Double getTiempoRecorrido() {
		return this.tiempoDeRecorrido;
	}
	
	public Double getPrecio() {
		return this.precio;
	}
	
	public Double distancia() {
		return this.origen.calcularDistancia(this.getDestino().getCoordenadas());
	}
	
	
}
