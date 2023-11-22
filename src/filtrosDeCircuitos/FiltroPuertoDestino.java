package filtrosDeCircuitos;

import java.util.List;


import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class FiltroPuertoDestino implements IFiltrable {
	TerminalPortuaria puertoFiltro;
	List<CircuitoMaritimo> circuitos;
	
	public FiltroPuertoDestino(TerminalPortuaria puertoFiltro, List<Viaje> viajes ) {
		this.puertoFiltro = puertoFiltro;
		this.circuitos = viajes.stream().map(viaje -> viaje.getCircuitoMaritimo()).toList();
	}

	@Override
	public List<CircuitoMaritimo> filtrar() {		
		return this.circuitos.stream().filter(circuito -> circuito.getTerminalDestino().equals(this.puertoFiltro)).toList();
	}

}
