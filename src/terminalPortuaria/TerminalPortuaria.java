package terminalPortuaria;

import punto.Punto;

public class TerminalPortuaria {
	
	private Punto coordenadas;
	
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
	
@Override
public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return this.getCoordenadas().equals((Punto)obj);
}




}
