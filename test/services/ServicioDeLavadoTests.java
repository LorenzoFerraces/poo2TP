package services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import container.Container;


class ServicioDeLavadoTests {
	Container myContainer;
	IServicio myService;

	@BeforeEach
	void setUp() {
		this.myContainer = mock(Container.class);
		this.myService = new ServicioDeLavado(myContainer);
	}

	@Test
	void siEsContenedorGrandeDebeCobrarseMas() {
		when(myContainer.getMetrosCuibicos()).thenReturn(100.0);
		
		assertEquals(myService.costo(), 1500); //Precio fijado para container grande (1500)
	}
	
	@Test
	void siEsContenedorChicoDebeCobrarseMenos() {
		when(myContainer.getMetrosCuibicos()).thenReturn(50.0);
		
		assertEquals(myService.costo(), 800); //Precio fijado para container chico (800)
	}

}
