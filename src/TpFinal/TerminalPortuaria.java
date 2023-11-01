package TpFinal;

public class TerminalPortuaria {
	
	private Punto coordenadas;
	
	public TerminalPortuaria(Punto p) {
		super();
		this.coordenadas = p;
	}
	
	public Punto getCoordenadas(){
		return this.coordenadas;
	}
	
	public Double calcularDistancia(TerminalPortuaria t){
		return this.getCoordenadas().calcularDistancia(t.getCoordenadas());
	}
	

}
