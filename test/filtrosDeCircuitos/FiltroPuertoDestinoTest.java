package filtrosDeCircuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.TerminalGestionada;
import viaje.Viaje;

class FiltroPuertoDestinoTest {
	IFiltrable filtro;
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	TerminalPortuaria terminal1;
	TerminalGestionada terminalGestionada;
	

	@BeforeEach
	void setUp() throws Exception {
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminalGestionada = mock(TerminalGestionada.class);
	}
	
	@Test
	void seDebeLlamarALaFuncionVieneDespuesDeLosViajes() {
		this.filtro = new FiltroPuertoDestino(terminal1,terminalGestionada );
		this.filtro.filtrar(List.of(viaje1, viaje2));
		
		verify(viaje1).vieneDespuesDe(terminalGestionada, terminal1);
		verify(viaje2).vieneDespuesDe(terminalGestionada,terminal1);
	}

	@Test
	void debeFiltrarElCircuitoConLaTerminalDeDestino() {
		this.filtro = new FiltroPuertoDestino(terminal1,terminalGestionada );
		
		when(viaje1.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		when(viaje2.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		when(viaje3.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(true);
		
		assertEquals(this.filtro.filtrar(List.of(viaje1, viaje2, viaje3)).size(), 1);
		assertTrue(this.filtro.filtrar(List.of(viaje1, viaje2, viaje3)).contains(viaje3));
	}
	
	@Test
	void debeFiltrarLosCircuitoConLaTerminalDeDestino() {
		this.filtro = new FiltroPuertoDestino(terminal1,terminalGestionada );
		
		when(viaje1.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		when(viaje2.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(true);
		when(viaje3.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(true);
		List<Viaje> viajes = List.of(viaje1, viaje2, viaje3);
		
		assertEquals(this.filtro.filtrar(viajes).size(), 2);
		assertTrue(this.filtro.filtrar(viajes).contains(viaje2));
		assertTrue(this.filtro.filtrar(viajes).contains(viaje3));
	}
	
	@Test
	void devuelveUnaListaVaciaEnCasoDeNoCoincidirNinguno() {
		this.filtro = new FiltroPuertoDestino(terminal1,terminalGestionada );
		
		when(viaje1.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		when(viaje2.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		when(viaje3.vieneDespuesDe(terminalGestionada, terminal1)).thenReturn(false);
		
		assertTrue(this.filtro.filtrar(List.of(viaje1, viaje2, viaje3)).isEmpty());
	}

}
