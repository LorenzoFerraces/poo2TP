package viaje;

import java.time.LocalDateTime;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

public class Viaje {
	CircuitoMaritimo circuito;
	//TODO Agregar la entidad buque y su respectivos mensajes
//	Buque buque
	LocalDateTime fecha_de_salida;
	
	public Viaje(CircuitoMaritimo circuito, LocalDateTime fecha_de_salida) {
		this.circuito = circuito;
		this.fecha_de_salida = fecha_de_salida;
	}
	
	public CircuitoMaritimo getCircuitoMaritimo() {
		return this.circuito;
	}
	
	
	public LocalDateTime getFechaDeSalida() {
		return this.fecha_de_salida;
	}
	
	public double getTiempoEntreTerminales(TerminalPortuaria inicio, TerminalPortuaria fin) {
		return this.circuito.getTiempoEntreTramos(inicio, fin);
	}
}
