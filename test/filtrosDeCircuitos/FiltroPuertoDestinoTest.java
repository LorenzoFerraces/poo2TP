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
import viaje.Viaje;

class FiltroPuertoDestinoTest {
	IFiltrable filtro;
	CircuitoMaritimo circuito1;
	CircuitoMaritimo circuito2;
	CircuitoMaritimo circuito3;
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;
	TerminalPortuaria terminal3;
	

	@BeforeEach
	void setUp() throws Exception {
		this.circuito1 = mock(CircuitoMaritimo.class);
		this.circuito2 = mock(CircuitoMaritimo.class);
		this.circuito3 = mock(CircuitoMaritimo.class);
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		this.terminal1 = mock(TerminalPortuaria.class);
		this.terminal2 = mock(TerminalPortuaria.class);
		this.terminal3 = mock(TerminalPortuaria.class);
		
		//Se asigna la el Circuito:X al Viaje:X
		when(viaje1.getCircuitoMaritimo()).thenReturn(circuito1);
		when(viaje2.getCircuitoMaritimo()).thenReturn(circuito2);
		when(viaje3.getCircuitoMaritimo()).thenReturn(circuito3);
	}
	
	@Test
	void seDebeLlamarALaFuncionObtenerDestinoDeLosCircuitosDeLosViajes() {
		this.filtro = new FiltroPuertoDestino(terminal1, List.of(viaje1, viaje2));
		when(circuito1.getTerminalDestino()).thenReturn(terminal1);
		when(circuito2.getTerminalDestino()).thenReturn(terminal2);
		this.filtro.filtrar();
		
		verify(circuito1).getTerminalDestino();
		verify(circuito2).getTerminalDestino();
	}

	@Test
	void debeFiltrarElCircuitoConLaTerminalDeDestino() {
		this.filtro = new FiltroPuertoDestino(terminal1, List.of(viaje1, viaje2,viaje3));
		when(circuito1.getTerminalDestino()).thenReturn(terminal1);
		when(circuito2.getTerminalDestino()).thenReturn(terminal2);
		when(circuito3.getTerminalDestino()).thenReturn(terminal3);
		
		assertEquals(this.filtro.filtrar().size(), 1);
		assertTrue(this.filtro.filtrar().contains(circuito1));
	}
	
	@Test
	void debeFiltrarLosCircuitoConLaTerminalDeDestino() {
		this.filtro = new FiltroPuertoDestino(terminal2, List.of(viaje1, viaje2,viaje3));
		when(circuito1.getTerminalDestino()).thenReturn(terminal2);
		when(circuito2.getTerminalDestino()).thenReturn(terminal2);
		when(circuito3.getTerminalDestino()).thenReturn(terminal3);
		
		assertEquals(this.filtro.filtrar().size(), 2);
		assertTrue(this.filtro.filtrar().contains(circuito1));
		assertTrue(this.filtro.filtrar().contains(circuito2));
	}
	
	@Test
	void devuelveUnaListaVaciaEnCasoDeNoCoincidirNinguno() {
		this.filtro = new FiltroPuertoDestino(terminal1, List.of(viaje1, viaje2,viaje3));
		when(circuito1.getTerminalDestino()).thenReturn(terminal3);
		when(circuito2.getTerminalDestino()).thenReturn(terminal3);
		when(circuito3.getTerminalDestino()).thenReturn(terminal3);
		
		assertTrue(this.filtro.filtrar().isEmpty());
	}

}
