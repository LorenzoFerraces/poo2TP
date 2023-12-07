package terminalPortuaria.TerminalGestionada.CriterioCircuito;

import java.util.List;
import java.util.Optional;

import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

public class CriterioCircuitoMenorNroDeTramos extends CriterioCircuito {
	
	public CriterioCircuitoMenorNroDeTramos() {
		super();
		}

	@Override
	public Optional<CircuitoMaritimo> buscar(List<CircuitoMaritimo> lista, TerminalPortuaria t1, TerminalPortuaria t2) {
		return lista.stream()
				.filter(circ -> circ.contieneTerminal(t2))
				.min((circ1,circ2) -> circ1.tramosEntre(t1, t2).compareTo(circ2.tramosEntre(t1, t2)));
	}

}
