package filtrosDeCircuitos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;
import viaje.Viaje;

public class FiltroSaleEn implements IFiltrable{
	LocalDate fechaFiltro;
	TerminalPortuaria terminal;
	
	public FiltroSaleEn(LocalDate fechaDeSalida, TerminalPortuaria terminal) {
		super();
		this.fechaFiltro = fechaDeSalida;
		this.terminal = terminal;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> lista) {
		return lista.stream()
				.filter(viaje -> viaje.getFechaDeSalida().equals(this.fechaFiltro))
				.toList();
	}
	
}
