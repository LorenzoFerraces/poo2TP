package naviera.circuitoMaritimo;

import java.util.ArrayList;
import java.util.List;
import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalPortuaria;

public class CircuitoMaritimo {
	
	private List<Tramo> tramos;
	
	public CircuitoMaritimo() {
		super();
		this.tramos = new ArrayList<Tramo>();
	}
	
	public CircuitoMaritimo(List<Tramo> list) throws Exception{
		super();
		this.tramos = new ArrayList<Tramo>();
		list.forEach((t -> {
			try {
				this.agregarTramo(t);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}));
	}
	
	public boolean agregarTramo(Tramo t) throws Exception{
		if (! tramos.isEmpty()) {
			verificarTramo(t);
		}
		return tramos.add(t);
	}

	private void verificarTramo(Tramo t) throws Exception{
		Tramo ultimoTramo = tramos.get(tramos.size() - 1);
		if(!(t.getOrigen() == ultimoTramo.getDestino())){
			throw new Exception(
					"el origen de " + t.toString() + " no coincide con el destino de " + ultimoTramo.toString());
		}
		
	}
	
	public Tramo sacarUltimoTramo() throws Exception {
		return tramos.remove(tramos.size() - 1);
	}
	
	private List<Tramo> subCircuito(TerminalPortuaria inicio, TerminalPortuaria fin) {
//		TODO: implementar buscador por terminal de origen y buscador por terminal de destino
	}

}
