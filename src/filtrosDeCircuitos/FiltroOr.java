package filtrosDeCircuitos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import viaje.Viaje;

public class FiltroOr implements IFiltrable {
	IFiltrable operador1;
	IFiltrable operador2;
	
	public FiltroOr(IFiltrable operador1, IFiltrable operador2) {
		this.operador1 = operador1;
		this.operador2 = operador2;
	}


	@Override
	public List<Viaje> filtrar(List<Viaje> viajes) {
		Set<Viaje> set = operador1.filtrar(viajes).stream().collect(Collectors.toSet());
		List<Viaje> lista = operador2.filtrar(viajes);

		set.addAll(lista);
		
		return set.stream().collect(Collectors.toList());
	}

}
