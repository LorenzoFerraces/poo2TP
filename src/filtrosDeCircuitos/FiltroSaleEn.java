package filtrosDeCircuitos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import viaje.Viaje;

public class FiltroSaleEn implements IFiltrable {
	List<Viaje> viajes;
	LocalDateTime fechaFiltro;
	TerminalPortuaria terminal;
	
	public FiltroSaleEn(LocalDateTime fechaDeSalida, TerminalPortuaria terminal, List<Viaje> viajes ) {
		this.viajes = viajes;
		this.fechaFiltro = fechaDeSalida;
		this.terminal = terminal;
	}
	
	private boolean sonLaMismoFecha(LocalDateTime fecha1, LocalDateTime fecha2) {
		return 	fecha1.getYear() == fecha2.getYear() && fecha1.getMonthValue() == fecha2.getMonthValue() && fecha1.getDayOfMonth() == fecha2.getDayOfMonth();
	}

	@Override
	public List<CircuitoMaritimo> filtrar() {
		List<CircuitoMaritimo> circuitosAptos = new ArrayList<CircuitoMaritimo>();
		
		for (Viaje viaje : this.viajes) {
			double tiempoDeViaje = viaje.getTiempoDeViajeEntreTerminales(viaje.getCircuitoMaritimo().getTerminalInicio(), this.terminal);
		
			if (this.sonLaMismoFecha(viaje.getFechaDeSalida().plusDays(Math.round(tiempoDeViaje)),this.fechaFiltro)) {
				circuitosAptos.add(viaje.getCircuitoMaritimo());
			}
			
		}
		
		return circuitosAptos;
	}

}
