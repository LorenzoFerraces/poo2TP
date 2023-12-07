package buque;

import java.util.List;

import buque.faseDeBuque.*;
import buque.gps.GPS;
import container.Container;
import punto.Punto;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;

public class Buque {

	private List<Container> carga;
	private GPS gps;
	private TerminalGestionada terminal;
	private FaseDeBuque faseDelBuque;
	private Punto posicionConocida;
	
	public Buque(List<Container> carga, GPS gps, TerminalGestionada terminal, FaseDeBuqueOutbound faseDeBuque) {
		this.carga = carga;
		this.gps = gps;
		this.terminal = terminal;
		this.faseDelBuque = faseDeBuque;
		this.posicionConocida = gps.getPosicion();
	}
	
	public List<Container> getCarga() {
		return carga;
	}
	
	public TerminalGestionada getTerminal() {
		return this.terminal;
	}
	
	public FaseDeBuque getFase() {
		return faseDelBuque;
	}
	
	public GPS getGPS() {
		return this.gps;
	}
	
	// Actualiza la posición con la recibida por el GPS e intenta cambiar de fase
	public void actualizarPosicion() {
		posicionConocida = gps.getPosicion();
		this.cambiarFase();
	}
	
	public Punto getPosicion() {
		return this.posicionConocida;
	}
	
	// Calcula la distancia en kilometros a la terminal
	public Double calcularDistanciaATerminal() {
		return posicionConocida.calcularDistancia(terminal.getCoordenadas());
	}

	// Delega a la fase actual la responsabilidad de cambiar a la siguiente 
	// o continuar en la misma
	public void cambiarFase() {
		faseDelBuque = faseDelBuque.siguienteFase(this);
	}

	public void avisarInminenteArriboATerminal() {
		this.faseDelBuque.avisarInminenteArriboATerminal(this);
	}
	
	public void avisarArriboATerminal() {
		this.faseDelBuque.avisarArriboATerminal(this);
	}
	
	public void realizarCargaYDescarga() {
		this.faseDelBuque.realizarCargaYDescarga(this);
	}
	
	public void depart() {
		this.faseDelBuque.depart(this);
	}
	
	public void avisarPartidaATerminal() {
		this.faseDelBuque.avisarPartidaATerminal(this);
	}

}
