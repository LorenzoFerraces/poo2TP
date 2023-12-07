package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

public abstract class CriterioCircuito {
	
	protected Comparator<CircuitoMaritimo> criterio;
	
	public CriterioCircuito() {
		super();
		
	}
	
	public abstract Optional<CircuitoMaritimo> buscar(List<CircuitoMaritimo> lista, TerminalPortuaria t1, TerminalPortuaria t2);
	
}
