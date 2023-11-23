package filtrosDeCircuitos;

import java.util.List;

import naviera.viaje.Viaje;
import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;

public interface IFiltrable {
	public List<Viaje> filtrar(List<Viaje> lista);
}
