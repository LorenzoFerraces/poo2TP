package filtrosDeCircuitos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import naviera.circuitoMaritimo.CircuitoMaritimo;
import viaje.Viaje;

class FiltroAndTest {
	IFiltrable filtro;
	IFiltrable operador1;
	IFiltrable operador2;
	
	Viaje viaje1;
	Viaje viaje2;
	Viaje viaje3;
	
	List<Viaje> viajes;

	@BeforeEach
	void setUp() {
		this.operador1 = mock(IFiltrable.class);
		this.operador2 = mock(IFiltrable.class);
		this.filtro = new FiltroOr(operador1, operador2);
		
		this.viaje1 = mock(Viaje.class);
		this.viaje2 = mock(Viaje.class);
		this.viaje3 = mock(Viaje.class);
		
		this.viajes = new ArrayList<Viaje>();
		
		viajes.add(viaje3);
		viajes.add(viaje2);
		viajes.add(viaje1);
		
		
	}
	
	@Test
	void alFiltrarSeLlamaALaRecursionFiltrandoSusOperadores() {
		filtro.filtrar();
		
		verify(operador1).filtrar();
		verify(operador2).filtrar();
	}
	
	

	@Test
	void elFiltroDeDosListasVaciasDebeSerUnaListaVacia() {
		when(operador1.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>());
		when(operador2.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>());
		
		assertTrue(filtro.filtrar().isEmpty());
	}
	
	@Test
	void elFiltroDeDosListasVaciasEsLaListaUnida() {
		when(operador1.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>(List.of(circuito1)));
		when(operador2.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>(List.of(circuito2)));
		
		assertEquals(filtro.filtrar().size(),2);
		assertTrue(filtro.filtrar().contains(circuito1));
		assertTrue(filtro.filtrar().contains(circuito2));
	}
	
	@Test
	void elFiltroNoIncluyeCircuitosRepetidos() {
		when(operador1.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>(List.of(circuito1)));
		when(operador2.filtrar()).thenReturn(new ArrayList<CircuitoMaritimo>(List.of(circuito1, circuito2)));
		
		assertEquals(filtro.filtrar().size(),2);
		assertTrue(filtro.filtrar().contains(circuito1));
		assertTrue(filtro.filtrar().contains(circuito2));
	}

}
