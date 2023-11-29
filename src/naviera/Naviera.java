package naviera;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import buque.Buque;
import naviera.viaje.Viaje;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;

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
	
	public boolean addViaje(CircuitoMaritimo m, Buque b, LocalDate date ) throws Exception{
		if (!this.circuitos.contains(m) || !this.buques.contains(b)) {
			throw new Exception(
					"Solo pueden crearse viajes con componentes que contenga la naviera");
			
		}
		return this.viajes.add(new Viaje(m, b, date));
	}
	
	public List<CircuitoMaritimo> getCircuitos(){
		return this.circuitos.stream().toList();
	}
	
	public List<Buque> getBuques(){
		return this.buques.stream().toList();
	}
	
	public List<Viaje> getViajes(){
		return this.viajes.stream().toList();
	}
	
	public List<Viaje> viajesQuePasanPor(TerminalPortuaria t1, TerminalPortuaria t2){
		return this.viajes.stream()
				.filter(viaje -> viaje
						.getCircuito()
						.contieneOrigenYDestino(t1,t2)).toList();
	}

	public List<Viaje> viajesConCircuito(CircuitoMaritimo circ) {

		return this.viajes.stream()
				.filter(viaje -> viaje.tieneCircuito(circ))
				.toList();
	}

	public List<CircuitoMaritimo> circuitosConTerminal(TerminalPortuaria t) {
		return this.getCircuitos().stream()
				.filter(circ -> circ.contieneTerminal(t))
				.toList();
	}
	
//	public long cuantoTardaEnLlegar (delega a viaje)
	
	
	
	
	
	
}
