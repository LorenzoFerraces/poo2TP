package filtrosDeCircuitos;

import java.util.ArrayList;
import java.util.List;

import naviera.circuitoMaritimo.CircuitoMaritimo;

public class FiltroAnd implements IFiltrable {
	IFiltrable operador1;
	IFiltrable operador2;
	
	public FiltroAnd(IFiltrable operador1, IFiltrable operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
	}

	@Override
	public List<CircuitoMaritimo> filtrar() {
		List<CircuitoMaritimo> listaFiltrada = new ArrayList<CircuitoMaritimo>();
		List<CircuitoMaritimo> lista1 = operador1.filtrar();
		List<CircuitoMaritimo> lista2 = operador2.filtrar();
		
		
		for (CircuitoMaritimo circuito : lista1) {
			if (lista2.contains(circuito)) {
				listaFiltrada.add(circuito);
			}
			
		}
		return listaFiltrada;
	}
	
	
}
