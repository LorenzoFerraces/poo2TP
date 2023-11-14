package test.TerminalPortuaria.TerminalGestionada.CriterioCircuito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import naviera.circuitoMaritimo.tramo.Tramo;
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuitoMenorNroDeTramos;


class CriterioCircuitoMenorNroDeTramosTest {
	
	private CriterioCircuitoMenorNroDeTramos criterio;
	private List<CircuitoMaritimo> lista;

	@BeforeEach
	void setUp() throws Exception {
		this.criterio = new CriterioCircuitoMenorNroDeTramos();
		this.lista = new ArrayList<CircuitoMaritimo>();
		
		Tramo tramo1 = mock(Tramo.class);
		Tramo tramo2 = mock(Tramo.class);
		Tramo tramo3 = mock(Tramo.class);
		Tramo tramo4 = mock(Tramo.class);
		
		CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
		CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
		
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo4);
		
		this.lista.add(circuito1);
		this.lista.add(circuito2);
	}
	
	@Test
	void buscarConListaVaciA() {		
		lista.remove(1);
		lista.remove(0);
		assertEquals(Optional.empty(), this.criterio.buscar(lista));
	}

	@Test
	void buscar() {		
//		no funciona a menos que haga lista.get(0)
		assertEquals(lista.get(1), this.criterio.buscar(lista).get());
	}
}
