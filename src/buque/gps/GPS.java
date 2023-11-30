package buque.gps;

import punto.Punto;

public class GPS {

	private Punto posicion;
	
	public GPS(Punto posicion) {
		this.posicion = posicion;
	}

	public Punto getPosicion() {
		return posicion;
	}
	
	public void setPosicion(Punto punto) {
		this.posicion = punto;
	}
}
