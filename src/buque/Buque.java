package buque;

import java.util.List;

import TpFinal.Punto;
import TpFinal.TerminalPortuaria;
import containers.Container;
import faseDeBuque.*;
import gps.GPS;

public class Buque {

	private List<Container> carga;
	private GPS gps;
	private FaseDeBuque fase_del_buque;
	private TerminalPortuaria terminal;
	
	public Buque(List<Container> carga, GPS gps, TerminalPortuaria terminal) {
		this.carga = carga;
		this.gps = gps;
		this.terminal = terminal;
		this.fase_del_buque = new FaseDeBuqueOutbound();
	}
	
	public List<Container> getCarga() {
		return carga;
	}
	public TerminalPortuaria getTerminal() {
		return this.terminal;
	}
	
	public Punto posicion() {
		return gps.getPosicion();
	}
	
	public Double calcularDistanciaATerminal() {
		return posicion().calcularDistancia(terminal.getCoordenadas());
	}

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
		
	}

	public FaseDeBuque getFase() {
		return fase_del_buque;
	}
}
