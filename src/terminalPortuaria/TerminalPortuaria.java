package terminalPortuaria;

import punto.Punto;

public class TerminalPortuaria {
	
	protected Punto coordenadas;
	
	public TerminalPortuaria(Punto p) {
		super();
		this.coordenadas = p;
	}
	
	public Punto getCoordenadas(){
		return this.coordenadas;
	}
	
	public Double calcularDistancia(Punto p){
		return this.getCoordenadas().calcularDistancia(p);
	}




}
