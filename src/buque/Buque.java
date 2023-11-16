package buque;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;
import containers.Container;
import faseDeBuque.*;
import gps.GPS;

@SuppressWarnings("deprecation")
public class Buque implements Observer {

	private List<Container> carga;
	private GPS gps;
	private FaseDeBuque fase_del_buque;
	private TerminalPortuaria terminal;
	
	public Buque(List<Container> carga, GPS gps, TerminalPortuaria terminal) {
		this.carga = carga;
		this.gps = gps;
		this.terminal = terminal;
		this.fase_del_buque = new FaseDeBuqueOutbound();
		this.gps.addObserver(this);
	}
	
	public List<Container> getCarga() {
		return carga;
	}
	public TerminalPortuaria getTerminal() {
		return this.terminal;
	}
	
	public FaseDeBuque getFase() {
		return fase_del_buque;
	}
	
	public GPS getGPS() {
		return this.gps;
	}
	public Punto posicion() {
		return gps.getPosicion();
	}
	
	// Calcula la distancia en kilometros a la terminal
	public Double calcularDistanciaATerminal() {
		return posicion().calcularDistancia(terminal.getCoordenadas());
	}

	// Setea la fase actual con la siguiente o la misma, si no se cumple la condicion
	public void cambiarFase() {
		fase_del_buque = fase_del_buque.siguienteFase(this);
	}
	
	public void avisarArriboATerminal() {
		this.fase_del_buque.avisarArriboATerminal(this);
	}
	
	public void realizarCargaYDescarga() {
		this.fase_del_buque.realizarCargaYDescarga(this);
	}
	
	public void depart() {
		this.fase_del_buque.depart(this);
	}
	
	public void avisarPartidaATerminal() {
		this.fase_del_buque.avisarPartidaATerminal(this);
	}
	
	public void navegar() {
		this.fase_del_buque.navegar(this);
	}

	// Mensaje enviado por el GPS alertando sobre un cambio de posicion
	// El buque intenta cambiar de fase
	@Override
	public void update(Observable o, Object arg) {
		this.cambiarFase();
	}
}
