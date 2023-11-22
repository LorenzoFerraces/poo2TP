package filtrosDeCircuitos;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


import naviera.circuitoMaritimo.CircuitoMaritimo;

public class FiltroOr implements IFiltrable {
	IFiltrable operador1;
	IFiltrable operador2;
	
	public FiltroOr(IFiltrable operador1, IFiltrable operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
	}


	@Override
	public List<CircuitoMaritimo> filtrar() {
		Set<CircuitoMaritimo> setFiltrado = new HashSet<CircuitoMaritimo>(); //Se utiliza un SET para evitar circuitos duplicados
		List<CircuitoMaritimo> lista1 = operador1.filtrar();
		List<CircuitoMaritimo> lista2 = operador2.filtrar();

		setFiltrado.addAll(lista1);
		setFiltrado.addAll(lista2);
		
		return new ArrayList<CircuitoMaritimo>(setFiltrado);
	}

}
