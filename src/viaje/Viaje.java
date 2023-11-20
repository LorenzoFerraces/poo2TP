package viaje;

import java.time.LocalDate;

import buque.Buque;
import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

public class Viaje {
	CircuitoMaritimo circuito;
	Buque buque;
	LocalDate fechaDeSalida;
	
	public Viaje(CircuitoMaritimo circuito, LocalDate fecha) {
		this.circuito = circuito;
		this.fechaDeSalida = fecha;
	}
	
	public CircuitoMaritimo getCircuitoMaritimo() {
		return this.circuito;
	}
	
	public LocalDate getFechaDeSalida() {
		return this.fechaDeSalida;
	}
	
	public double getTiempoEntreTerminales(TerminalPortuaria inicio, TerminalPortuaria fin) {
		return this.circuito.getTiempoEntreTerminales(inicio, fin);
	}
	
	public boolean contieneTerminal(TerminalPortuaria t) {
		return this.circuito.contieneTerminal(t);
	}
	
	public LocalDate getFechaLlegada() {
		return this.getFechaDeSalida().plusDays(
				(long) Math.ceil(this.getCircuitoMaritimo().tiempoTotal()));
	}
	
}
