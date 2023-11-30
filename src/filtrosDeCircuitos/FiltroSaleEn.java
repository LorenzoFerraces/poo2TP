package filtrosDeCircuitos;

import java.time.LocalDate;
import java.util.List;

import naviera.viaje.Viaje;
import terminalPortuaria.TerminalPortuaria;

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
