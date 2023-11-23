package filtrosDeCircuitos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class FiltroLlegaEn implements IFiltrable {
	LocalDate fechaFiltro;
	TerminalPortuaria terminalDestino;
	TerminalPortuaria terminalOrigen;
	
	public FiltroLlegaEn(LocalDate fechaDeSalida, TerminalPortuaria origen, TerminalPortuaria destino) {
		this.fechaFiltro = fechaDeSalida;
		this.terminalOrigen = origen;
		this.terminalDestino = destino;
	}
	
	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		return viajes.stream()
				.filter(viaje -> 
					viaje.getFechaDeSalida().plusDays(Math.round(viaje.getTiempoEntreTerminales(terminalOrigen, terminalDestino)))
					.equals(fechaFiltro))
				.toList();
				
	}

}
