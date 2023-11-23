package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.List;
import java.util.Optional;

import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;

public class CriterioCircuitoMenorPrecio extends CriterioCircuito {
	
	public CriterioCircuitoMenorPrecio() {
		super((c1,c2) -> c1.precioTotal().compareTo(c2.precioTotal()));	
		}

	@Override
// calcular tiempo mejor
	public Optional<CircuitoMaritimo> buscar(List<CircuitoMaritimo> lista) {
		return lista.stream().min(this.criterio);
	}

}
