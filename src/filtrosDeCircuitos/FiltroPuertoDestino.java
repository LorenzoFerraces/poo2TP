package filtrosDeCircuitos;

import java.util.List;

import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;
import viaje.Viaje;

public class FiltroPuertoDestino implements IFiltrable {
	TerminalPortuaria puertoDestino;
	TerminalGestionada origen;
	
	public FiltroPuertoDestino(TerminalPortuaria puertoFiltro, TerminalGestionada origen) {
		this.puertoDestino = puertoFiltro;
		this.origen = origen;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {		
		return viajes.stream()
				.filter(viaje -> viaje.vieneDespuesDe(this.origen, this.puertoDestino))
				.toList();				
	}

}
