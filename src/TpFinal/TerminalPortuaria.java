package TpFinal;

public class TerminalPortuaria {
	
	private Par<Double, Double> coordenadas;
	
	public Par<Double, Double> getCoordenadas(){
		return this.coordenadas;
	}
	
	public Double calcularDistancia(Par<Double, Double> p){
		this.getCoordenadas().calcularDistancia(p);
	}
	

}
