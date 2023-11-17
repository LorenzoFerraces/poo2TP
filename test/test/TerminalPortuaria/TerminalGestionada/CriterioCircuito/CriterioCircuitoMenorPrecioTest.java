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
import terminalPortuaria.TerminalGestionada.CriterioCircuito.CriterioCircuitoMenorPrecio;


class CriterioCircuitoMenorPrecioTest {
	
	private CriterioCircuitoMenorPrecio criterio;
	private List<CircuitoMaritimo> lista;

	@BeforeEach
	void setUp() throws Exception {
		this.criterio = new CriterioCircuitoMenorPrecio();
		this.lista = new ArrayList<CircuitoMaritimo>();
		Tramo tramo1 = mock(Tramo.class);
		Tramo tramo2 = mock(Tramo.class);
		Tramo tramo3 = mock(Tramo.class);
		Tramo tramo4 = mock(Tramo.class);
		
		when(tramo1.getPrecio()).thenReturn(100d);
		when(tramo2.getPrecio()).thenReturn(150d);
		when(tramo3.getPrecio()).thenReturn(200d);
		when(tramo4.getPrecio()).thenReturn(75d);
		
		CircuitoMaritimo circuito1 = mock(CircuitoMaritimo.class);
		CircuitoMaritimo circuito2 = mock(CircuitoMaritimo.class);
		
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito2.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo4);
		when(circuito2.)
		
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
		System.out.println(lista.get(0).cantidadTramos());
		System.out.println(lista.get(1).cantidadTramos());
		assertEquals(lista.get(0) , this.criterio.buscar(lista).get());
	}
}
