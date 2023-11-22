package filtrosDeCircuitos;

import java.util.List;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import viaje.Viaje;

public interface IFiltrable {
	public List<Viaje> filtrar(List<Viaje> lista);
}
