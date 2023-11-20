package filtrosDeCircuitos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class FiltroLlegaEn implements IFiltrable {
	List<Viaje> viajes;
	LocalDateTime fechaFiltro;
	TerminalPortuaria terminal_origen;
	TerminalPortuaria terminal_destino;
	
	public FiltroLlegaEn(LocalDateTime fechaDeSalida, TerminalPortuaria terminal_origen, TerminalPortuaria terminal_destino, List<Viaje> viajes ) {
		this.viajes = viajes;
		this.fechaFiltro = fechaDeSalida;
		this.terminal_origen = terminal_origen;
		this.terminal_destino = terminal_destino;
	}
	
	private boolean sonLaMismoFecha(LocalDateTime fecha1, LocalDateTime fecha2) {
		return 	fecha1.getYear() == fecha2.getYear() && fecha1.getMonthValue() == fecha2.getMonthValue() && fecha1.getDayOfMonth() == fecha2.getDayOfMonth();
	}
	

	@Override
	public List<CircuitoMaritimo> filtrar() {
		List<CircuitoMaritimo> circuitosAptos = new ArrayList<CircuitoMaritimo>();
		
		for (Viaje viaje : this.viajes) {
			double tiempoDeViaje = viaje.getTiempoDeViajeEntreTerminales(this.terminal_origen, this.terminal_destino);
			
			if (this.sonLaMismoFecha(viaje.getFechaDeSalida().plusDays(Math.round(tiempoDeViaje)),this.fechaFiltro)) {
				circuitosAptos.add(viaje.getCircuitoMaritimo());
			}
			
			
		}
		return circuitosAptos;
	}

}
