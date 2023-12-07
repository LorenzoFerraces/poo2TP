package test.TerminalPortuaria.TerminalGestionada.CriterioCircuito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.viaje.circuitoMaritimo.CircuitoMaritimo;
import terminalPortuaria.TerminalPortuaria;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuitoMenorTiempo;


class CriterioCircuitoMenorTiempoTest {
	
	private CriterioCircuitoMenorTiempo criterio;
	private List<CircuitoMaritimo> lista;
	private TerminalPortuaria t1;
	private TerminalPortuaria t2;

	@BeforeEach
	void setUp() throws Exception {
		this.criterio = new CriterioCircuitoMenorTiempo();
		this.lista = new ArrayList<CircuitoMaritimo>();
		
		CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
		CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
		
		this.t1 = mock(TerminalPortuaria.class);
		this.t2 = mock(TerminalPortuaria.class);
		
		when(circuito1.tiempoEntre(t1,t2)).thenReturn(210d);
		when(circuito2.tiempoEntre(t1,t2)).thenReturn(180d);
		
		when(circuito1.contieneTerminal(t2)).thenReturn(true);
		when(circuito2.contieneTerminal(t2)).thenReturn(true);
		
		this.lista.add(circuito1);
		this.lista.add(circuito2);
	}
	
	@Test
	void buscarConListaVaciA() {		
		lista.remove(1);
		lista.remove(0);
		assertEquals(Optional.empty(), this.criterio.buscar(lista,t1,t2));
	}

	@Test
	void buscar() {		
//		no funciona a menos que haga lista.get(0)
		assertEquals(lista.get(1) , this.criterio.buscar(lista,t1,t2).get());
	}
}
