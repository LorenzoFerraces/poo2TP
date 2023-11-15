package gps;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;

public class GPS {

	private Punto posicion;
	private TerminalPortuaria terminal;
	
	public GPS(Punto posicion, TerminalPortuaria terminal) {
		this.posicion = posicion;
		this.terminal = terminal;
	}

	public Punto getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
	}

}
