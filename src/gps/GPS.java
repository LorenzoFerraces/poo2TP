package gps;

import java.util.Observable;

import TpFinal.Punto;

@SuppressWarnings("deprecation")
public class GPS extends Observable {

	private Punto posicion;
	
	public GPS(Punto posicion) {
		this.posicion = posicion;
	}

	public Punto getPosicion() {
		return posicion;
	}
	
	// Modifica la posicion y notifica a los observadores
	public void setPosicion(Punto posicion) {
		this.posicion = posicion;
		this.setChanged();
		this.notifyObservers();
	}

	// Modifica en 1 la coordenada x e y para simular el acercamiento a la terminal
	public void acercarseAPosicion(Punto posicionAAcercarse) {
		Double coordenadaX = posicion.getFirst();
		Double coordenadaY = posicion.getSecond();
		if (coordenadaX < posicionAAcercarse.getFirst()) {
            coordenadaX = coordenadaX + 1;
        } else if (coordenadaX > posicionAAcercarse.getFirst()) {
        	coordenadaX = coordenadaX - 1;
        }

        if (coordenadaY < posicionAAcercarse.getSecond()) {
        	coordenadaY = coordenadaY + 1;
        } else if (coordenadaY > posicionAAcercarse.getSecond()) {
        	coordenadaY = coordenadaY - 1;
        }
		this.setPosicion(new Punto(coordenadaX, coordenadaY));
	}

	// Modifica en 1 la coordenada x e y para simular el alejamiento de la terminal
	public void alejarseDePosicion(Punto posicionAAlejarse) {
		Double coordenadaX = posicion.getFirst();
	    Double coordenadaY = posicion.getSecond();
	    if (coordenadaX <= posicionAAlejarse.getFirst()) {
	        coordenadaX = coordenadaX - 1;
	    } else {
	        coordenadaX = coordenadaX + 1;
	    }

	    if (coordenadaY <= posicionAAlejarse.getSecond()) {
	        coordenadaY = coordenadaY - 1;
	    } else {
	        coordenadaY = coordenadaY + 1;
	    }
	    this.setPosicion(new Punto(coordenadaX, coordenadaY));
	}
}
