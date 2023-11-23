package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.List;
import java.util.Optional;

import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;

public class CriterioCircuitoMenorNroDeTramos extends CriterioCircuito {
	
	public CriterioCircuitoMenorNroDeTramos() {
		super((c1,c2) -> c1.cantidadTramos().compareTo(c2.cantidadTramos()) );
		}

	@Override
	public Optional<CircuitoMaritimo> buscar(List<CircuitoMaritimo> lista) {
		return lista.stream().min(this.criterio);
	}

}
