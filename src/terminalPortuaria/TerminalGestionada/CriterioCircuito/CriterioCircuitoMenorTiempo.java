package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.List;
import java.util.Optional;

import naviera.circuitoMaritimo.CircuitoMaritimo;

public class CriterioCircuitoMenorTiempo extends CriterioCircuito {

	public CriterioCircuitoMenorTiempo() {
		super((c1,c2) -> c1.tiempoTotal().compareTo(c2.tiempoTotal()));	
		}

	@Override
	public Optional<CircuitoMaritimo> buscar(List<CircuitoMaritimo> lista) {
		return lista.stream().min(this.criterio);
	}

}
