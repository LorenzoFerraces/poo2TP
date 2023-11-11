package buque;

import java.util.List;

import TpFinal.TerminalPortuaria;
import containers.Container;
import faseDeBuque.*;

public class Buque {

	private List<Container> carga;
	// private GPS gps;
	private FaseDeBuque fase_del_buque;
	private TerminalPortuaria terminal;
	
	public Buque(List<Container> carga, /*GPS gps, */TerminalPortuaria terminal) {
		super();
		this.carga = carga;
		// this.gps = gps;
		this.fase_del_buque = new FaseDeBuqueOutbound();
		this.terminal = terminal;
	}

	public void cambiarFase() {
		this.fase_del_buque.siguienteFase();
	}
	
	
}
