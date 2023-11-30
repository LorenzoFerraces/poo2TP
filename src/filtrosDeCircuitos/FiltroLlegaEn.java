package filtrosDeCircuitos;

import java.time.LocalDate;
import java.util.List;

import naviera.viaje.Viaje;
import terminalPortuaria.TerminalPortuaria;

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
//				delegar en viaje
					viaje.getFechaDeSalida().plusDays(Math.round(viaje.getTiempoEntreTerminales(terminalOrigen, terminalDestino)))
					.equals(fechaFiltro))
				.toList();
				
	}

}
