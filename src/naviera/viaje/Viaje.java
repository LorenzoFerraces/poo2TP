package naviera.viaje;

import java.time.LocalDate;

import buque.Buque;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

public class Viaje {
	CircuitoMaritimo circuito;
	Buque buque;
	LocalDate fechaDeSalida;
	
	public Viaje(CircuitoMaritimo circuito, Buque b, LocalDate fecha) {
		super();
		this.circuito = circuito;
		this.buque = b;
		this.fechaDeSalida = fecha;
	}
	
	public CircuitoMaritimo getCircuito() {
		return this.circuito;
	}
	
	public LocalDate getFechaDeSalida() {
		return this.fechaDeSalida;
	}
	
	public Double getTiempoEntreTerminales(TerminalPortuaria inicio, TerminalPortuaria fin) {
		return this.circuito.getTiempoEntreTerminales(inicio, fin);
	}
	
	public boolean contieneTerminal(TerminalPortuaria t) {
		return this.circuito.contieneTerminal(t);
	}
	
	public LocalDate getFechaLlegada() {
		return this.getFechaDeSalida().plusDays(
				(long) Math.ceil(this.getCircuito().tiempoTotal()));
	}
	
	public boolean vieneDespuesDe(TerminalPortuaria t1, TerminalPortuaria t2) {
		return this.circuito.vieneDespuesDe(t1, t2);
	}

	public boolean tieneCircuito(CircuitoMaritimo circ) {
		return this.getCircuito().equals(circ);
	}
	
}
