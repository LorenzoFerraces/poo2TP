package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import naviera.circuitoMaritimo.CircuitoMaritimo;

public abstract class CriterioCircuito {
	
	protected Comparator<CircuitoMaritimo> criterio;
	
	public CriterioCircuito(Comparator<CircuitoMaritimo> comp) {
		super();
		this.criterio = comp;
	}
	
	public abstract Optional<CircuitoMaritimo> buscar( List<CircuitoMaritimo> lista);
	
}
