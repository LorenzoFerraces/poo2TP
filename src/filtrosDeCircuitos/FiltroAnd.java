package filtrosDeCircuitos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import viaje.Viaje;

public class FiltroAnd implements IFiltrable {
	IFiltrable operador1;
	IFiltrable operador2;
	
	public FiltroAnd(IFiltrable operador1, IFiltrable operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
	}

	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		Set<Viaje> set1 = operador1.filtrar(viajes).stream().collect(Collectors.toSet());
		Set<Viaje> set2 = operador2.filtrar(viajes).stream().collect(Collectors.toSet());
		set1.retainAll(set2);
		
		return set1.stream().collect(Collectors.toList());
	}
	
	
}
