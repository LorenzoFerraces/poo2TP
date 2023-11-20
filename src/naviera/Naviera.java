package naviera;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import buque.Buque;
import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class Naviera {
	
	private Set<Buque> buques;
	private Set<CircuitoMaritimo> circuitos;
	private Set<Viaje> viajes;
	
	public Naviera() {
		super();
		this.buques = new HashSet<Buque>();
		this.circuitos = new HashSet<CircuitoMaritimo>();
		this.viajes = new HashSet<Viaje>();
	}
	
	public boolean addBuque(Buque b) {
		return this.buques.add(b);
	}
	
	public boolean addCircuito(CircuitoMaritimo m) {
		return this.circuitos.add(m);
	}
	
	public boolean addViaje(CircuitoMaritimo m, LocalDate date ) {
		if (!this.circuitos.contains(m)){
			circuitos.add(m);
		}
		return this.viajes.add(new Viaje(m,date));
	}
	
	public Set<CircuitoMaritimo> circuitosQuePasanPor(TerminalPortuaria t1, TerminalPortuaria t2){
		return this.circuitos.stream().filter(circ -> circ.contieneOrigenYDestino(t1,t2)).collect(Collectors.toSet());
	}
	
	
	
	
	
}
